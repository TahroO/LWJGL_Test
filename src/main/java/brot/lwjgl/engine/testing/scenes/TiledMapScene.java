package brot.lwjgl.engine.testing.scenes;

import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;

import java.util.*;
import java.util.stream.Collectors;

public class TiledMapScene {

    public static void init(Scene scene) {
        String pathFormat = "/tiled/test1/%s";
        TiledMap map = XmlLoader.load(TiledMap.class, pathFormat.formatted("map2-60x40.tmx"));
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);

        TiledTileLayer tileLayer = (TiledTileLayer) map.layers.get(0);

        // Add sprites to scene.
        List<Integer> gids = tileLayer.data.getData().stream().distinct().toList();
        for (TiledTileSetRef ref : map.tilesetRefs.stream().sorted(Comparator.comparingInt(tileSetRef -> -tileSetRef.firstgid)).toList()) {
            TiledTileSet tileset = XmlLoader.load(TiledTileSet.class, pathFormat.formatted(ref.source));
            Map<Boolean, List<Integer>> groupedGids = gids.stream().collect(Collectors.groupingBy(gid -> gid >= ref.firstgid));
            groupedGids.get(true).forEach(gid -> {
                scene.addSprite(tileset.getSprite(gid, ref.firstgid));
            });
            gids = groupedGids.get(false);
        }

        // Add scene layer.
        String layerId = "tiled-" + tileLayer.id;
        SceneLayer sceneLayer = new SceneLayer(layerId);
        scene.addLayer(sceneLayer);

        // Add entities.
        int counter = 0;
        for (Entity entity : tileLayer.getEntities()) {
            int y = counter / map.width;
            int x = counter % map.width;
            entity.setPosition(x * map.tilewidth, y * map.tileheight).updateModelMatrix();
            scene.addEntity(layerId, entity);
            counter++;
        }

        TiledObjectGroup objectGroup = (TiledObjectGroup) map.layers.get(1);
    }

}

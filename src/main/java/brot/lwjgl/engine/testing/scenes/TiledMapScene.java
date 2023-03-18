package brot.lwjgl.engine.testing.scenes;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteAtlas;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Layer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TiledMapScene {

    public static void init(Scene scene) {
        String pathFormat = "/tiled/test1/%s";
        TiledMap map = XmlLoader.load(TiledMap.class, pathFormat.formatted("map1-60x40.tmx"));
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);

        TiledTileLayer tileLayer = (TiledTileLayer) map.layers.get(0);
        // Add sprites to scene.
        List<Integer> gids = tileLayer.data.getData().stream().distinct().toList();
        for (TiledTileSetRef ref : map.tilesetRefs.stream().sorted(Comparator.comparingInt(tileSetRef -> -tileSetRef.firstgid)).toList()) {
            String source = ref.source;
            TiledTileSet tileset = XmlLoader.load(TiledTileSet.class, pathFormat.formatted(source));
            Map<Integer, TiledTile> tiles = tileset.tiles == null ? new HashMap<>() : tileset.tiles.stream().collect(Collectors.toMap(TiledTile::getId, Function.identity()));
            SpriteAtlas spriteAtlas = new SpriteAtlas(pathFormat.formatted(tileset.image.source), tileset.columns, tileset.tilecount / tileset.columns);
            Map<Boolean, List<Integer>> groupedGids = gids.stream().collect(Collectors.groupingBy(gid -> gid >= ref.firstgid));
            groupedGids.get(true).forEach(gid -> {
                String spriteId = "tile-" + gid;
                scene.addSprite(new Sprite(spriteId, spriteAtlas, gid - ref.firstgid));
            });
            gids = groupedGids.get(false);
        }
        // Add scene layer.
        String layerId = "tiled-" + tileLayer.id;
        Layer sceneLayer = new Layer(layerId);
        scene.addLayer(sceneLayer);
        // Add entities.
        int counter = 0;
        for (int gid : tileLayer.data.getData()) {
            int y = counter / map.width;
            int x = counter % map.width;
            String spriteId = "tile-" + gid;
            Entity entity = new Entity("tile-" + counter, spriteId);
            entity.setPosition(x * 32, y * 32).updateModelMatrix();
            scene.addEntity(layerId, entity);
            sceneLayer.addEntity(entity);
            counter++;
        }
    }

}

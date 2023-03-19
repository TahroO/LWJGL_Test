package brot.lwjgl.engine.testing.scenes;

import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;

import java.util.*;
import java.util.stream.Collectors;

public class TiledMapScene {
    static private Map<String, TiledTileSet> tileSetCache;

    static {
        tileSetCache = new HashMap<>();
    }

    public static void init(Scene scene) {

        TiledMap map = loadXml(TiledMap.class, "map2-60x40.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);

        for (TiledLayer layer : map.layers) {
            if (layer instanceof TiledTileLayer) {
                createTileLayer(scene, map, (TiledTileLayer) layer);
            }
        }

//        TiledObjectGroup objectGroup = (TiledObjectGroup) map.layers.get(1);
    }

    private static <T> T loadXml(Class<T> cls, String resourceName) {
        String pathFormat = "/tiled/test1/%s";
        return XmlLoader.load(cls, pathFormat.formatted(resourceName));
    }

    private static TiledTileSet loadTileSet(String resourceName) {
        if (!tileSetCache.containsKey(resourceName)) {
            tileSetCache.put(resourceName, loadXml(TiledTileSet.class, resourceName));
        }
        return tileSetCache.get(resourceName);
    }

    private static void createTileLayer(Scene scene, TiledMap map, TiledTileLayer tileLayer) {
        List<Integer> gids = tileLayer.data.getData().stream().distinct().toList();
        for (TiledTileSetRef ref : map.tilesetRefs.stream().sorted(Comparator.comparingInt(tileSetRef -> -tileSetRef.firstgid)).toList()) {
            TiledTileSet tileset = loadTileSet(ref.source);
            Map<Boolean, List<Integer>> groupedGids = gids.stream().collect(Collectors.groupingBy(gid -> gid >= ref.firstgid));
            if (groupedGids.containsKey(true)) {
                groupedGids.get(true).forEach(gid -> {
                    scene.addSprite(tileset.getSprite(gid, ref.firstgid));
                });
            }
            gids = groupedGids.get(false);
        }

        // Add scene layer.
        String layerId = "tiled-" + tileLayer.id;
        SceneLayer sceneLayer = new SceneLayer(layerId);
        scene.addLayer(sceneLayer);

        // Add entities.
        int counter = 0;
        for (Entity entity : tileLayer.getEntities()) {
            if (!entity.getSpriteId().equals("tile-0")) {
                int y = counter / map.width;
                int x = counter % map.width;
                entity.setPosition(x * map.tilewidth, y * map.tileheight).updateModelMatrix();
                scene.addEntity(layerId, entity);
            }
            counter++;
        }
    }

}

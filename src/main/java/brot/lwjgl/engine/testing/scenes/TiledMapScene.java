package brot.lwjgl.engine.testing.scenes;

import brot.lwjgl.engine.scene.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;

import java.util.*;

public class TiledMapScene {

    public static void init(Scene scene) {
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "map1-60x40.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        for (TiledLayer layer : map.layers) {
            if (layer instanceof TiledTileLayer || layer instanceof TiledObjectGroup) {
                addSceneLayer(scene, map, layer);
            }
        }
    }

    private static void addSceneLayer(Scene scene, TiledMap map, TiledLayer objectLayer) {
        // Add scene layer.
        SceneLayer sceneLayer = new SceneLayer("tiled-layer-%s".formatted(objectLayer.id));
        scene.addLayer(sceneLayer);
        // Add sprites.
        objectLayer.getSprites(map).forEach(scene::addSprite);
        // Add entities.
        objectLayer.getEntities(map).forEach(entity -> scene.addEntity(sceneLayer.getId(), entity));
    }

}

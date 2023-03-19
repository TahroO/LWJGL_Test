package brot.lwjgl.engine.testing.scenes;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector3f;

import java.util.*;

import static org.lwjgl.glfw.GLFW.*;

public class TiledMapScene {
    Entity player;

    public void init(Scene scene) {
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "map-2.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        for (TiledLayer layer : map.layers) {
            if (layer instanceof TiledTileLayer || layer instanceof TiledObjectGroup) {
                SceneLayer sceneLayer = addSceneLayer(scene, map, layer);
                if (layer.id == 4) {
                    player = sceneLayer.getEntities().stream()
                            .filter(entity -> entity.getName() != null && entity.getType().equals("player"))
                            .findFirst()
                            .orElseThrow(RuntimeException::new);
                }
            }
        }
    }

    private SceneLayer addSceneLayer(Scene scene, TiledMap map, TiledLayer objectLayer) {
        // Add scene layer.
        SceneLayer sceneLayer = new SceneLayer("tiled-layer-%s".formatted(objectLayer.id));
        scene.addLayer(sceneLayer);
        // Add sprites.
        objectLayer.getSprites(map).forEach(scene::addSprite);
        // Add entities.
        objectLayer.getEntities(map).forEach(entity -> scene.addEntity(sceneLayer.getId(), entity));

        return sceneLayer;
    }

    public void input(Window window, Scene scene, long diffTimeMillis) {
        if (window.isKeyPressed(GLFW_KEY_A)) {
            player.getPosition().x -= 1.8;
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            player.getPosition().x += 1.8;
        }
        player.updateModelMatrix();

    }

    public void update(Scene scene, long diffTimeMillis) {

    }

}

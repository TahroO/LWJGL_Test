package brot.lwjgl.engine.testing.scenes;

import brot.lwjgl.engine.MouseInput;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.util.*;

import static org.lwjgl.glfw.GLFW.*;

public class TiledMapScene {
    Entity player;
    private static final float MOUSE_SENSITIVITY = 40f;
    private static final float MOVEMENT_SPEED = .3f;


    public void init(Scene scene) {
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "mossy.tmx");
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
        float move = Math.round(diffTimeMillis * MOVEMENT_SPEED);
        Camera camera = scene.getCamera();
        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveUp(move);
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveDown(move);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);
        }

        MouseInput mouseInput = window.getMouseInput();
        if (mouseInput.isRightButtonPressed()) {
            Vector2f displVec = mouseInput.getDisplVec();
            camera.moveUp(Math.round(Math.toRadians(-displVec.x * MOUSE_SENSITIVITY)));
            camera.moveRight(Math.round(Math.toRadians(-displVec.y * MOUSE_SENSITIVITY)));
        }

        Vector3f cameraPosition = camera.getPosition();
        float camY = Math.min(Math.max(cameraPosition.y, 0), scene.getHeight() - scene.getViewportHeight());
        float camX = Math.min(Math.max(cameraPosition.x, 0), scene.getWidth() - scene.getViewportWidth());
        camera.setPosition(camX, camY);
//        if (window.isKeyPressed(GLFW_KEY_A)) {
//            player.getPosition().x -= 1.8;
//            player.setOrientationX(-1);
//        } else if (window.isKeyPressed(GLFW_KEY_D)) {
//            player.getPosition().x += 1.8;
//            player.setOrientationX(1);
//        }
//        player.updateModelMatrix();

    }

    public void update(Scene scene, long diffTimeMillis) {
//        updatePlayerGravity();
    }

    private void updatePlayerGravity() {
        player.getPosition().y += 8;
    }

}

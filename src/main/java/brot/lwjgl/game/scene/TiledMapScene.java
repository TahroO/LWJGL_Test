package brot.lwjgl.game.scene;

import brot.lwjgl.engine.MouseInput;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.layers.ImageLayer;
import brot.lwjgl.engine.scene.layers.ObjectLayer;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.layers.TileLayer;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.util.*;

import static org.lwjgl.glfw.GLFW.*;

public class TiledMapScene {
    public static final float MOVE_SPEED = 1.8f;
    private static final float MOUSE_SENSITIVITY = 55f;
    private static final float MOVEMENT_SPEED = .3f;
    Entity player;

    public void init(Scene scene) {
        XmlLoader.setBasePath("/tiled/testmap/");
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "flip-tiles--image-layer.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        for (TiledLayer layer : map.layers) {
            if (layer instanceof TiledTileLayer || layer instanceof TiledObjectLayer || layer instanceof TiledImageLayer) {
                SceneLayer sceneLayer = addSceneLayer(scene, map, layer);
            }
        }
    }

    private SceneLayer addSceneLayer(Scene scene, TiledMap map, TiledLayer tiledLayer) {
        // Add scene layer.
        SceneLayer sceneLayer;
        if (tiledLayer instanceof TiledTileLayer) {
            sceneLayer = new TileLayer("tiled-layer-%s".formatted(tiledLayer.id));
        } else if (tiledLayer instanceof TiledObjectLayer) {
            sceneLayer = new ObjectLayer("tiled-layer-%s".formatted(tiledLayer.id));
        } else if (tiledLayer instanceof TiledImageLayer) {
            sceneLayer = new ImageLayer("tiled-layer-%s".formatted(tiledLayer.id));
        } else {
            throw new RuntimeException("Missing scene layer type for " + tiledLayer.getClass().getName());
        }
        scene.addLayer(sceneLayer);
        // Add sprites.
        tiledLayer.getSprites(map).forEach(sceneLayer::addSprite);
        // Add entities.
        tiledLayer.getEntities(map).forEach(sceneLayer::addEntity);
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
    }

    public void update(Scene scene, long diffTimeMillis) {
//        updatePlayerGravity();
        // Last step - resolve collision.
        scene.getLayers().stream()
                .map(layer -> layer.getCollisions(player))
                .flatMap(c -> c.entrySet().stream())
                .forEach(this::resolveCollision);
    }

    protected void resolveCollision(Map.Entry<Entity, List<SceneLayer.CollisionResultTest>> collisions) {
        for (SceneLayer.CollisionResultTest collisionResult : collisions.getValue()) {
            float deltaX = collisionResult.delta().x;
            float deltaY = collisionResult.delta().y;
            if (Math.abs(deltaX) > 0) {
                collisionResult.e2().getPosition().x += deltaX;
                collisionResult.e2().updateModelMatrix();
            }
            if (Math.abs(deltaY) <= MOVE_SPEED) {
                collisionResult.e2().getPosition().y += deltaY;
                collisionResult.e2().updateModelMatrix();
            }
        }
    }

    private void updatePlayerGravity() {
        player.getPosition().y += 8;
    }

}

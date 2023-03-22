package brot.lwjgl.engine.testing.scenes;

import brot.lwjgl.engine.MouseInput;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.layers.ObjectLayer;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.layers.TileLayer;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector2f;

import java.util.*;

import static org.lwjgl.glfw.GLFW.*;

public class TiledMapScene {
    public static final float MOVE_SPEED = 1.8f;
    Entity player;

    public void init(Scene scene) {
        XmlLoader.setBasePath("/tiled/king-pigs/");
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "map-2.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        for (TiledLayer layer : map.layers) {
            if (layer instanceof TiledTileLayer || layer instanceof TiledObjectLayer) {
                SceneLayer sceneLayer = addSceneLayer(scene, map, layer);
                if (layer.id == 4) {
                    player = sceneLayer.getEntities().stream()
                            .filter(entity -> entity.getName() != null && entity.getType().equals("player"))
                            .findFirst()
                            .orElseThrow(RuntimeException::new);
                    player.sprite = sceneLayer.getSprite("tile-308");
                }
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
        if (window.isKeyPressed(GLFW_KEY_A)) {
            player.getPosition().x -= MOVE_SPEED;
            player.setOrientationX(-1);
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            player.getPosition().x += MOVE_SPEED;
            player.setOrientationX(1);
        } else if (window.isKeyPressed(GLFW_KEY_W)) {
            player.getPosition().y -= MOVE_SPEED;
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            player.getPosition().y += MOVE_SPEED;
        }

        player.updateModelMatrix();

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

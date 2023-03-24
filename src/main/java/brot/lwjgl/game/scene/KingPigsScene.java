package brot.lwjgl.game.scene;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.GLFW.*;

public class KingPigsScene {
    public static final float MOVE_SPEED = 1.8f;
    Entity player;

    public void init(Scene scene) {
        XmlLoader.setBasePath("/tiled/king-pigs/");
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "map-2.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        Map<String, Entity> namedEntities = map.layers.stream()
                .filter(tiledLayer -> tiledLayer instanceof TiledTileLayer || tiledLayer instanceof TiledObjectLayer || tiledLayer instanceof TiledImageLayer)
                .flatMap(tiledLayer -> tiledLayer.createSceneLayer(map, scene).entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        player = namedEntities.get("king");
    }

    public void input(Window window, Scene scene, long diffTimeMillis) {
        if (window.isKeyPressed(GLFW_KEY_A)) {
            player.getPosition().x -= MOVE_SPEED;
            player.getOrientation().x = -1;
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            player.getPosition().x += MOVE_SPEED;
            player.getOrientation().x = 1;
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
//        scene.getLayers().stream()
//                .map(layer -> layer.getCollisions(player))
//                .flatMap(c -> c.entrySet().stream())
//                .forEach(this::resolveCollision);
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

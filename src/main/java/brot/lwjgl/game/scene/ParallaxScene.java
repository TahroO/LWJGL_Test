package brot.lwjgl.game.scene;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.engine.scene.entity.Player;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.tiled.TiledTileSet;
import brot.lwjgl.engine.util.XmlLoader;
import brot.lwjgl.game.scene.collision.Vector;
import org.joml.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;

public class ParallaxScene {
    private static final double PLAYER_VELOCITY = 50d;

    GameObject player;
    Sprite idleSprite;
    Sprite walkSprite;

    public void init(Window window, Scene scene) {
        Map<String, Entity> namedEntities = XmlLoader.loadSceneFullPath(scene, "/tiled/testmap/parallax-wood.tmx");
        player = (GameObject) namedEntities.get("player");
        SceneLayer playerLayer = scene.getLayer(SceneLayer.ID_FORMAT.formatted(12));
        // Idle state.
        Sprite idleSprite = playerLayer.getSprite(player.getSpriteId());
        player.addState(new GameObject.State("idle", idleSprite));
        player.switchState("idle");
        // Walk state.
        TiledTileSet tileset = XmlLoader.loadTileSet("../characters/blue-wizard/wizard-walk.tsx");
        Sprite walkSprite = tileset.getSprite(10000, 10000);
        walkSprite.addEntity(player);
        playerLayer.addSprite(walkSprite);
        player.addState(new GameObject.State("walk" , walkSprite));
    }

    public void keyEvent(int key, int action) {
    }

    public void input(Window window, Scene scene, long diffTimeMs) {
        if (window.isKeyPressed(GLFW_KEY_A)) {
            player.setVelocity(-PLAYER_VELOCITY, 0);
            if (player.getOrientation().x() >= 0) {
                player.getOrientation().x = -1;
            }
            if (player.getCurrentState().id().equals("idle")) {
                player.switchState("walk");
            }
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            if (player.getOrientation().x() <= 0) {
                player.getOrientation().x = 1;
            }
            player.setVelocity(PLAYER_VELOCITY, 0);
            if (player.getCurrentState().id().equals("idle")) {
                player.switchState("walk");
            }
        } else {
            player.setVelocity(0, 0);
            if (player.getCurrentState().id().equals("walk")) {
                player.switchState("idle");
            }
        }
    }

    public void update(Window window, Scene scene, long diffTimeMs) {
//        CameraHelper.moveCameraWithKeys(window, scene, diffTimeMs);
        player.getPosition().add(new Vector2d(player.getVelocity()).mul(1d / diffTimeMs));
        player.updateModelMatrix();
        updateCamera(scene);
    }

    private void updateCamera(Scene scene) {
        Camera camera = scene.getCamera();
        double playerX = player.getPosition().x();
        double cameraX = camera.getPosition().x();
        double playerViewportX = playerX - cameraX;
        int viewportWidth = scene.getViewportWidth();
        double scrollPosRight = viewportWidth * 0.45f;
        double scrollPosLeft = viewportWidth - (scrollPosRight + 512);
        if (player.velocity.x > 0
                && playerViewportX > scrollPosRight
                && cameraX <= scene.getWidth() - viewportWidth) {
            int newCameraX = Math.min((int) (playerX - scrollPosRight), scene.getWidth() - viewportWidth);
            camera.setPositionX(newCameraX);
        } else if (player.velocity.x < 0
                && playerViewportX < scrollPosLeft
                && cameraX >= 0) {
            int newCameraX = Math.max((int) (playerX - scrollPosLeft), 0);
            camera.setPositionX(newCameraX);
        }
    }
}

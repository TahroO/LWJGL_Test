package brot.lwjgl.engine.testing;

import brot.lwjgl.engine.MouseInput;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import org.joml.Math;
import org.joml.Vector2f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;

public class TestScenes {
    private static final float MOUSE_SENSITIVITY = 40f;
    private static final float MOVEMENT_SPEED = .3f;


    public static void testAnimationFrames() {
        float[] durations = new float[]{0f, .2f, .7f, 1.1f};
        float totalDuration = 2f;
        float[] times = new float[]{0.00001f, 0.00017f, 0.13f, 0.37f, 0.8f, 1.2f, 2.001f};
        for (float time : times) {
            float x = time - totalDuration * (float) Math.floor(time / totalDuration);
            for (int i = durations.length - 1; i >= 0; i--) {
                if (x >= durations[i]) {
                    break;
                }
            }
        }
    }

    public static void inputMoveCamera(Window window, Scene scene, long diffTimeMillis) {
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

    public static void initTestSprite(Scene scene) {
        SpriteSheet s = new SpriteSheet("/tiled/testmap/test-texture.png", 1, 1);
        Sprite sprite = new Sprite("test-1", s, 0);
        SceneLayer l = new SceneLayer("test");
        scene.addLayer(l);
        l.addSprite(sprite);

        Entity e = new Entity("test-1", "test-1");
        e.flipH();
        e.flipV();
        e.flipD();
        l.addEntity(e);

//        e = new Entity("test-2", "test-1");
//        e.setPosition(32, 0).updateModelMatrix();
//        e.flipV();
//        l.addEntity(e);
//
//        e = new Entity("test-3", "test-1");
//        e.setPosition(64, 0).updateModelMatrix();
//        e.flipH();
//        e.flipV();
//        l.addEntity(e);

//        e = new Entity("test-2", "test-1");
//        e.setPosition(32, 0).updateModelMatrix();
//        l.addEntity(e);
//
//        e = new Entity("test-2", "test-1");
//        e.setPosition(32, 0).updateModelMatrix();
//        l.addEntity(e);
//
//        e = new Entity("test-2", "test-1");
//        e.setPosition(32, 0).updateModelMatrix();
//        l.addEntity(e);
//
//        e = new Entity("test-2", "test-1");
//        e.setPosition(32, 0).updateModelMatrix();
//        l.addEntity(e);
//
//        e = new Entity("test-2", "test-1");
//        e.setPosition(32, 0).updateModelMatrix();
//        l.addEntity(e);
//
//        e = new Entity("test-2", "test-1");
//        e.setPosition(32, 0).updateModelMatrix();
//        l.addEntity(e);
//
//        //        e.flipD();
////        e.flipH();
//        e.flipV();
    }

}

package brot.lwjgl.game;

import brot.lwjgl.engine.*;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.testing.scenes.TiledMapScene;
import brot.lwjgl.engine.testing.scenes.WalkingDudeScene;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Scene;
import org.joml.Math;
import org.joml.Vector2f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

/**
 * TODO
 * - entity fps
 * - entity start, stop animation
 * - entity multiple sprites, animations
 * - entity switch sprite
 * - layer show, hide
 */
public class Main implements AppLogic {
    private static final float MOUSE_SENSITIVITY = 40f;
    private static final float MOVEMENT_SPEED = .3f;

    public static void main(String[] args) {
        Main main = new Main();
        Window.WindowOptions windowOptions = new Window.WindowOptions();
        windowOptions.width = 640;
        windowOptions.height = 640;
        Engine gameEng = new Engine("chapter-02", windowOptions, main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
//        WalkingDudeScene.init(scene);
        TiledMapScene.init(scene);
    }

    @Override
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

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
//        WalkingDudeScene.update(scene);
    }

}
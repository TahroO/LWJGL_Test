package brot.lwjgl.game;

import brot.lwjgl.engine.AppLogic;
import brot.lwjgl.engine.Engine;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.testing.TestScenes;

/**
 * TODO
 * - entity fps
 * - entity start, stop animation
 * - entity multiple sprites, animations
 * - entity switch sprite
 * - layer show, hide
 */
public class TestMain implements AppLogic {
    private static final float MOUSE_SENSITIVITY = 1f;
    private static final float MOVEMENT_SPEED = 0.5f;
    private Entity dude;
    private float dudePositionX = -32f;

    public static void main(String[] args) {
        TestMain main = new TestMain();
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
        TestScenes.testAnimationFrames();
    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis) {
    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
    }

    @Override
    public void keyEvent(int key, int action) {

    }

}
package brot.lwjgl.game;

import brot.lwjgl.engine.*;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.testing.scenes.TiledMapScene;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.game.scene.GraveScene;

/**
 * TODO
 * - entity fps
 * - entity start, stop animation
 * - entity multiple sprites, animations
 * - entity switch sprite
 * - layer show, hide
 */
public class Main implements AppLogic {
    private GraveScene tiledMapScene;

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
        tiledMapScene = new GraveScene();
        tiledMapScene.init(scene);
    }

    @Override
    public void input(Window window, Scene scene, long timeDelta) {
        tiledMapScene.input(window, scene, timeDelta);
    }

    @Override
    public void update(Window window, Scene scene, long timeDelta) {
        tiledMapScene.update(scene, timeDelta);
    }

}
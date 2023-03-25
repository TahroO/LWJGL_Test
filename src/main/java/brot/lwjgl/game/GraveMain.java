package brot.lwjgl.game;

import brot.lwjgl.engine.AppLogic;
import brot.lwjgl.engine.Engine;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.game.scene.GraveScene;
import brot.lwjgl.game.scene.TiledMapScene;

/**
 * TODO
 * - entity fps
 * - entity start, stop animation
 * - entity multiple sprites, animations
 * - entity switch sprite
 * - layer show, hide
 */
public class GraveMain implements AppLogic {
    private GraveScene graveScene;

    public static void main(String[] args) {
        GraveMain main = new GraveMain();
        Window.WindowOptions windowOptions = new Window.WindowOptions();
        windowOptions.width = 640;
        windowOptions.height = 416;
        Engine gameEng = new Engine("chapter-02", windowOptions, main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
        graveScene = new GraveScene();
        graveScene.init(scene);
    }

    @Override
    public void input(Window window, Scene scene, long timeDelta) {
        graveScene.input(window, scene, timeDelta);
    }

    @Override
    public void update(Window window, Scene scene, long timeDelta) {
//        tiledMapScene.update(scene, timeDelta);
    }

    @Override
    public void keyEvent(int key, int action) {

    }

}
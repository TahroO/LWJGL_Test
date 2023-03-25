package brot.lwjgl.game;

import brot.lwjgl.engine.AppLogic;
import brot.lwjgl.engine.Engine;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.game.scene.KingPigsScene;
import brot.lwjgl.game.scene.MossyScene;

/**
 * TODO
 * - entity fps
 * - entity start, stop animation
 * - entity multiple sprites, animations
 * - entity switch sprite
 * - layer show, hide
 */
public class MossyMain implements AppLogic {
    private MossyScene mossyScene;

    public static void main(String[] args) {
        MossyMain main = new MossyMain();
        Window.WindowOptions windowOptions = new Window.WindowOptions();
        windowOptions.width = 1280;
        windowOptions.height = 960;
        Engine gameEng = new Engine("Mossy", windowOptions, main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
        mossyScene = new MossyScene();
        mossyScene.init(window, scene);
    }

    @Override
    public void input(Window window, Scene scene, long timeDelta) {
        mossyScene.input(window, scene, timeDelta);
    }

    @Override
    public void update(Window window, Scene scene, long timeDelta) {
//        tiledMapScene.update(scene, timeDelta);
        mossyScene.update(scene, timeDelta);
    }

    @Override
    public void keyEvent(int key, int action) {

    }

}
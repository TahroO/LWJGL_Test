package brot.lwjgl.game;

import brot.lwjgl.engine.AppLogic;
import brot.lwjgl.engine.Engine;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.game.scene.KingPigsScene;
import brot.lwjgl.game.scene.TiledMapScene;

/**
 * TODO
 * - entity fps
 * - entity start, stop animation
 * - entity multiple sprites, animations
 * - entity switch sprite
 * - layer show, hide
 */
public class KingPigsMain implements AppLogic {
    private KingPigsScene kingPigsScene;

    public static void main(String[] args) {
        KingPigsMain main = new KingPigsMain();
        Window.WindowOptions windowOptions = new Window.WindowOptions();
        windowOptions.width = 640;
        windowOptions.height = 640;
        Engine gameEng = new Engine("King and Pigs", windowOptions, main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
        kingPigsScene = new KingPigsScene();
        kingPigsScene.init(scene);
    }

    @Override
    public void input(Window window, Scene scene, long timeDelta) {
        kingPigsScene.input(window, scene, timeDelta);
    }

    @Override
    public void update(Window window, Scene scene, long timeDelta) {
//        tiledMapScene.update(scene, timeDelta);
    }

}
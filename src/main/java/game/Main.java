package game;

import brot.lwjgl.engine.*;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.scene.Scene;

import java.awt.event.KeyEvent;

public class Main implements AppLogic {
    private int direction = 0;
    private float color = 0f;
    private Render render;

    public static void main(String[] args) {
        Main main = new Main();
        Window.WindowOptions windowOptions = new Window.WindowOptions();
        windowOptions.width = 800;
        windowOptions.height = 600;
        Engine gameEng = new Engine("chapter-02", windowOptions, main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
        this.render = render;
    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis) {
        if ( window.isKeyPressed(KeyEvent.VK_UP) ) {
            direction = 1;
        } else if ( window.isKeyPressed(KeyEvent.VK_DOWN) ) {
            direction = -1;
        } else {
            direction = 0;
        }
    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        color += direction * 0.01f;
        if (color > 1) {
            color = 1.0f;
        } else if ( color < 0 ) {
            color = 0.0f;
        }
    }

}
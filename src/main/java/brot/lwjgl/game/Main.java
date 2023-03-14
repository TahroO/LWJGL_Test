package brot.lwjgl.game;

import brot.lwjgl.engine.*;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.mesh.Quad;
import brot.lwjgl.engine.scene.Scene;
import org.lwjgl.glfw.GLFW;

public class Main implements AppLogic {
    private int direction = 0;
    private float clearColor = 0f;

    public static void main(String[] args) {
        Main main = new Main();
        Window.WindowOptions windowOptions = new Window.WindowOptions();
        windowOptions.width = 800;
        windowOptions.height = 800;
        Engine gameEng = new Engine("chapter-02", windowOptions, main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
        float[] textureCoordinates = new float[]{0f, 0f, 0f, .5f, .25f, .5f, .25f, 0f};
        Mesh mesh = new Quad(1, 1, textureCoordinates);
        String cubeModelId = "bird-sprite";
        scene.addMesh(cubeModelId, mesh);
    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis) {
        if (window.isKeyPressed(GLFW.GLFW_KEY_UP)) {
            direction = 1;
        } else if (window.isKeyPressed(GLFW.GLFW_KEY_DOWN)) {
            direction = -1;
        } else {
            direction = 0;
        }
    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        clearColor += direction * 0.01f;
        if (clearColor > 1) {
            clearColor = 1.0f;
        } else if (clearColor < 0) {
            clearColor = 0.0f;
        }
        window.setClearColor(clearColor, clearColor, clearColor);
    }

}
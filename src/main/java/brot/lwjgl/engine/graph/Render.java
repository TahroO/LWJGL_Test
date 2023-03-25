package brot.lwjgl.engine.graph;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.testing.TestSceneRender;
import org.lwjgl.opengl.GL;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_MULTISAMPLE;

public class Render {
    private SceneRender sceneRender;
    private TestSceneRender testSceneRender;

    public Render() {
        GL.createCapabilities();
        glEnable(GL_MULTISAMPLE);
        sceneRender = new SceneRender();
        testSceneRender = new TestSceneRender();
    }

    public void cleanup() {
        sceneRender.cleanup();
    }

    public void render(Window window, Scene scene) {
        glClear(GL_COLOR_BUFFER_BIT);
        int targetWidth = scene.getViewportWidth();
        int targetHeight = scene.getViewportHeight();
        int marginX = (window.getWidth() - targetWidth) / 2;
        int marginY = (window.getHeight() - targetHeight) / 2;
        glViewport(0, 0, window.getWidth(), window.getHeight());

        sceneRender.render(scene);
    }
}
package brot.lwjgl.engine.graph;

import org.lwjgl.opengl.GL;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.Scene;

import static org.lwjgl.opengl.GL11.*;

public class Render {
    protected final SceneRender sceneRender;

    public Render() {
        GL.createCapabilities();
        sceneRender = new SceneRender();
    }

    public void cleanup() {
        // Nothing to be done here yet
    }

    public void render(Window window, Scene scene) {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glViewport(0, 0, window.getWidth(), window.getHeight());
        sceneRender.render(scene);;
    }

}

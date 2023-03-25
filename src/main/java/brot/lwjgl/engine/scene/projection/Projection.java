package brot.lwjgl.engine.scene.projection;

import org.joml.Matrix4f;

abstract public class Projection {
    protected int initialWidth;
    protected int initialHeight;

    protected int sceneWidth;
    protected int sceneHeight;
    protected int viewportWidth;
    protected int viewportHeight;
    protected int windowWidth;
    protected int windowHeight;
    protected float scaleFactor = 1f;

    protected Matrix4f projMatrix;

    public Projection(int width, int height) {
        projMatrix = new Matrix4f();
        initialWidth = width;
        initialHeight = height;
        windowWidth = width;
        windowHeight = height;
        updateProjMatrix(width, height);
    }

    public Matrix4f getProjMatrix() {
        return projMatrix;
    }

    abstract public void updateProjMatrix(int width, int height);

}

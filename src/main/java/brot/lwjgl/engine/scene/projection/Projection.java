package brot.lwjgl.engine.scene.projection;

import org.joml.Matrix4f;

abstract public class Projection {
    protected int initialWidth;
    protected int initialHeight;

    protected Matrix4f projMatrix;

    public Projection(int width, int height) {
        projMatrix = new Matrix4f();
        initialWidth = width;
        initialHeight = height;
        updateProjMatrix(width, height);
    }

    public Matrix4f getProjMatrix() {
        return projMatrix;
    }

    abstract public void updateProjMatrix(int width, int height);

}

package brot.lwjgl.engine.scene;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class Camera {
    private Vector3f position;
    private Vector3f right;
    private Vector3f up;
    private Matrix4f viewMatrix;
    private float rot;

    public Camera() {
        right = new Vector3f();
        up = new Vector3f();
        position = new Vector3f();
        viewMatrix = new Matrix4f();
    }

    public void addRotation(float angle) {
        rot += angle;
        recalculate();
    }

    public Vector3f getPosition() {
        return position;
    }

    public Matrix4f getViewMatrix() {
        return viewMatrix;
    }

    public void moveDown(float inc) {
        viewMatrix.positiveY(up).mul(inc);
        position.sub(up);
        recalculate();
    }

    public void moveLeft(float inc) {
        viewMatrix.positiveX(right).mul(inc);
        position.sub(right);
        recalculate();
    }

    public void moveRight(float inc) {
        viewMatrix.positiveX(right).mul(inc);
        position.add(right);
        recalculate();
    }

    public void moveUp(float inc) {
        viewMatrix.positiveY(up).mul(inc);
        position.add(up);
        recalculate();
    }

    private void recalculate() {
        viewMatrix.identity()
                .rotateZ(rot)
                .translate(-position.x, -position.y, 0);
    }

    public void setPosition(float x, float y) {
        position.set(x, y, 0);
        recalculate();
    }

    public void setRotation(float angle) {
        rot = angle;
        recalculate();
    }

}
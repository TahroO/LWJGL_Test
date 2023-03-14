package brot.lwjgl.engine.scene.projection;

public class OrthographicProjection extends Projection {

    public OrthographicProjection(int width, int height) {
        super(width, height);
    }

    @Override
    public void updateProjMatrix(int width, int height) {
        float v = (float) width / (float) height;

        float scale = (float) width / (float) initialWidth / v;
        if (v >= 1f) {
            projMatrix.setOrtho2D(-v * scale, v * scale, -1f * scale, 1f * scale);
        } else {
            projMatrix.setOrtho2D(-1f * scale, 1f * scale, 1f / -v * scale, 1f / v * scale);
        }
    }

}

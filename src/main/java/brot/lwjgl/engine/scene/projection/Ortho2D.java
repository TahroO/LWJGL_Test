package brot.lwjgl.engine.scene.projection;

/**
 * Defines a projection for a 2D coordinate system with
 * its origin at viewport's top left position.
 */
public class Ortho2D extends Projection {

    /**
     * Creates a new Ortho2D object.
     * @param width Viewport width in pixel.
     * @param height Viewport height in pixel.
     */
    public Ortho2D(int width, int height) {
        super(width, height);
    }

    @Override
    public void updateProjMatrix(int width, int height) {
          projMatrix.setOrtho2D(0, 640, 640, 0);
//        projMatrix.setOrtho2D(-1, 1, -1, 1);
    }

}

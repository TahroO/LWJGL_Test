package brot.lwjgl.engine.scene.projection;

/**
 * Defines a projection for a 2D coordinate system with
 * its origin at viewport's top left position.
 */
public class Ortho2D extends Projection {

    /**
     * Creates a new Ortho2D object.
     *
     * @param windowWidth  Viewport width in pixel.
     * @param windowHeight Viewport height in pixel.
     */
    public Ortho2D(int windowWidth, int windowHeight, int sceneWidth, int sceneHeight) {
        super(windowWidth, windowHeight);
        this.viewportWidth = sceneWidth;
        this.viewportHeight = sceneHeight;
        updateProjMatrix(windowWidth, windowHeight);
    }

    /**
     * - fit viewport to window: keep aspect ratio
     * - fit scene to viewport
     * - scale factor scene
     */


    @Override
    public void updateProjMatrix(int framebufferWidth, int framebufferHeight) {
        projMatrix.setOrtho2D(0, viewportWidth, viewportHeight, 0);
    }

}

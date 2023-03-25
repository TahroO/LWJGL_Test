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
        this.sceneWidth = 5120;
        this.sceneHeight = 5120;
        this.viewportWidth = sceneWidth;
        this.viewportHeight = sceneHeight;
        updateProjMatrix(0, 0);
    }

    /**
     * - fit viewport to window: keep aspect ratio
     * - fit scene to viewport
     * - scale factor scene
     */


    @Override
    public void updateProjMatrix(int framebufferWidth, int framebufferHeight) {
        // Bottom up.
//        projMatrix.setOrtho2D(sceneWidth, 0, 0, sceneHeight);
        projMatrix.setOrtho2D(0, viewportWidth, viewportHeight, 0);
        // Top down.
    }

}

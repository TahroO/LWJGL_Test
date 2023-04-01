package brot.lwjgl.engine.scene.layer;

import brot.lwjgl.engine.scene.Scene;
import org.joml.Matrix4f;
import org.joml.Vector2f;

public class ImageLayer extends SceneLayer {
    protected float imageWidth;
    protected float imageHeight;

    /**
     * Creates a new ImageLayer object.
     *
     * @param id Layer ID.
     */
    public ImageLayer(String id, float imageWidth, float imageHeight) {
        super(id);
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public Vector2f getDisplacement(Scene scene) {
        Matrix4f viewMatrix = scene.getCamera().getViewMatrix();
        float viewportWidth = scene.getViewportWidth();
        float viewportX = viewMatrix.m30();
        float offsetX = (1 - parallaxFactor.x) * -0.5f * (viewportWidth / imageWidth);
        float displace = offsetX + viewportX / (imageWidth / (1f - parallaxFactor.x));
        return new Vector2f(displace, 0);
    }

}

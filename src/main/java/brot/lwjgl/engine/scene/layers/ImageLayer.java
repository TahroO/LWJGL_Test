package brot.lwjgl.engine.scene.layers;

import org.joml.Matrix4f;
import org.joml.Vector2f;

import java.util.Vector;

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

    public Vector2f getDisplacement(Matrix4f viewMatrix) {
        float viewportWidth = 640;
        float viewportX = viewMatrix.m30();
        float parallaxFactorX = .5f;

        float offsetX = (1 - parallaxFactor.x) * -0.5f * (viewportWidth / imageWidth);
        float displace = offsetX - .2f; // (.75) + 0.1875f; // (.5) + .125f;
        displace = offsetX + viewportX / (imageWidth / (1f - parallaxFactor.x));
        return new Vector2f(displace, 0);
    }

}

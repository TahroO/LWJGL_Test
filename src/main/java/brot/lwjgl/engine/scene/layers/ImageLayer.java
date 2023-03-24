package brot.lwjgl.engine.scene.layers;

import org.joml.Matrix4f;
import org.joml.Vector2f;

import java.util.Vector;

public class ImageLayer extends SceneLayer {
    /**
     * Creates a new ImageLayer object.
     *
     * @param id Layer ID.
     */
    public ImageLayer(String id) {
        super(id);
    }

    public Vector2f getDisplacement(Matrix4f viewMatrix) {
        float textureWidth = 640;
        float layerWidth = 960;
        float viewportX = viewMatrix.m30();
        float parallaxFactorX = 1;
        float displace = -1 * viewportX / 2560f;
        return new Vector2f(displace, 0);
    }

}

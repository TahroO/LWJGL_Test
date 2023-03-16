package brot.lwjgl.engine.graph.texture;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.mesh.Quad;
import org.joml.Vector2f;

/**
 * Defines a sprite atlas texture.
 */
public class SpriteAtlas extends Texture {
    /**
     * Number of sprites per column and row.
     */
    protected final Vector2f size;
    protected Mesh mesh;
    protected Vector2f spriteSize;

    /**
     * Creates a new SpriteAtlas object.
     *
     * @param resourceName Name of an image resource.
     * @param columns      Number of sprite columns.
     * @param rows         Number of sprite rows.
     */
    public SpriteAtlas(String resourceName, int columns, int rows) {
        super(resourceName);
        size = new Vector2f(columns, rows);
        spriteSize = new Vector2f(this.width / (float) columns, this.height / (float) rows);
        mesh = new Quad(spriteSize.x, spriteSize.y, getTextureCoordinates());
    }

    /**
     * Gets the size in sprites per column and row.
     */
    public Vector2f getSize() {
        return size;
    }

    public float getSpriteAspectRatio() {
        return ((float) width / (float) height) / (size.x / size.y);
    }

    public Mesh getSpriteMesh() {
        return mesh;
    }

    public float[] getTextureCoordinates() {
        return new float[]{
                0f, 0f,
                0f, 1f / size.y,
                1f / size.x, 1f / size.y,
                1f /  size.x, 0f
        };
    }

}

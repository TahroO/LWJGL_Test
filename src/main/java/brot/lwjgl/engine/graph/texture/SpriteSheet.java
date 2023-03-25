package brot.lwjgl.engine.graph.texture;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.mesh.Quad;
import org.joml.Vector2f;
import org.joml.Vector2i;

/**
 * Defines a sprite sheet texture.
 */
public class SpriteSheet extends Texture {
    /**
     * Number of sprites per column and row.
     */
    protected final Vector2i size;
    protected Mesh mesh;
    protected Vector2f spriteSize;

    /**
     * Creates a new SpriteAtlas object.
     *
     * @param resourceName Name of an image resource file.
     * @param columns      Number of sprite columns.
     * @param rows         Number of sprite rows.
     */
    public SpriteSheet(String resourceName, int columns, int rows) {
        this(resourceName, null, columns, rows);
    }

    public SpriteSheet(String resourceName, Mesh mesh, int columns, int rows) {
        super(resourceName);
        size = new Vector2i(columns, rows);
        spriteSize = new Vector2f(this.width / (float) columns, this.height / (float) rows);
        this.mesh = mesh == null ? new Quad(spriteSize.x, spriteSize.y, getTextureCoordinates(size.x, size.y)) : mesh;
    }

    /**
     * Gets the size in sprites per column and row.
     */
    public Vector2i getSize() {
        return size;
    }

    /**
     * Gets the sprite mesh.
     */
    public Mesh getSpriteMesh() {
        return mesh;
    }

    public Vector2f getSpriteSize() {
        return spriteSize;
    }

    /**
     * Gets texture UV coordinates.
     */
    public static float[] getTextureCoordinates(float sizeX, float sizeY) {
        return new float[]{
                0f, 0f,
                0f, 1f / sizeY,
                1f / sizeX, 1f / sizeY,
                1f /  sizeX, 0f
        };
    }

}

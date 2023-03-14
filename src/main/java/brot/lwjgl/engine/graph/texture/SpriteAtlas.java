package brot.lwjgl.engine.graph.texture;

import org.joml.Vector2f;

public class SpriteAtlas extends Texture {
    protected final Vector2f size;

    public SpriteAtlas(String resourceName, int rows, int columns) {
        super(resourceName);
        size = new Vector2f(columns, rows);
    }

    public Vector2f getSize() {
        return size;
    }

}

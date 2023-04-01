package brot.lwjgl.engine.scene.entity;

import org.joml.Vector2f;

public interface AABB {
    Vector2f getCenter();

    Vector2f getHalfExtents();
}

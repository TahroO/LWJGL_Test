package brot.lwjgl.engine.scene.entity;

import org.joml.Vector2d;
import org.joml.Vector2f;

public interface AABB {
    Vector2d getCenter();

    Vector2d getHalfExtents();
}

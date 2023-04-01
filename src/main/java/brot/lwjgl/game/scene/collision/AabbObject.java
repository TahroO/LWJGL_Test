package brot.lwjgl.game.scene.collision;

import brot.lwjgl.engine.scene.entity.AABB;
import com.google.common.base.Preconditions;
import org.joml.Vector2f;

public class AabbObject implements AABB {
    public Vector2f centerPoint;
    public Vector2f halfExtents;

    public AabbObject() {
        this(null, null);
    }

    public AabbObject(Vector2f centre, Vector2f halfExtents) {
        initialise(centre, halfExtents);
    }

    public void initialise(Vector2f center, Vector2f halfExtents) {
        this.centerPoint = center;
        this.halfExtents = halfExtents;
        if (halfExtents != null) {
            Preconditions.checkArgument(halfExtents.x >= 0 && halfExtents.y >= 0, "must have positive extents");
        }
    }

    @Override
    public Vector2f getCenter() {
        return centerPoint;
    }

    @Override
    public Vector2f getHalfExtents() {
        return halfExtents;
    }

}

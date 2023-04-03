package brot.lwjgl.game.scene.collision;

import brot.lwjgl.engine.scene.entity.AABB;
import com.google.common.base.Preconditions;
import org.joml.Vector2d;
import org.joml.Vector2f;

public class AabbObject implements AABB {
    public Vector2d centerPoint;
    public Vector2d halfExtents;

    public AabbObject() {
        this(null, null);
    }

    public AabbObject(Vector2d centre, Vector2d halfExtents) {
        initialise(centre, halfExtents);
    }

    public void initialise(Vector2d center, Vector2d halfExtents) {
        this.centerPoint = center;
        this.halfExtents = halfExtents;
        if (halfExtents != null) {
            Preconditions.checkArgument(halfExtents.x >= 0 && halfExtents.y >= 0, "must have positive extents");
        }
    }

    @Override
    public Vector2d getCenter() {
        return centerPoint;
    }

    @Override
    public Vector2d getHalfExtents() {
        return halfExtents;
    }

}

package brot.lwjgl.game.scene.collision;

import brot.lwjgl.engine.scene.entity.AABB;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.scene.layer.TileLayer;
import brot.lwjgl.game.scene.CollisionScene;
import org.joml.Vector2d;
import org.joml.Vector2f;

import java.util.Map;

public class Collide {

    public static boolean AabbVsAabb(AABB a, AabbObject b, Contact outContact, int tileI, int tileJ, SceneLayer layer, boolean checkInternal) {
        Vector2d combinedExtentsB = Vector.addTo(new Vector2d(b.halfExtents), a.getHalfExtents());
        Vector2d combinedPosB = b.getCenter();
        Vector2d delta = Vector.sub(combinedPosB, a.getCenter());
        AabbVsAabbInternal(delta, combinedPosB, combinedExtentsB, a.getCenter(), outContact);

        // check for internal edges
//        if (checkInternal) {
//            return !IsInternalCollision(tileI, tileJ, outContact.m_normal, layer);
//        } else {
//            return true;
//        }
        return true;
    }

    static public boolean AabbVsAabbInternal(Vector2d delta, Vector2d aabbCentre, Vector2d aabbHalfExtents, Vector2d point, Contact outContact) {
        // form the closest plane to the point
        Vector2d planeN = Vector.negTo(Vector.majorAxis(delta));
        Vector2d planeCentre = Vector.addTo(Vector.mul(planeN, aabbHalfExtents), aabbCentre);

        // distance point from plane
        Vector2d planeDelta = Vector.sub(point, planeCentre);
        double dist = Vector.dot(planeDelta, planeN);

        // form point

        // build and push
        outContact.Initialise(planeN, dist, point);

        // collision?
        return true;
    }
}

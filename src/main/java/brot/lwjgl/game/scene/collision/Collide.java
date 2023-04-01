package brot.lwjgl.game.scene.collision;

import brot.lwjgl.engine.scene.entity.AABB;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.game.scene.CollisionScene;
import org.joml.Vector2f;

import java.util.Map;

public class Collide {
    /// <summary>
    /// Helper function which checks for internal edges
    /// </summary>
    static private boolean IsInternalCollision(int tileI, int tileJ, Vector2f normal, Map<String, Entity> tiles) {
        int nextTileI = tileI + (int) normal.x;
        int nextTileJ = tileJ + (int) normal.y;
        int nextTileIndex = nextTileJ * CollisionScene.mapSize.x + nextTileI;
        return tiles.get(Entity.ID_FORMAT.formatted(1, nextTileIndex)).sprite.hasCollisionData();
    }

    public static boolean AabbVsAabb(AABB a, AabbObject b, Contact outContact, int tileI, int tileJ, Map<String, Entity> tiles, boolean checkInternal) {
        Vector2f combinedExtentsB = Vector.addTo(new Vector2f(b.halfExtents), a.getHalfExtents());
        Vector2f combinedPosB = b.getCenter();
        Vector2f delta = Vector.sub(combinedPosB, a.getCenter());
        AabbVsAabbInternal(delta, combinedPosB, combinedExtentsB, a.getCenter(), outContact);

        //
        // check for internal edges
        //
        if (checkInternal) {
            return !IsInternalCollision(tileI, tileJ, outContact.m_normal, tiles);
        } else {
            return true;
        }
    }

    static public boolean AabbVsAabbInternal(Vector2f delta, Vector2f aabbCentre, Vector2f aabbHalfExtents, Vector2f point, Contact outContact) {
        // form the closest plane to the point
        Vector2f planeN = Vector.negTo(Vector.majorAxis(delta));
        Vector2f planeCentre = Vector.addTo(Vector.mul(planeN, aabbHalfExtents), aabbCentre);

        // distance point from plane
        Vector2f planeDelta = Vector.sub(point, planeCentre);
        float dist = Vector.dot(planeDelta, planeN);

        // form point

        // build and push
        outContact.Initialise(planeN, dist, point);

        // collision?
        return true;
    }
}

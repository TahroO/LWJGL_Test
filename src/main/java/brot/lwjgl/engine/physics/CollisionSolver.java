package brot.lwjgl.engine.physics;

import brot.lwjgl.engine.scene.layer.SceneLayer;
import org.joml.Vector4d;
import org.joml.Vector4f;

public class CollisionSolver {
    public static float STICKY_THRESHOLD = .0004f;
//    public static SceneLayer.CollisionResultTest resolveElastic(PhysicsEntity player, PhysicsEntity entity) {
//        var pMidX = player.getMidX();
//        var pMidY = player.getMidY();
//        var aMidX = entity.getMidX();
//        var aMidY = entity.getMidY();
//
//        // To find the side of entry calculate based on
//        // the normalized sides
//        var dx = (aMidX - pMidX) / entity.halfWidth;
//        var dy = (aMidY - pMidY) / entity.halfHeight;
//
//        // Calculate the absolute change in x and y
//        var absDX = Math.abs(dx);
//        var absDY = Math.abs(dy);
//
//        double playerX = 0, playerY = 0;
//        double playerVx = 0, playerVy = 0;
//        // If the distance between the normalized x and y
//        // position is less than a small threshold (.1 in this case)
//        // then this object is approaching from a corner
//        if (Math.abs(absDX - absDY) < .1) {
//            // If the player is approaching from positive X
//            if (dx < 0) {
//                // Set the player x to the right side
//                playerX = entity.getRight() - player.getLeft();
//                // If the player is approaching from negative X
//            } else {
//                // Set the player x to the left side
//                playerX = entity.getLeft() - player.getRight();
//            }
//            // If the player is approaching from positive Y
//            if (dy < 0) {
//                // Set the player y to the bottom
//                playerY = entity.getBottom() - player.getTop();
//                // If the player is approaching from negative Y
//            } else {
//                // Set the player y to the top
//                playerY = entity.getTop() - player.getBottom();
//            }
//
//            // Randomly select a x/y direction to reflect velocity on
//            if (Math.random() < .5) {
//                // Reflect the velocity at a reduced rate
//                playerVx = -playerVx * entity.restitution;
//
//                // If the object's velocity is nearing 0, set it to 0
//                // STICKY_THRESHOLD is set to .0004
//                if (Math.abs(playerVx) < STICKY_THRESHOLD) {
//                    playerVx = 0;
//                }
//            } else {
//
//                playerVy = -playerVy * entity.restitution;
//                if (Math.abs(playerVy) < STICKY_THRESHOLD) {
//                    playerVy = 0;
//                }
//            }
//
//            // If the object is approaching from the sides
//        } else if (absDX > absDY) {
//            // If the player is approaching from positive X
//            if (dx < 0) {
//                playerX = entity.getRight() - player.getLeft();
//            } else {
//                // If the player is approaching from negative X
//                playerX = entity.getLeft() - player.getRight();
//            }
//
//            // Velocity component
//            playerVx = -playerVx * entity.restitution;
//
//            if (Math.abs(playerVx) < STICKY_THRESHOLD) {
//                playerVx = 0;
//            }
//
//            // If this collision is coming from the top or bottom more
//        } else {
//
//            // If the player is approaching from positive Y
//            if (dy < 0) {
//                playerY = entity.getBottom() - player.getTop();
//
//            } else {
//                // If the player is approaching from negative Y
//                playerY = entity.getTop() - player.getBottom();
//            }
//
//            // Velocity component
//            playerVy = -playerVy * entity.restitution;
//            if (Math.abs(playerVy) < STICKY_THRESHOLD) {
//                playerVy = 0;
//            }
//        }
//        return new SceneLayer.CollisionResultTest(player.target, new Vector4d(playerX, playerY, playerVx, playerVy), entity.target);
//    }

   enum Method {
        /**
         * // The displace resolution will only move an entity
         * // outside of the space of the other and zero the
         * // velocity in that direction
         */
        DISPLACE,

        /**
         * // The elastic resolution will displace and also bounce
         * // the colliding entity off by reducing the velocity by
         * // its restituion coefficient
         */
        ELASTIC
    }
}

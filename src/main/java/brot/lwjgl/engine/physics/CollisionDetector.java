package brot.lwjgl.engine.physics;

public class CollisionDetector {
    private static CollisionDetector instance = new CollisionDetector();

    public boolean collideRect(PhysicsEntity collider, PhysicsEntity collidee) {
        float l1 = collider.getLeft();
        float r1 = collider.getRight();
        float t1 = collider.getTop();
        float b1 = collider.getBottom();

        float l2 = collidee.getLeft();
        float r2 = collidee.getRight();
        float t2 = collidee.getTop();
        float b2 = collidee.getBottom();

        // If any of the edges are beyond any of the others,
        // then we know that the box cannot be colliding.
        if (b1 < t2 || t1 > b2 || r1 < l2 || l1 > r2) {
            return false;
        }

        // If the algorithm made it here, it had to collide.
        return true;
    }

    public static CollisionDetector getInstance() {
        return instance;
    }
}

package brot.lwjgl.engine.physics;

public class CollisionDetector {
    private static CollisionDetector instance = new CollisionDetector();

    public boolean collideRect(PhysicsEntity collider, PhysicsEntity collidee) {
        double l1 = collider.getLeft();
        double r1 = collider.getRight();
        double t1 = collider.getTop();
        double b1 = collider.getBottom();

        double l2 = collidee.getLeft();
        double r2 = collidee.getRight();
        double t2 = collidee.getTop();
        double b2 = collidee.getBottom();

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

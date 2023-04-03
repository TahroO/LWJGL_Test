package brot.lwjgl.engine.physics;

import brot.lwjgl.engine.scene.entity.Entity;

public class PhysicsEntity {
    float restitution = .2f;
    Type type;
    CollisionSolver.Method collision;
    // Position.
    double x;
    double y;
    // Velocity.
    float vx;
    float vy;
    // Acceleration.
    float ax;
    float ay;
    double width;
    double height;
    double halfWidth;
    double halfHeight;

    public Entity target;

    public PhysicsEntity(Entity target, double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = Type.DYNAMIC;
        collision = CollisionSolver.Method.ELASTIC;
        this.target = target;
        updateBounds();
    }

    protected void updateBounds() {
        this.halfWidth = width / 2f;
        this.halfHeight = height / 2f;
    }

    public double getTop() {
        return y;
    }

    public double getBottom() {
        return y + height;
    }

    public double getLeft() {
        return x;
    }

    public double getRight() {
        return x + width;
    }

    public double getMidX() {
        return x + halfHeight;
    }

    public double getMidY() {
        return y + halfWidth;
    }

    /**
     * These constants represent the 3 different types of
     * entities acting in this engine
     * These types are derived from Box2D's engine that
     * model the behaviors of its own entities/bodies
     */
    enum Type {
        /**
         * // Kinematic entities are not affected by gravity, and
         * // will not allow the solver to solve these elements
         * // These entities will be our platforms in the stage
         */
        KINEMATIC,

        /**
         * // Dynamic entities will be completely changing and are
         * // affected by all aspects of the physics system
         */
        DYNAMIC,

        DISPLACE,


    }
}

package brot.lwjgl.engine.scene.entity;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Constants;
import brot.lwjgl.game.scene.collision.Vector;
import com.google.common.base.Preconditions;
import org.joml.Vector2d;
import org.joml.Vector2f;

import java.util.HashMap;
import java.util.Map;

public class GameObject extends Entity implements AABB {
    Map<String, State> states;
    int currentState;
    public Vector2d velocity;
    protected Vector2d halfExtents;
    protected Vector2d centerPoint;
    protected Sprite.CollisionObject collisionObject;
    protected boolean applyGravity = false;
    protected boolean onGround;
    protected boolean onGroundLast;


    public Vector2d m_posCorrect;

    public GameObject(String id, Sprite sprite, String type, String name) {
        super(id, sprite, type, name);
        states = new HashMap<>();
        velocity = new Vector2d();
        if (sprite.hasCollisionData()) {
            collisionObject = sprite.getCollisionObjects().stream().findFirst().orElseThrow();
            halfExtents = new Vector2d(collisionObject.size()).div(2);
            centerPoint = new Vector2d();
        }
        m_posCorrect = new Vector2d();
    }

    public void addState(State state) {
        this.states.put(state.id, state);
    }

    public void switchState(String id) {
        Preconditions.checkArgument(states.containsKey(id), "game object state '%s' must be present", id);
        State newState = states.get(id);
        sprite = newState.sprite;
        spriteId = sprite.getId();
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public void setOnGroundLast() {
        this.onGroundLast = onGround;
    }

    public void setVelocity(double x, double y) {
        velocity.x = x;
        velocity.y = y;
    }

    public Vector2d getVelocity() {
        return velocity;
    }

    public Sprite.CollisionObject getCollisionObject() {
        return collisionObject;
    }

    public Vector2d getCollisionBoxPosition() {
        return new Vector2d(position).add(collisionObject.offset());
    }

    public void update(long diffTimeMs) {
        if (applyGravity) {
            // Apply gravity and clamp max speed.
            velocity.y = Math.min(velocity.y + Constants.GRAVITY, Constants.MAX_SPEED * 2);
        }
    }

    public void collisionResponse(Vector2d normal, double dist, double dt) {
        // get the separation and penetration separately, this is to stop penetration
        // from causing the objects to ping apart
        double separation = Math.max(dist, 0);
        double penetration = Math.min(dist, 0);

        // compute relative normal velocity require to be object to an exact stop at the surface
        double nv = velocity.dot(normal) + separation / dt;

        // accumulate the penetration correction, this is applied in Update() and ensures
        // we don't add any energy to the system
        Vector.subFrom(m_posCorrect, Vector.mulScalar(normal, penetration / dt));

        if (nv < 0) {
            // remove normal velocity
            Vector.subFrom(velocity, Vector.mulScalar(normal, nv));

            // is this some ground?
            if (normal.y < 0) {
                setOnGround(true);

                // friction
//                if (m_ApplyFriction) {
//                    // get the tanget from the normal (perp vector)
//                    Vector2f tangent = Vector.perp(normal);
//                    // compute the tangential velocity, scale by friction
//                    float tv = Vector.dot(m_vel, tangent) * kGroundFriction;
//                    // subtract that from the main velocity
//                    Vector.subFrom(m_vel, Vector.mulScalar(tangent, tv));
//                }

                if (!onGroundLast) {
                    // this transition occurs when this object 'lands' on the ground
//                    System.out.println("LandingTransition()");
//                    landingTransition = 350;
//                    player.switchState("landing");
                }
            }
        }
    }

    @Override
    public Vector2d getCenter() {
        return centerPoint.set(position)
                .add(collisionObject.offset())
                .add(halfExtents);
    }

    @Override
    public Vector2d getHalfExtents() {
        return halfExtents;
    }

    /**
     * Defines a game object state.
     *
     * @param id State ID.
     * @param sprite Associated sprite.
     * @param duration State duration in ms.
     */
    public record State(String id, Sprite sprite, long duration) {
        public State(String id, Sprite sprite) {
            this(id, sprite, 0);
        }
    }

}

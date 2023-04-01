package brot.lwjgl.engine.scene.entity;

import brot.lwjgl.engine.graph.model.Sprite;
import com.google.common.base.Preconditions;
import org.joml.Vector2f;

import java.util.HashMap;
import java.util.Map;

public class GameObject extends Entity implements AABB {
    Map<String, State> states;
    int currentState;
    public Vector2f velocity;

    protected Vector2f halfExtents;
    protected Vector2f centerPoint;
    protected Sprite.CollisionObject collisionObject;

    public GameObject(String id, Sprite sprite, String type, String name) {
        super(id, sprite, type, name);
        states = new HashMap<>();
        velocity = new Vector2f();
        if (sprite.hasCollisionData()) {
            collisionObject = sprite.getCollisionObjects().stream().findFirst().orElseThrow();
            halfExtents = new Vector2f(collisionObject.size()).div(2);
            centerPoint = new Vector2f();
        }
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

    public void setVelocity(float x, float y) {
        velocity.x = x;
        velocity.y = y;
    }

    public Sprite.CollisionObject getCollisionObject() {
        return collisionObject;
    }

    public Vector2f getCollisionBoxPosition() {
        return new Vector2f(position).add(collisionObject.offset());
    }

    @Override
    public Vector2f getCenter() {
        return centerPoint.set(position)
                .add(collisionObject.offset())
                .add(halfExtents);
    }

    @Override
    public Vector2f getHalfExtents() {
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

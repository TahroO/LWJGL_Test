package brot.lwjgl.engine.scene;

import brot.lwjgl.engine.graph.model.Sprite;
import org.joml.*;

/**
 * needs:
 * - sprite dimension for collision detection
 */
public class Entity {
    private final String id;
    private final String modelId;
    private final Matrix4f modelMatrix;
    private final Vector3f position;
    private final Quaternionf rotation;
    private final Vector2f orientation;
    private float scale;
    private final Vector3f eulerAngleBuffer;
    private String type;
    private String name;

    // TESTING
    public Sprite sprite;

    /**
     * Creates a new Entity object.
     *
     * @param id The entity ID.
     * @param modelId ID of the sprite to use.
     */
    public Entity(String id, String modelId) {
        this.id = id;
        this.modelId = modelId;
        modelMatrix = new Matrix4f();
        position = new Vector3f();
        rotation = new Quaternionf();
        orientation = new Vector2f(1f, 1f);
        eulerAngleBuffer = new Vector3f();
        scale = 1;
    }

    public Entity(String id, String modelId, String type, String name) {
        this(id, modelId);
        this.type = type;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getSpriteId() {
        return modelId;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Matrix4f getModelMatrix() {
        return modelMatrix;
    }

    public Vector3f getPosition() {
        return position;
    }

    public Quaternionf getRotation() {
        return rotation;
    }

    public float getScale() {
        return scale;
    }

    public final Entity setPosition(float x, float y) {
        position.x = x;
        position.y = y;
        return this;
    }

    public Entity setRotation(float angle) {
        this.rotation.rotateLocalZ(angle);
        return this;
    }

    public Entity addRotation(float angle) {
        rotation.getEulerAnglesXYZ(eulerAngleBuffer);
        rotation.fromAxisAngleRad(0, 0, 1, eulerAngleBuffer.z + angle);
        return this;
    }

    public Entity setScale(float scale) {
        this.scale = scale;
        return this;
    }

    public void updateModelMatrix() {
        modelMatrix.translationRotateScale(position, rotation, scale);
    }

    public void setOrientationX(float value) {
        orientation.x = value;
    }

    public void setOrientationY(float value) {
        orientation.y = value;
    }

    public Vector2f getOrientation() {
        return orientation;
    }

}

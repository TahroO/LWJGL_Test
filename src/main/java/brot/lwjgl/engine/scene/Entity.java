package brot.lwjgl.engine.scene;

import brot.lwjgl.engine.graph.model.Sprite;
import org.joml.*;

/**
 * needs:
 * - sprite dimension for collision detection
 */
public class Entity {
    /**
     * 1st placeholder = layer ID, 2nd = entity ID.
     */
    public static final String ID_FORMAT = "entity-%s-%s";
    private final String id;
    private final String modelId;
    private final Matrix4f modelMatrix;
    private final Vector3f position;
    private final Quaternionf rotation;
    private final Vector3f orientation;
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
        orientation = new Vector3f(1f, 1f, 1f);
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

    /**
     * Sets the entity's position.
     * @param x New x position.
     * @param y New y position.
     * @return This entity object.
     */
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

    /**
     * Flips texture vertically.
     */
    public void flipV() {
        orientation.y = orientation.y * -1;
    }

    /**
     * Flips texture horizontally.
     */
    public void flipH() {
        orientation.x = orientation.x * -1;
    }

    /**
     * Flips texture anti diagonally.
     */
    public void flipD() {
        orientation.z = orientation.z * -1;
    }

    /**
     * Gets the texture orientation.
     * @return
     */
    public Vector3f getOrientation() {
        return orientation;
    }

}

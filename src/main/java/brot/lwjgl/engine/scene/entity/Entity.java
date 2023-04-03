package brot.lwjgl.engine.scene.entity;

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
    protected final String id;
    protected String spriteId;
    protected final Matrix4f modelMatrix;
    protected final Quaternionf rotation;
    protected final Vector3f orientation;
    protected float scale;
    protected final Vector3f eulerAngleBuffer;
    protected String type;
    protected String name;
    protected Vector2f size;

    // TESTING
    public Sprite sprite;
    protected final Vector2d position;
    protected final Matrix3f mm;

    /**
     * Creates a new Entity object.
     *
     * @param id     The entity ID.
     * @param sprite The default sprite.
     */
    public Entity(String id, Sprite sprite
    ) {
        this.id = id;
        this.spriteId = sprite.getId();
        this.sprite = sprite;
        modelMatrix = new Matrix4f();
        rotation = new Quaternionf();
        orientation = new Vector3f(1f, 1f, 1f);
        eulerAngleBuffer = new Vector3f();
        scale = 1;
        position = new Vector2d();
        mm = new Matrix3f();
    }

    /**
     * Constructs a new Entity object.
     *
     * @param id     Entity ID.
     * @param sprite The sprite.
     * @param type   Entity type.
     * @param name   Entity name.
     */
    public Entity(String id, Sprite sprite, String type, String name) {
        this(id, sprite);
        this.type = type;
        this.name = name;
    }

    /**
     * Gets the entity ID.
     *
     * @return Entity ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets entity's sprite ID.
     *
     * @return Entity sprite ID.
     */
    public String getSpriteId() {
        return spriteId;
    }

    /**
     * Gets entity's sprite.
     *
     * @return A sprite.
     */
    public Sprite getSprite() {
        return sprite;
    }

    public String getType() {
        return type;
    }

    /**
     * Gets the entity name.
     *
     * @return Entity name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the entity's position.
     *
     * @return Entity position vector.
     */
    public Vector2d getPosition() {
        return position;
    }

    /**
     * Sets the entity's position.
     *
     * @param x New x position.
     * @param y New y position.
     * @return This entity object.
     */
    public Entity setPosition(double x, double y) {
        position.set(x, y);
        return this;
    }

    /**
     * Adds delta to the entity's current position.
     *
     * @param dx X value to add.
     * @param dy Y value to add.
     * @return This entity object.
     */
    public Entity addPosition(float dx, float dy) {
        position.add(dx, dy);
        return this;
    }

    /**
     * Gets the entity's scale factor.
     *
     * @return Entity scale factor.
     */
    public float getScale() {
        return scale;
    }

    /**
     * Sets the entity's scale factor.
     *
     * @param scale Entity scale factor.
     * @return This entity object.
     */
    public Entity setScale(float scale) {
        this.scale = scale;
        return this;
    }

    public Quaternionf getRotation() {
        return rotation;
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

    /**
     * Flips entity texture vertically.
     */
    public void flipV() {
        orientation.y = orientation.y * -1;
    }

    /**
     * Flips entity texture horizontally.
     */
    public void flipH() {
        orientation.x = orientation.x * -1;
    }

    /**
     * Flips entity texture anti diagonally.
     */
    public void flipD() {
        orientation.z = orientation.z * -1;
    }

    /**
     * Gets the texture orientation.
     *
     * @return Entity texture orientation.
     */
    public Vector3f getOrientation() {
        return orientation;
    }

    /**
     * Gets the entity's model matrix.
     *
     * @return Entity model matrix.
     */
    public Matrix4f getModelMatrix() {
        return modelMatrix;
    }

    /**
     * Updates the entity's model matrix.
     */
    public void updateModelMatrix() {
        modelMatrix.translationRotateScale(
                (float) position.x(), (float) position.y(), 0f,
                rotation.x(), rotation.y(), rotation.z(), rotation.w(),
                scale, scale, scale);
    }

}

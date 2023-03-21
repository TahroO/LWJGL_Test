package brot.lwjgl.engine.graph.model;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.Collection;
import java.util.HashSet;

/**
 * Defines a Sprite object.
 */
public class Sprite extends Model {
    protected SpriteSheet spriteSheet;
    protected Mesh mesh;
    protected float spriteIndex;
    protected AnimationFrame[] animationFrames;
    protected int[] animationDurations;
    protected long totalAnimationDuration;
    protected boolean hasAnimation;
    protected boolean hasCollisionData;
    protected Collection<CollisionObject> collisionObjects;

    /**
     * Creates a new Sprite object.
     *
     * @param id Sprite ID.
     * @param spriteIndex The sprite index on sprite sheet.
     */
    public Sprite(String id, SpriteSheet spriteAtlas, int spriteIndex) {
        this(id, spriteAtlas, spriteIndex, null);
    }

    /**
     * Creates a new Sprite object.
     *
     * @param id Sprite ID.
     * @param spriteSheet The sprite sheet.
     * @param spriteIndex The sprite index on sprite sheet.
     * @param animationDurations Animation durations in ms.
     */
    public Sprite(String id, SpriteSheet spriteSheet, int spriteIndex, AnimationFrame[] animationDurations) {
        this(id, spriteSheet.getSpriteMesh(), spriteSheet, spriteIndex, animationDurations);
    }

    /**
     * Creates a new Sprite object.
     *
     * @param id Sprite ID.
     * @param mesh Sprite mesh.
     * @param spriteSheet The sprite sheet.
     * @param spriteIndex The sprite index on sprite sheet.
     * @param animationDurations Animation durations in ms.
     */
    public Sprite(String id, Mesh mesh, SpriteSheet spriteSheet, int spriteIndex, AnimationFrame[] animationDurations) {
        super(id);
        this.spriteSheet = spriteSheet;
        this.spriteIndex = spriteIndex;
        this.mesh = mesh;
        this.collisionObjects = new HashSet<>();
        setAnimationFrames(animationDurations);
    }

    /**
     * Gets this sprite's sprite sheet.
     *
     * @return The sprite sheet.
     */
    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    /**
     * Gets the sprites (start) index on sprite sheet.
     *
     * @return Sprite index.
     */
    public float getSpriteIndex() {
        return spriteIndex;
    }

    /**
     * Gets the animation frame sprite index delta for the provided time.
     *
     * @param time Time in ms.
     * @return Animation frame sprite index delta.
     */
    // TODO scale animation duration in entity.
    public float getAnimationFrame(long time) {
        if (totalAnimationDuration > 0) {
            long modTime = time % totalAnimationDuration;
            for (int i = animationDurations.length - 1; i >= 0; i--) {
                if (modTime >= animationDurations[i]) {
                    return i;
                }
            }
        }
        return spriteIndex;
    }

    /**
     * Sets sprite animation frames.
     *
     * @param animationFrames The animation frames and durations.
     */
    public void setAnimationFrames(AnimationFrame[] animationFrames) {
        int totalDuration = 0;
        if (animationFrames != null && animationFrames.length > 0) {
            int[] durationsSeries = new int[animationFrames.length];
            for (int i = 0; i < animationFrames.length; i++) {
                totalDuration += animationFrames[i].duration;
                durationsSeries[i] = totalDuration;
            }
            this.animationFrames = animationFrames;
            this.animationDurations = durationsSeries;
            hasAnimation = true;
        }
        this.totalAnimationDuration = totalDuration;
    }

    /**
     *
     * @return
     */
    public boolean hasAnimation() {
        return hasAnimation;
    }

    public void addCollisionObject(CollisionObject collisionObject) {
        collisionObjects.add(collisionObject);
        this.hasCollisionData = true;
    }

    public boolean hasCollisionData() {
        return hasCollisionData;
    }

    public Collection<CollisionObject> getCollisionObjects() {
        return collisionObjects;
    }

    /**
     * Defines a sprite animation frame.
     *
     * @param spriteIndex The sprite index of the frame.
     * @param duration The frame's duration in ms.
     */
    public record AnimationFrame(int spriteIndex, int duration) {}

    private static long timeer;
    public record CollisionObject(float x, float y, float width, float height) {
        public SceneLayer.CollisionResultTest checkCollision(Entity self, Entity other) {
            if (self == other) {
                return null;
            }
            for (CollisionObject otherCo : other.sprite.collisionObjects) {
                Vector3f r1Position = self.getPosition();
                Vector3f r2Position = other.getPosition();
                Vector2f r1 = new Vector2f(r1Position.x + x, r1Position.y + y);
                Vector2f r2 = new Vector2f(r2Position.x + otherCo.x, r2Position.y + otherCo.y);

                if (System.currentTimeMillis() - 1000 > timeer) {
                    System.out.println(r2.x);
                    timeer = System.currentTimeMillis();
                }

                if (r1.x + width >= r2.x &&     // r1 right edge past r2 left
                        r1.x <= r2.x + otherCo.width &&       // r1 left edge past r2 right
                        r1.y + otherCo.height >= r2.y &&       // r1 top edge past r2 bottom
                        r1.y <= r2.y + otherCo.height) {       // r1 bottom edge past r2 top
                    return new SceneLayer.CollisionResultTest(self, r1, this, other, r2, otherCo);
                }
            }
            return null;
        }
    }

}

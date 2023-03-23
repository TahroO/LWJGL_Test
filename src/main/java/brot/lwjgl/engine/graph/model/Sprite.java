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
    public static final String ID_FORMAT = "gid-%s";
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
     * @param id          Sprite ID.
     * @param spriteIndex The sprite index on sprite sheet.
     */
    public Sprite(String id, SpriteSheet spriteAtlas, int spriteIndex) {
        this(id, spriteAtlas, spriteIndex, null);
    }

    /**
     * Creates a new Sprite object.
     *
     * @param id                 Sprite ID.
     * @param spriteSheet        The sprite sheet.
     * @param spriteIndex        The sprite index on sprite sheet.
     * @param animationDurations Animation durations in ms.
     */
    public Sprite(String id, SpriteSheet spriteSheet, int spriteIndex, AnimationFrame[] animationDurations) {
        this(id, spriteSheet.getSpriteMesh(), spriteSheet, spriteIndex, animationDurations);
    }

    /**
     * Creates a new Sprite object.
     *
     * @param id                 Sprite ID.
     * @param mesh               Sprite mesh.
     * @param spriteSheet        The sprite sheet.
     * @param spriteIndex        The sprite index on sprite sheet.
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
                    return animationFrames[i].spriteIndex;
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
     * @param duration    The frame's duration in ms.
     */
    public record AnimationFrame(int spriteIndex, int duration) {
    }

    public record CollisionObject(float x, float y, float width, float height) {
        public static float POS_FIX = .0001f;

        /**
         * Gets the absolute position of a collision object on screen.
         */
        private Vector2f getAbsolutePosition(CollisionObject co, Entity entity) {
            Vector3f entityPosition = entity.getPosition();
            float x;
            if (entity.getOrientation().x < 0) {
                Vector2f spriteSize = entity.sprite.getSpriteSheet().getSpriteSize();
                x = entityPosition.x + spriteSize.x - (co.x + co.width);
            } else {
                x = entityPosition.x + co.x;
            }
            float y = entityPosition.y + co.y;
            return new Vector2f(x, y);
        }

        public SceneLayer.CollisionResultTest checkCollision(Entity layerEntity, Entity otherEntity) {
//            if (layerEntity == otherEntity) {
//                return null;
//            }
//            for (CollisionObject otherCo : otherEntity.sprite.collisionObjects) {
//                // Get absolute positions of collision objects.
//                Vector2f r1 = getAbsolutePosition(this, layerEntity);
//                Vector2f r2 = getAbsolutePosition(otherCo, otherEntity);
//
//                if (
//                        r1.x + width >= r2.x &&             // r1 right edge past r2 left
//                                r1.x <= r2.x + otherCo.width &&     // r1 left edge past r2 right
//                                r1.y + otherCo.height >= r2.y &&    // r1 top edge past r2 bottom
//                                r1.y <= r2.y + otherCo.height       // r1 bottom edge past r2 top
//                ) {
//                    float deltaX = r1.x < r2.x ? r1.x + width - r2.x + POS_FIX : r1.x - r2.x - otherCo.width - POS_FIX;
//                    float deltaY = 0; //r1.y - r2.y - otherCo.height - POS_FIX;
//                    return new SceneLayer.CollisionResultTest(layerEntity, r1, this, otherEntity, r2, otherCo, new Vector2f(deltaX, deltaY));
//                }
//            }
            return null;
        }
    }

}

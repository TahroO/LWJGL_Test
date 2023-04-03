package brot.lwjgl.engine.graph.model;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.physics.CollisionDetector;
import brot.lwjgl.engine.physics.CollisionSolver;
import brot.lwjgl.engine.physics.PhysicsEntity;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import org.joml.Vector2d;
import org.joml.Vector2f;

import java.util.Collection;
import java.util.HashSet;

/**
 * Defines a Sprite object.
 */
public class Sprite extends Model {
    public static final String ID_FORMAT = "gid-%s";
    protected SpriteSheet spriteSheet;
    protected Mesh mesh;
    protected int spriteIndex;
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
     * Gets the sprite's index.
     *
     * @param time
     * @return Sprite index.
     */
    public int getSpriteIndex(long time) {
        if (hasAnimation && totalAnimationDuration > 0) {
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
     * Gets the animation frame sprite index delta for the provided time.
     *
     * @param time Time in ms.
     * @return Animation frame sprite index delta.
     */
    // TODO scale animation duration in entity.
    // TODO merge into getSpriteIndex().
    public float getAnimationFrame(long time) {
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
            int[] durationsSeries = new int[animationFrames.length + 1];
            durationsSeries[0] = 0;
            for (int i = 1; i < animationFrames.length + 1; i++) {
                totalDuration += animationFrames[i - 1].duration;
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

//    public record CollisionObject(float x, float y, float width, float height) {
    public record CollisionObject(Vector2d offset, Vector2d size) {
        public static float POS_FIX = .0001f;

        /**
         * Gets the absolute position of a collision object on screen.
         */
//        private Vector2f getAbsolutePosition(CollisionObject co, Entity entity) {
//            Vector2f entityPosition = entity.getPosition();
//            float x;
//            if (entity.getOrientation().x < 0) {
//                Vector2f spriteSize = entity.sprite.getSpriteSheet().getSpriteSize();
//                x = entityPosition.x + spriteSize.x - (co.x + co.width);
//            } else {
//                x = entityPosition.x + co.x;
//            }
//            float y = entityPosition.y + co.y;
//            return new Vector2f(x, y);
//        }

        public PhysicsEntity getPhysicsEntity(Entity entity) {
            double ex = entity.getOrientation().x > 0
                    ? entity.getPosition().x + offset.x
                    : entity.getPosition().x + entity.sprite.getSpriteSheet().getSpriteSize().x - offset.x - size.x;
            return new PhysicsEntity(
                    entity,
                    ex,
                    entity.getPosition().y + offset.y,
                    size.x,
                    size.y
            );
        }

//        public SceneLayer.CollisionResultTest checkCollision(Entity layerEntity, Entity otherEntity) {
//            if (layerEntity == otherEntity) {
//                return null;
//            }
//            for (CollisionObject otherCo : otherEntity.sprite.collisionObjects) {
//                PhysicsEntity otherPe = otherCo.getPhysicsEntity(otherEntity);
//                PhysicsEntity layerPe = this.getPhysicsEntity(layerEntity);
//                if (CollisionDetector.getInstance().collideRect(layerPe, otherPe)) {
//                    return CollisionSolver.resolveElastic(otherPe, layerPe);
//                }
//            }
//            return null;
//        }
    }

}

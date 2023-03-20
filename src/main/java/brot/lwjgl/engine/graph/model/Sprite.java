package brot.lwjgl.engine.graph.model;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.texture.SpriteSheet;

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

    /**
     * Defines a sprite animation frame.
     *
     * @param spriteIndex The sprite index of the frame.
     * @param duration The frame's duration in ms.
     */
    public record AnimationFrame(int spriteIndex, int duration) {}

}

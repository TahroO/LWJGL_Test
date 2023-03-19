package brot.lwjgl.engine.graph.model;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.texture.SpriteSheet;

/**
 * Defines a Sprite.
 */
public class Sprite extends Model {
    protected SpriteSheet spriteSheet;
    protected Mesh mesh;
    protected float spriteIndex;
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
    public Sprite(String id, SpriteSheet spriteSheet, int spriteIndex, int[] animationDurations) {
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
    public Sprite(String id, Mesh mesh, SpriteSheet spriteSheet, int spriteIndex, int[] animationDurations) {
        super(id);
        this.spriteSheet = spriteSheet;
        this.spriteIndex = spriteIndex;
        this.mesh = mesh;
        setAnimationDurations(animationDurations);
    }

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
                    return i + 1;
                }
            }
        }
        return 0;
    }

    public void setAnimationDurations(int[] animationDurations) {
        int totalDuration = 0;
        if (animationDurations != null && animationDurations.length > 0) {
            int[] durationsSeries = new int[animationDurations.length];
            durationsSeries[0] = 0;
            for (int i = 0; i < animationDurations.length; i++) {
                totalDuration += animationDurations[i];
                durationsSeries[i] = totalDuration;
            }
            this.animationDurations = durationsSeries;
            hasAnimation = true;
        }
        this.totalAnimationDuration = totalDuration;
    }

    public boolean hasAnimation() {
        return hasAnimation;
    }

}

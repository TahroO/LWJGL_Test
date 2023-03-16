package brot.lwjgl.engine.graph.model;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.mesh.Quad;
import brot.lwjgl.engine.graph.texture.SpriteAtlas;
import brot.lwjgl.engine.scene.Entity;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Sprite extends Model {
    protected SpriteAtlas spriteAtlas;
    protected Mesh mesh;
    protected float spriteIndex;
    protected float frames;
    protected float fps;

    public Sprite(String id, SpriteAtlas spriteAtlas, int spriteIndex) {
        this(id, spriteAtlas, spriteIndex, 1, 0);
    }

    public Sprite(String id, SpriteAtlas spriteAtlas, int spriteIndex, int frames, float fps) {
        this(id, spriteAtlas.getSpriteMesh(), spriteAtlas, spriteIndex, frames, fps);
    }

    public Sprite(String id, Mesh mesh, SpriteAtlas spriteAtlas, int spriteIndex, int frames, float fps) {
        super(id);
        this.spriteAtlas = spriteAtlas;
        this.spriteIndex = spriteIndex;
        this.frames = frames;
        this.fps = fps;
        this.mesh = mesh;
    }

    public SpriteAtlas getSpriteAtlas() {
        return spriteAtlas;
    }

    public float getSpriteIndex() {
        return spriteIndex;
    }

    public float getFrames() {
        return frames;
    }

    public float getFps() {
        return fps;
    }

}

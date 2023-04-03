package brot.lwjgl.engine.scene.layer;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.scene.Constants;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.game.scene.collision.Vector;
import org.joml.Vector2d;
import org.joml.Vector2f;

import java.util.*;

/**
 * Defines a SceneLayer object.
 */
public class SceneLayer {
    public static String ID_FORMAT = "layer-%s";
    protected Map<String, Sprite> sprites;
    protected Map<SpriteSheet, Collection<Sprite>> textures;
    protected Map<Sprite.CollisionObject, List<Entity>> collisionObjects;
    protected static int instanceCouter;
    protected String id;
    protected List<Entity> entities;
    protected Map<String, Entity> entityMap;
    protected int weight;
    protected boolean visible;
    protected Vector2f parallaxFactor;
    protected float width;
    protected float height;

    /**
     * Creates a new SceneLayer object.
     *
     * @param id Layer ID.
     */
    public SceneLayer(String id) {
        this.id = id;
        weight = instanceCouter++;
        entities = new ArrayList<>();
        textures = new HashMap<>();
        collisionObjects = new HashMap<>();
        sprites = new HashMap<>();
        visible = true;
        parallaxFactor = new Vector2f(1f, 1f);
        entityMap = new HashMap<>();
    }

    /**
     * Gets the layer ID.
     *
     * @return The layer ID.
     */
    public String getId() {
        return id;
    }

    public void cleanup() {

    }

    /**
     * // TODO Parallax factor vs. group layers.
     * When the parallax scrolling factor is set on a group layer,
     * it applies to all its child layers. The effective parallax
     * scrolling factor of a layer is determined by multiplying the
     * parallax scrolling factor by the scrolling factors of all
     * parent layers.
     *
     * @param parallaxFactor
     */
    public void setParallaxFactor(Vector2f parallaxFactor) {
        this.parallaxFactor = parallaxFactor;
    }

    public Vector2f getDisplacement(Scene scene) {
        return new Vector2f(0, 0);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setDimension(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public boolean isVisible() {
        return visible;
    }

    public Map<SpriteSheet, Collection<Sprite>> getTextures() {
        return textures;
    }

    public void addSprite(Sprite sprite) {
        if (!sprites.containsKey(sprite.getId())) {
            sprites.put(sprite.getId(), sprite);
            // Attach entity to texture for rendering.
            SpriteSheet spriteSheet = sprite.getSpriteSheet();
            if (!textures.containsKey(spriteSheet)) {
                textures.put(spriteSheet, new HashSet<>());
            }
            textures.get(spriteSheet).add(sprite);
        }
    }

    /**
     * Adds an entity to this layer.
     *
     * @param entity The entity object to add.
     */
    public void addEntity(Entity entity) {
        String spriteId = entity.getSpriteId();
        Sprite sprite = sprites.get(spriteId);
        if (sprite == null) {
            throw new RuntimeException("Could not find model [" + spriteId + "] for entity [" + entity.getId() + "]");
        }
        sprite.addEntity(entity);
        entities.add(entity);
        entityMap.put(entity.getId(), entity);

        // Map collision objects to entity.
        if (sprite.hasCollisionData()) {
            for (Sprite.CollisionObject co : sprite.getCollisionObjects()) {
                if (!collisionObjects.containsKey(co)) {
                    collisionObjects.put(co, new ArrayList<>());
                }
            }
            sprite.getCollisionObjects().forEach(co2 -> collisionObjects.get(co2).add(entity));
        }
    }

    public Entity getEntity(String id) {
        return entityMap.get(id);
    }

    public void checkCollisions(GameObject gameObject, double dt) {
    }

    protected void doActionToTilesWithinAabb(GameObject gameObject, Vector2d min, Vector2d max, double dt) {
    }

    /**
     * Gets the layer's entity list.
     *
     * @return The entities list.
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * Gets the layer weight value.
     *
     * @return The layer weight.
     */
    public int getWeight() {
        return weight;
    }

    public Sprite getSprite(String spriteId) {
        return sprites.get(spriteId);
    }
}

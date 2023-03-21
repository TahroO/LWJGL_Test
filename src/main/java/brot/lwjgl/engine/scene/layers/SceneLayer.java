package brot.lwjgl.engine.scene.layers;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.scene.Entity;
import org.joml.Vector2f;

import java.util.*;

/**
 * Defines a SceneLayer object.
 */
public class SceneLayer {
    protected Map<String, Sprite> sprites;
    protected Map<SpriteSheet, Collection<Sprite>> textures;
    protected Map<Sprite.CollisionObject, List<Entity>> collisionObjects;
    protected static int instanceCouter;
    protected String id;
    protected List<Entity> entities;
    protected int weight;

    /**
     * Creates a new SceneLayer object.
     *
     * @param id Layer ID.
     */
    public SceneLayer(String id) {
        this.id = id;
        weight = instanceCouter++;
        entities = new ArrayList<>();
        textures =  new HashMap<>();
        collisionObjects = new HashMap<>();
        sprites = new HashMap<>();
    }

    /**
     * Gets the layer ID.
     *
     * @return The layer ID.
     */
    public String getId(){
        return id;
    }

    public void cleanup() {

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

        // Map collision objects to entity.
        if (sprite.hasCollisionData()) {
            for (Sprite.CollisionObject co : sprite.getCollisionObjects()) {
                if (!collisionObjects.containsKey(co)) {
                    collisionObjects.put(co, new ArrayList<>());
                }
                sprite.getCollisionObjects().forEach(co2 -> collisionObjects.get(co2).add(entity));
            }
        }
    }

    public record CollisionResultTest(Entity e1, Vector2f p1, Sprite.CollisionObject c1, Entity e2, Vector2f p2, Sprite.CollisionObject c2) {}

    public Map<Entity, List<CollisionResultTest>> getCollisions(Entity... entities) {
        Map<Entity, List<CollisionResultTest>> collisions = new HashMap<>();
        for (Entity otherEntity: entities) {
            List<CollisionResultTest> c = new ArrayList<>();
            for (Map.Entry<Sprite.CollisionObject,List<Entity>> co : collisionObjects.entrySet()) {
                for (Entity layerEntity : co.getValue()) {
                    CollisionResultTest r = co.getKey().checkCollision(layerEntity, otherEntity);
                    if (r != null) {
                        c.add(r);
                    }
                }
            }
            if (!c.isEmpty()) {
                collisions.put(otherEntity, c);
            }
        }
        return collisions;
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

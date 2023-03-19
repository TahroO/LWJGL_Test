package brot.lwjgl.engine.scene;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a SceneLayer object.
 */
public class SceneLayer {
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
    }

    /**
     * Gets the layer ID.
     *
     * @return The layer ID.
     */
    public String getId(){
        return id;
    }

    /**
     * Adds an entity to this layer.
     *
     * @param entity The entity object to add.
     */
    public void addEntity(Entity entity) {
        entities.add(entity);
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

}

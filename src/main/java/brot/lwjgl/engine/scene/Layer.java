package brot.lwjgl.engine.scene;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    protected static int instanceCouter;
    protected String id;
    protected List<Entity> entities;
    protected int weight;

    public Layer(String id) {
        this.id = id;
        weight = instanceCouter++;
        entities = new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public int getWeight() {
        return weight;
    }

}

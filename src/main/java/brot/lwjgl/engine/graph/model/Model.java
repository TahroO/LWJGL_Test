package brot.lwjgl.engine.graph.model;

import brot.lwjgl.engine.scene.entity.Entity;

import java.util.*;

public class Model {
    protected final String id;
    protected final List<Entity> entities;

    public Model(String id) {
        this.id = id;
        entities = new ArrayList<>();
    }

//    public void cleanup() {
//        mesh.cleanup();
//    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public String getId() {
        return id;
    }

//    public List<Mesh> getMesh() {
//        return mesh;
//    }

}
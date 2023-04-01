package brot.lwjgl.engine.scene.layer;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileLayer extends SceneLayer {
    /**
     * Creates a new TileLayer object.
     *
     * @param id Layer ID.
     */
    public TileLayer(String id) {
        super(id);
    }

    @Override
    public Map<Entity, List<CollisionResultTest>> getCollisions(Entity otherEntity, long dt) {
        Map<Entity, List<CollisionResultTest>> collisions = new HashMap<>();
        List<CollisionResultTest> c = new ArrayList<>();
        for (Map.Entry<Sprite.CollisionObject, List<Entity>> co : collisionObjects.entrySet()) {
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
        return collisions;
    }

    protected void collision(Entity player, long dt) {

    }
}

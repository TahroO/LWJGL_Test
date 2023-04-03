package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.engine.scene.layer.ObjectLayer;
import brot.lwjgl.engine.scene.layer.SceneLayer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TiledObjectLayer extends TiledObjectGroup {
    @Override
    public List<Entity> getEntities(TiledMap map, Map<String, Sprite> sprites) {
        return IntStream
                .range(0, objects.size())
                .mapToObj(delta -> createEntity(objects.get(delta), delta, sprites))
                .toList();
    }

    @Override
    public Stream<Integer> getGids() {
        return objects.stream().map(object -> object.gid);
    }

    @Override
    protected SceneLayer getSceneLayerInstance(TiledMap map) {
        return new ObjectLayer(SceneLayer.ID_FORMAT.formatted(id));
    }

    private Entity createEntity(TiledObject object, int delta, Map<String, Sprite> sprites) {
        String fqcn = "brot.lwjgl.engine.scene.entity.GameObject";
        if (Objects.equals(object.type, "player")) {
            fqcn = "brot.lwjgl.engine.scene.entity.Player";
        }
        try {
            Class<?> clazz = Class.forName(fqcn);
            Constructor<?> constructor = clazz.getConstructor(String.class, Sprite.class, String.class, String.class);
            Entity entity = (Entity) constructor.newInstance("entity-%s-%s".formatted(id, delta), sprites.get(Sprite.ID_FORMAT.formatted(object.gid)), object.type, object.name);
            entity.setPosition(object.x, object.y - object.height).updateModelMatrix();
            entity.updateModelMatrix();
            return entity;
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

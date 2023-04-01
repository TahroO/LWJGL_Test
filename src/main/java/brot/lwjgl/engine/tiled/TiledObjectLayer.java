package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.engine.scene.layer.ObjectLayer;
import brot.lwjgl.engine.scene.layer.SceneLayer;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TiledObjectLayer extends TiledObjectGroup {
    @Override
    public List<Entity> getEntities(TiledMap map, Map<String, Sprite> sprites) {
        return IntStream
                .range(0, objects.size())
                .mapToObj(delta -> {
                    TiledObject object = objects.get(delta);
                    Entity entity = new GameObject("entity-%s-%s".formatted(id, delta), sprites.get(Sprite.ID_FORMAT.formatted(object.gid)), object.type, object.name);
                    entity.setPosition(object.x, object.y - object.height).updateModelMatrix();
                    return entity;
                })
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

}

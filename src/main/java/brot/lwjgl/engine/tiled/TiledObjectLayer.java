package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.layers.ObjectLayer;
import brot.lwjgl.engine.scene.layers.SceneLayer;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TiledObjectLayer extends TiledObjectGroup {
    @Override
    public List<Entity> getEntities(TiledMap map) {
        return IntStream
                .range(0, objects.size())
                .mapToObj(delta -> {
                    TiledObject object = objects.get(delta);
                    Entity entity = new Entity("entity-%s-%s".formatted(id, delta), Sprite.ID_FORMAT.formatted(object.gid), object.type, object.name);
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

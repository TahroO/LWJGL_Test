package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Entity;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TiledObjectGroup extends TiledLayer {
    @XmlElement(name = "object")
    private ArrayList<TiledObject> objects = new ArrayList<>();

    @XmlAttribute
    private String color;

    @Override
    public List<Entity> getEntities(TiledMap map) {
        return IntStream
                .range(0, objects.size())
                .mapToObj(delta -> {
                    TiledObject object = objects.get(delta);
                    Entity entity = new Entity("entity-%s-%s".formatted(id, delta), "tile-%s".formatted(object.gid), object.type, object.name);
                    entity.setPosition(object.x, object.y - object.height).updateModelMatrix();
                    return entity;
                })
                .toList();
    }

    @Override
    public List<Integer> getUniqueGids() {
        return objects.stream().map(object -> object.gid).distinct().toList();
    }

}

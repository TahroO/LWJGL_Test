package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TiledObjectGroup extends TiledLayer {
    @XmlElement(name = "object")
    protected ArrayList<TiledObject> objects = new ArrayList<>();

    @XmlAttribute
    protected String color;

    @Override
    public List<Entity> getEntities(TiledMap map, Map<String, Sprite> sprites) {
        return null;
    }

    @Override
    public Stream<Integer> getGids() {
        return null;
    }

    @Override
    protected SceneLayer getSceneLayerInstance(TiledMap map) {
        return null;
    }

}

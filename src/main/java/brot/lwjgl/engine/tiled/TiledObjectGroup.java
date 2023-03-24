package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TiledObjectGroup extends TiledLayer {
    @XmlElement(name = "object")
    protected ArrayList<TiledObject> objects = new ArrayList<>();

    @XmlAttribute
    protected String color;

    @Override
    public List<Entity> getEntities(TiledMap map) {
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

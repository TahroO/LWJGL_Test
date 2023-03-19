package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.scene.Entity;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

public class TiledObjectGroup extends TiledLayer {
    @XmlElement(name = "object")
    private ArrayList<TiledObject> objects = new ArrayList<>();

    @XmlAttribute
    private String color;

    @Override
    public List<Entity> getEntities() {
        return null;
    }
}

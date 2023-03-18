package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;

public class TiledObjectGroup extends TiledLayer {
    @XmlElement(name = "object")
    private ArrayList<TiledObject> objects = new ArrayList<>();

    @XmlAttribute
    private String color;

}
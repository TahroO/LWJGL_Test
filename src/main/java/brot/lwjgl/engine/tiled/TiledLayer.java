package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.tiled.xml.BooleanIntegerAdapter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.List;

public abstract class TiledLayer {
    @XmlAttribute
    public int id;

    @XmlAttribute
    public String name;

    @XmlAttribute
    private Integer width;

    @XmlAttribute
    private Integer height;

    @XmlAttribute
    private Float opacity;

    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanIntegerAdapter.class)
    private Boolean visible;

    @XmlAttribute
    private Integer offsetx;

    @XmlAttribute
    private Integer offsety;

    abstract public List<Entity> getEntities();

}

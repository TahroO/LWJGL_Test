package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.tiled.xml.DecimalFloatAdapter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class TiledObject {
    @XmlAttribute
    private int id;

    @XmlAttribute
    public Integer gid;

    @XmlAttribute
    public String name;

    @XmlAttribute
    public String type;

    @XmlAttribute
    @XmlJavaTypeAdapter(value = DecimalFloatAdapter.class)
    public Float x;

    @XmlAttribute
    @XmlJavaTypeAdapter(value = DecimalFloatAdapter.class)
    public Float y;

    @XmlAttribute
    @XmlJavaTypeAdapter(value = DecimalFloatAdapter.class)
    public Float width = 0f;

    @XmlAttribute
    @XmlJavaTypeAdapter(value = DecimalFloatAdapter.class)
    public Float height = 0f;

    @XmlElement
    private String point;

    @XmlElement
    private String ellipse;

}

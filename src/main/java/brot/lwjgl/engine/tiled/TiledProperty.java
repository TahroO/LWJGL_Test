package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "property")
public class TiledProperty {
    @XmlAttribute
    String name;
    @XmlAttribute
    String type;
    @XmlAttribute
    String propertytype;
    @XmlAttribute
    String value;
    @XmlElement(name = "properties")
    TiledProperties properties;

}

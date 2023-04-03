package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "properties")
public class TiledProperties {
    @XmlElement(name = "property")
    public List<TiledProperty> properties;

}

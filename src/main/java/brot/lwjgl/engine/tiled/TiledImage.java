package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class TiledImage {
    @XmlAttribute
    public String source;

    /**
     * Defines a specific color that is treated as transparent
     * (example value: “#FF00FF” for magenta). Including
     * the “#” is optional and Tiled leaves it out for compatibility
     * reasons. (optional)
     */
    @XmlAttribute(name = "trans")
    private String transparentcolor;

    @XmlAttribute
    public int width;

    @XmlAttribute
    public int height;

    public TiledImage() {
        super();
    }

}

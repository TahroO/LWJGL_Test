package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class TiledImage {
    @XmlAttribute
    public String source;

    @XmlAttribute(name = "trans")
    private String transparentcolor;

    @XmlAttribute
    private int width;

    @XmlAttribute
    private int height;

    public TiledImage() {
        super();
    }

}

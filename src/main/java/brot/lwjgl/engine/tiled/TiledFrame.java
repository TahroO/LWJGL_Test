package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class TiledFrame {
    @XmlAttribute
    private int tileid;

    @XmlAttribute
    private int duration;

    public int getTileId() {
        return this.tileid;
    }

    public int getDuration() {
        return this.duration;
    }
}

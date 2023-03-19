package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class TiledAnimation {
    @XmlElement(name = "frame", type = TiledFrame.class)
    private List<TiledFrame> frames;

    public List<TiledFrame> getFrames() {
        return frames;
    }

}

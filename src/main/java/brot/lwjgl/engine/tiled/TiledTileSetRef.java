package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "tileset")
@XmlAccessorType(XmlAccessType.FIELD)
public class TiledTileSetRef {
    @XmlAttribute
    public int firstgid;

    @XmlAttribute
    public String source;

}

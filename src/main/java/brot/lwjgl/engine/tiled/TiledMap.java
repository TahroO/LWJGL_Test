package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)
public class TiledMap {
    @XmlAttribute
    private String orientation;

    @XmlAttribute
    private String renderorder;

    @XmlAttribute
    public int width;

    @XmlAttribute
    public int height;

    @XmlAttribute
    public int tilewidth;

    @XmlAttribute
    public int tileheight;

    @XmlAttribute
    private String name;

    @XmlElement(name = "tileset", type = TiledTileSetRef.class)
    public List<TiledTileSetRef> tilesetRefs;

    @XmlElements({
            @XmlElement(name = "layer", type = TiledTileLayer.class),
            @XmlElement(name = "objectgroup", type = TiledObjectGroup.class),
    })
    public List<TiledLayer> layers;

}

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

    /**
     * The background color of the map. (optional, may include alpha value
     * since 0.15 in the form #AARRGGBB. Defaults to fully transparent.)
     */
    @XmlAttribute
    public String backgroundcolor;

    @XmlAttribute
    private String name;

    @XmlElement(name = "tileset", type = TiledTileSetRef.class)
    public List<TiledTileSetRef> tilesetRefs;

    @XmlElements({
            @XmlElement(name = "layer", type = TiledTileLayer.class),
            @XmlElement(name = "objectgroup", type = TiledObjectLayer.class),
            @XmlElement(name = "imagelayer", type = TiledImageLayer.class),
    })
    public List<TiledLayer> layers;

}

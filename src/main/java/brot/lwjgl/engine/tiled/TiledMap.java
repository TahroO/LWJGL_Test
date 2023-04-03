package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.Color;
import brot.lwjgl.engine.tiled.xml.ColorAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
    @XmlJavaTypeAdapter(ColorAdapter.class)
    public Color backgroundcolor;

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

    @XmlElement(name = "properties")
    public List<TiledProperty> properties;

}

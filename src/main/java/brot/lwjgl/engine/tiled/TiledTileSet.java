package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "tileset")
@XmlAccessorType(XmlAccessType.FIELD)
public class TiledTileSet {
    @XmlElement
    public TiledImage image;

    @XmlAttribute
    private Integer margin;

    @XmlAttribute
    public String name;

    @XmlAttribute
    private Integer tilewidth;

    @XmlAttribute
    private Integer tileheight;

    @XmlAttribute
    public Integer tilecount;

    @XmlAttribute
    public Integer columns;

    @XmlAttribute
    private Integer spacing;

    @XmlElement(name = "tile")
    public List<TiledTile> tiles;

}

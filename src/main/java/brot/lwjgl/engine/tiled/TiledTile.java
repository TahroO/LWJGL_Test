package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

public class TiledTile {
    protected static final int FLIPPED_HORIZONTALLY_FLAG = 0x80000000;
    protected static final int FLIPPED_VERTICALLY_FLAG = 0x40000000;
    protected static final int FLIPPED_DIAGONALLY_FLAG = 0x20000000;
    public static final int NONE = 0;
    public static final TiledTile EMPTY = new TiledTile(NONE);

    @XmlTransient
    private TiledTileSet tileset;

    @XmlAttribute
    public Integer id;

    @XmlAttribute
    private String terrain;

    @XmlElement
    public TiledAnimation animation;

    @XmlAttribute
    private String type;

    @XmlElement(name = "objectgroup")
    private TiledObjectGroup collisionData;

    @XmlAttribute
    public Integer gid;

    private transient boolean flippedDiagonally;
    private transient boolean flippedHorizontally;
    private transient boolean flippedVertically;
    private transient boolean flipped;

    public TiledTile() {}

    /**
     * Instantiates a new {@code Tile} instance.
     *
     * @param gidBitmask
     *          The grid ID bitmask used to identify flags of this instance.
     *
     * @see TiledTile#FLIPPED_HORIZONTALLY_FLAG
     * @see TiledTile#FLIPPED_DIAGONALLY_FLAG
     * @see TiledTile#FLIPPED_VERTICALLY_FLAG
     */
    public TiledTile(int gidBitmask) {
        // Clear the flags.
        this.flippedDiagonally = (gidBitmask & FLIPPED_DIAGONALLY_FLAG) != 0;
        this.flippedHorizontally = (gidBitmask & FLIPPED_HORIZONTALLY_FLAG) != 0;
        this.flippedVertically = (gidBitmask & FLIPPED_VERTICALLY_FLAG) != 0;
        this.flipped = this.flippedDiagonally || this.flippedHorizontally || this.flippedVertically;
        this.gid = gidBitmask & ~(FLIPPED_HORIZONTALLY_FLAG | FLIPPED_VERTICALLY_FLAG | FLIPPED_DIAGONALLY_FLAG);
    }

    public Integer getId() {
        return id;
    }

    public boolean hasAnimation() {
        return animation != null;
    }

    public TiledAnimation getAnimation() {
        return animation;
    }
}

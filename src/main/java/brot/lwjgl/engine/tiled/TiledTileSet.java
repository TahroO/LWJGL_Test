package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@XmlRootElement(name = "tileset")
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
    public List<TiledTile> tiles = new ArrayList<>();

    @XmlTransient
    public Map<Integer, TiledTile> tilesMap;

//    public void setTiles(Map<Integer, TiledTile> tiles) {
//        this.tiles = tiles;
//    }
//
//    @XmlElement(name = "tile")
//    @XmlJavaTypeAdapter(TiledTileMapAdapter.class)
    public Map<Integer, TiledTile> getTiles() {
        if (tilesMap == null) {
            tilesMap = tiles.stream().collect(Collectors.toMap(TiledTile::getId, Function.identity()));
        }
        return tilesMap;
    }

    protected SpriteSheet spriteAtlas;

    public Sprite getSprite(int gid, int firstgid) {
        if (spriteAtlas == null) {
            spriteAtlas = new SpriteSheet("/tiled/test1/" + image.source, columns, tilecount / columns);
        }
        TiledTile tile = getTiles().get(gid - firstgid);
        int[] durations = null;
        if (tile != null && tile.hasAnimation()) {
            List<TiledFrame> frames = tile.getAnimation().getFrames();
            durations = new int[frames.size()];
            for (int i = 0; i < frames.size(); i++) {
                TiledFrame frame = frames.get(i);
                durations[i] = frame.getDuration();
            }
        }
        return new Sprite("tile-%s".formatted(gid), spriteAtlas, gid - firstgid, durations);
    }

}

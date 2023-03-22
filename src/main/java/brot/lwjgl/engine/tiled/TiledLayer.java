package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.tiled.xml.BooleanIntegerAdapter;
import brot.lwjgl.engine.util.XmlLoader;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class TiledLayer {
    @XmlAttribute
    public int id;

    @XmlAttribute
    protected String name;

    @XmlAttribute
    protected Integer width;

    @XmlAttribute
    protected Integer height;

    @XmlAttribute
    protected Float opacity;

    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanIntegerAdapter.class)
    protected Boolean visible;

    @XmlAttribute
    protected Integer offsetx;

    @XmlAttribute
    protected Integer offsety;

    abstract public List<Entity> getEntities(TiledMap map);

    abstract public Stream<Integer> getGids();

    public List<Integer> getUniqueGids(boolean unmask) {
        Stream<Integer> gids = getGids();
        if (unmask) {
            gids = gids.map(this::unmaskGid);
        }
        return gids.toList();
    }

    public List<Sprite> getSprites(TiledMap map) {
        List<Sprite> sprites = new ArrayList<>();
        List<Integer> gids = getUniqueGids(true);
        for (TiledTileSetRef ref : map.tilesetRefs.stream().sorted(Comparator.comparingInt(tileSetRef -> -tileSetRef.firstgid)).toList()) {
            if (gids == null) {
                break;
            }
            TiledTileSet tileset = XmlLoader.loadTileSet(ref.source);
            Map<Boolean, List<Integer>> groupedGids = gids.stream().collect(Collectors.groupingBy(gid -> gid >= ref.firstgid));
            if (groupedGids.containsKey(true)) {
                groupedGids.get(true).forEach(gid -> {
                    sprites.add(tileset.getSprite(gid, ref.firstgid));
                });
            }
            gids = groupedGids.get(false);
        }
        return sprites;
    }

    protected int unmaskGid(int gid) {
        return gid & ~(TiledTile.FLIPPED_HORIZONTALLY_FLAG
                | TiledTile.FLIPPED_VERTICALLY_FLAG
                | TiledTile.FLIPPED_DIAGONALLY_FLAG);
    }

}

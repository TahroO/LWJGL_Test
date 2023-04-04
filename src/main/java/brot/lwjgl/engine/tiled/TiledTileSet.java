package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.util.XmlLoader;
import jakarta.xml.bind.annotation.*;
import org.joml.Vector2d;
import org.joml.Vector2f;

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

    protected SpriteSheet spriteSheet;

    protected String basePath;

    @XmlTransient
    public Map<Integer, TiledTile> tilesMap;

    public Map<Integer, TiledTile> getTiles() {
        if (tilesMap == null) {
            tilesMap = tiles.stream().collect(Collectors.toMap(TiledTile::getId, Function.identity()));
        }
        return tilesMap;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public Sprite getSprite(int gid, int firstgid) {
        if (spriteSheet == null) {
            spriteSheet = new SpriteSheet(basePath + image.source, columns, tilecount / columns);
        }
        TiledTile tile = getTiles().get(gid - firstgid);
        Sprite.AnimationFrame[] animationFrames = null;
        if (tile != null && tile.hasAnimation()) {
            List<TiledFrame> frames = tile.getAnimation().getFrames();
            animationFrames = new Sprite.AnimationFrame[frames.size()];
            for (int i = 0; i < frames.size(); i++) {
                TiledFrame frame = frames.get(i);
                animationFrames[i] = new Sprite.AnimationFrame(frame.getTileId(), frame.getDuration());
            }
        }
        Sprite sprite = new Sprite(Sprite.ID_FORMAT.formatted(gid), spriteSheet, gid - firstgid, animationFrames);
        if (tile != null && tile.hasCollisionData()) {
            List<TiledObject> objects = tile.getCollisionData().objects;
            for (TiledObject object : objects) {
                sprite.addCollisionObject(new Sprite.CollisionObject(new Vector2d(object.x, object.y), new Vector2d(object.width, object.height)));
            }
        }
        return sprite;
    }

}

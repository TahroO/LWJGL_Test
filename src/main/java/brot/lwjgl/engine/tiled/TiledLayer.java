package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.tiled.xml.BooleanIntegerAdapter;
import brot.lwjgl.engine.util.XmlLoader;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.joml.Vector2f;

import java.util.*;
import java.util.function.Function;
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
    protected Float parallaxx;

    @XmlAttribute
    protected Float parallaxy;

    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanIntegerAdapter.class)
    public Boolean visible;

    @XmlAttribute
    protected Integer offsetx;

    @XmlAttribute
    protected Integer offsety;

//    @XmlElement(name = "properties", type = TiledProperty.class)

    @XmlElement
    protected TiledProperties properties;

    abstract public List<Entity> getEntities(TiledMap map, Map<String, Sprite> sprites);

    abstract public Stream<Integer> getGids();

    public Vector2f getParallaxFactor() {
        return new Vector2f(parallaxx == null ? 1f : parallaxx, parallaxy == null ? 1f : parallaxy);
    }

    public List<Integer> getUniqueGids(boolean unmask) {
        Stream<Integer> gids = getGids();
        if (unmask) {
            gids = gids.map(this::unmaskGid);
        }
        return gids.toList();
    }

    public Map<String, Sprite> getSprites(TiledMap map) {
        Map<String, Sprite> sprites = new HashMap<>();
        if (map.tilesetRefs == null) {
            return sprites;
        }
        List<Integer> gids = getUniqueGids(true);
        for (TiledTileSetRef ref : map.tilesetRefs.stream().sorted(Comparator.comparingInt(tileSetRef -> -tileSetRef.firstgid)).toList()) {
            if (gids == null) {
                break;
            }
            TiledTileSet tileset = XmlLoader.loadTileSet(ref.source);
            Map<Boolean, List<Integer>> groupedGids = gids.stream().collect(Collectors.groupingBy(gid -> gid >= ref.firstgid));
            if (groupedGids.containsKey(true)) {
                groupedGids.get(true).forEach(gid -> {
                    Sprite sprite = tileset.getSprite(gid, ref.firstgid);
                    sprites.put(sprite.getId(), sprite);
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

    protected abstract SceneLayer getSceneLayerInstance(TiledMap map);

    public Map<String, Entity> createSceneLayer(TiledMap map, Scene scene) {
        SceneLayer layer = getSceneLayerInstance(map);
        layer.setVisible(visible == null || visible);
        layer.setParallaxFactor(getParallaxFactor());
        Map<String, Sprite> sprites = getSprites(map);
        sprites.values().forEach(layer::addSprite);
        List<Entity> entities = getEntities(map, sprites);
        entities.forEach(layer::addEntity);
        scene.addLayer(layer);
        return entities.stream()
                .filter(entity -> entity.getName() != null)
                .collect(Collectors.toMap(Entity::getName, Function.identity()));
    }

}

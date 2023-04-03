package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.scene.layer.TileLayer;
import jakarta.xml.bind.annotation.XmlElement;
import org.joml.Vector2i;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TiledTileLayer extends TiledLayer {
    @XmlElement
    private TiledData data;

    private transient List<TiledTile> tileList;

    @Override
    public List<Entity> getEntities(TiledMap map, Map<String, Sprite> sprites) {
        final List<Integer> gids = getGids().toList();
        return IntStream
                .range(0, gids.size())
                .mapToObj(delta -> createEntity(map, sprites, gids.get(delta), delta))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Entity createEntity(TiledMap map, Map<String, Sprite> sprites, int gidBitmask, int delta) {
        boolean flippedDiagonally = (gidBitmask & TiledTile.FLIPPED_DIAGONALLY_FLAG) != 0;;
        boolean flippedHorizontally = (gidBitmask & TiledTile.FLIPPED_HORIZONTALLY_FLAG) != 0;
        boolean flippedVertically = (gidBitmask & TiledTile.FLIPPED_VERTICALLY_FLAG) != 0;
        boolean flipped = flippedDiagonally || flippedHorizontally || flippedVertically;;
        int gid = gidBitmask & ~(TiledTile.FLIPPED_HORIZONTALLY_FLAG
                | TiledTile.FLIPPED_VERTICALLY_FLAG
                | TiledTile.FLIPPED_DIAGONALLY_FLAG);
        Entity entity = null;
        // 270° VD
        // 180° HV
        //  90° HD
        if (gid > 0) {
            entity = new Entity(Entity.ID_FORMAT.formatted(id, delta), sprites.get(Sprite.ID_FORMAT.formatted(gid)));
            if (flippedHorizontally) {
                entity.flipH();
            }
            if (flippedVertically) {
                entity.flipV();
            }
            if (flippedDiagonally) {
                entity.flipD();
            }
            int y = delta / width;
            int x = delta % width;
            entity.setPosition(x * map.tilewidth, y * map.tileheight).updateModelMatrix();
        }
        return entity;

    }

    @Override
    public Stream<Integer> getGids() {
        return data.getData().stream();
    }

    @Override
    protected SceneLayer getSceneLayerInstance(TiledMap map) {
        return new TileLayer(SceneLayer.ID_FORMAT.formatted(id), new Vector2i(map.width, map.height));
    }

}

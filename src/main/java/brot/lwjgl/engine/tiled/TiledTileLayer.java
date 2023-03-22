package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.scene.Entity;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TiledTileLayer extends TiledLayer {
    @XmlElement
    private TiledData data;

    private transient List<TiledTile> tileList;

    @Override
    public List<Entity> getEntities(TiledMap map) {
        final List<Integer> gids = getGids().toList();
        return IntStream
                .range(0, gids.size())
                .mapToObj(delta -> createEntity(map, gids.get(delta), delta))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Entity createEntity(TiledMap map, int gidBitmask, int delta) {
        boolean flippedDiagonally = (gidBitmask & TiledTile.FLIPPED_DIAGONALLY_FLAG) != 0;;
        boolean flippedHorizontally = (gidBitmask & TiledTile.FLIPPED_HORIZONTALLY_FLAG) != 0;
        boolean flippedVertically = (gidBitmask & TiledTile.FLIPPED_VERTICALLY_FLAG) != 0;
        boolean flipped = flippedDiagonally || flippedHorizontally || flippedVertically;;
        int gid = gidBitmask & ~(TiledTile.FLIPPED_HORIZONTALLY_FLAG
                | TiledTile.FLIPPED_VERTICALLY_FLAG
                | TiledTile.FLIPPED_DIAGONALLY_FLAG);
        Entity entity = null;
        if (gid > 0) {
            entity = new Entity("entity-%s-%s".formatted(id, delta), "tile-%s".formatted(gid));
            if (flippedHorizontally) {
                entity.setOrientationX(-1f);
            }
            if (flippedVertically) {
                entity.setOrientationY(-1f);
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

}

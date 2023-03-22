package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.scene.Entity;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TiledTileLayer extends TiledLayer {
    @XmlElement
    private TiledData data;

    private transient List<TiledTile> tileList;

    @Override
    public List<Entity> getEntities(TiledMap map) {
        final List<Integer> gids = data.getData();
        return IntStream
                .range(0, gids.size())
                .mapToObj(delta -> {
                    Entity entity = null;
                    int gid = gids.get(delta) & ~(TiledTile.FLIPPED_HORIZONTALLY_FLAG
                                    | TiledTile.FLIPPED_VERTICALLY_FLAG
                                    | TiledTile.FLIPPED_DIAGONALLY_FLAG);
                    if (gid > 0) {
                        entity = new Entity("entity-%s-%s".formatted(id, delta), "tile-%s".formatted(gid));
                        int y = delta / width;
                        int x = delta % width;
                        entity.setPosition(x * map.tilewidth, y * map.tileheight).updateModelMatrix();
                    }
                    return entity;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getUniqueGids() {
        return data.getData().stream().distinct().toList();
    }

}

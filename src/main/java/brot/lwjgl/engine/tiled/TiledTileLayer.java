package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.scene.Entity;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TiledTileLayer extends TiledLayer {
    @XmlElement
    public TiledData data;

    private transient List<TiledTile> tileList;

    @Override
    public List<Entity> getEntities() {
        final List<Integer> gids = data.getData();
        return IntStream
                .range(0, gids.size())
                .mapToObj(delta -> new Entity("entity-%s-%s".formatted(id, delta), "tile-%s".formatted(gids.get(delta))))
                .collect(Collectors.toList());
    }
}

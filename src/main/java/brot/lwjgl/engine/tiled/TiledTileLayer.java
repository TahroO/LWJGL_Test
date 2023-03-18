package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class TiledTileLayer extends TiledLayer {
    @XmlElement
    public TiledData data;

    private transient List<TiledTile> tileList;


}

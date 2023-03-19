package brot.lwjgl.engine.tiled.xml;

import brot.lwjgl.engine.tiled.TiledTile;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

public class TiledTiles {
    @XmlElement(name = "tile")
    public List<TiledTile> tile = new ArrayList<>();

    public TiledTiles() {};

}

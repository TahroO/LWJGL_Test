package brot.lwjgl.engine.tiled.xml;

import brot.lwjgl.engine.tiled.TiledTile;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.util.HashMap;
import java.util.Map;

public class TiledTileMapAdapter extends XmlAdapter<TiledTiles, Map<Integer, TiledTile>> {
    @Override
    public Map<Integer, TiledTile> unmarshal(TiledTiles v) throws Exception {
        HashMap<Integer, TiledTile> result = new HashMap<>();
        return result;
    }

    @Override
    public TiledTiles marshal(Map<Integer, TiledTile> v) throws Exception {
        return null;
    }
}

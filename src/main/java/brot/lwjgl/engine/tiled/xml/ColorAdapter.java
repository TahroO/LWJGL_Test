package brot.lwjgl.engine.tiled.xml;

import brot.lwjgl.engine.graph.Color;
import brot.lwjgl.engine.util.ColorHelper;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class ColorAdapter extends XmlAdapter<String, Color> {

    @Override
    public Color unmarshal(String v) {
        return ColorHelper.decode(v);
    }

    @Override
    public String marshal(Color v) {
        return ColorHelper.encode(v);
    }

}

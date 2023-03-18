package brot.lwjgl.engine.tiled;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlValue;

import java.util.ArrayList;
import java.util.List;

public class TiledData {

    public static class Encoding {
        public static final String BASE64 = "base64";
        public static final String CSV = "csv";

        private Encoding() {
        }

        public static boolean isValid(String encoding) {
            return encoding != null && !encoding.isEmpty() && (encoding.equals(BASE64) || encoding.equals(CSV));
        }
    }

    @XmlAttribute
    private String encoding;

    @XmlAttribute
    private String compression;

    @XmlValue
    private String rawValue;

    @XmlTransient
    private List<Integer> data;

    public List<Integer> getData() {
        if (this.data != null) {
            return this.data;
        }

        if (this.encoding == null || this.encoding.isEmpty()) {
            return new ArrayList<>();
        }

        this.data = this.parseData();

        return this.data;
    }

    private List<Integer> parseData() {
        List<Integer> tmpTiles;
        if (encoding.equals(Encoding.BASE64)) {
            throw new RuntimeException("Implement BASE64 decoding of tile map!");
        } else if (encoding.equals(Encoding.CSV)) {
            tmpTiles = parseCsvData(rawValue);
        } else {
            throw new IllegalArgumentException("Unsupported tile layer encoding " + encoding);
        }
        return tmpTiles;
    }

    protected static List<Integer> parseCsvData(String value) {
        List<Integer> parsed = new ArrayList<>();
        // trim 'space', 'tab', 'newline'. pay attention to additional unicode chars
        // like \u2028, \u2029, \u0085 if necessary
        String[] csvTileIds = value.trim().split("\\s*,\\s*");
        for (String gid : csvTileIds) {
            int tileId;
            try {
                tileId = Integer.parseUnsignedInt(gid);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }

            parsed.add(tileId);
        }
        return parsed;
    }

}

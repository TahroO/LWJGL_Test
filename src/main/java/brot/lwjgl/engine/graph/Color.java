package brot.lwjgl.engine.graph;

public class Color {
    int r;
    int g;
    int b;
    int a;

    public Color(int red, int green, int blue, int alpha) {
        r = red;
        g = green;
        b = blue;
        a = alpha;
    }

    public Color(int rgba, boolean hasAlpha) {
        r = (rgba & 0xFF0000) >> 16;
        g = (rgba & 0xFF00) >> 8;
        b = (rgba & 0xFF);
    }

    public Color(int rgb) {
        this(rgb, false);
    }

    public Color(int red, int green, int blue) {
        this(red, green, blue, 255);
    }

    public int getAlpha() {
        return a;
    }

    public int getRed() {
        return r;
    }

    public int getGreen() {
        return g;
    }

    public int getBlue() {
        return b;
    }

    public int getRGB() {
        return 0;
    }

    public static Color decode(String hex) {
        hex = hex.replace("#", "");
        return new Color(
                Integer.valueOf( hex.substring( 0, 2 ), 16 ),
                Integer.valueOf( hex.substring( 2, 4 ), 16 ),
                Integer.valueOf( hex.substring( 4, 6 ), 16 ) );
    }

}

package brot.lwjgl.game.scene.collision;

public class Scalar {

    public static float Sign(float a) {
        return a >= 0 ? 1 : -1;
    }

    public static double Sign(double a) {
        return a >= 0 ? 1 : -1;
    }

    static public double clamp(double a, double min, double max) {
        a = Math.max( min, a );
        a = Math.min( max, a );
        return a;
    }

}

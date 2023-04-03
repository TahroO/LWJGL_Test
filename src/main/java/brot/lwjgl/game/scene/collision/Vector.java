package brot.lwjgl.game.scene.collision;

import org.joml.Vector2d;
import org.joml.Vector2f;

public class Vector {
    /// <summary>
    /// Get the largest coordinate and return a signed, unit vector containing only that coordinate
    /// </summary>
    public static Vector2f majorAxis(Vector2f current) {
        if (Math.abs(current.x) > Math.abs(current.y)) {
            return new Vector2f(Scalar.Sign(current.x), 0);
        } else {
            return new Vector2f(0, Scalar.Sign(current.y));
        }
    }

    public static Vector2d majorAxis(Vector2d current) {
        if (Math.abs(current.x) > Math.abs(current.y)) {
            return new Vector2d(Scalar.Sign(current.x), 0);
        } else {
            return new Vector2d(0, Scalar.Sign(current.y));
        }
    }

    public static Vector2f negTo(Vector2f current) {
        current.x = -current.x;
        current.y = -current.y;
        return current;
    }

    public static Vector2d negTo(Vector2d current) {
        current.x = -current.x;
        current.y = -current.y;
        return current;
    }

    public static Vector2f addTo(Vector2f current, Vector2f v) {
        current.x += v.x;
        current.y += v.y;
        return current;
    }

    public static Vector2d addTo(Vector2d current, Vector2d v) {
        current.x += v.x;
        current.y += v.y;
        return current;
    }

    public static Vector2f mul(Vector2f current, Vector2f v) {
        return new Vector2f(current.x * v.x, current.y * v.y);
    }

    public static Vector2d mul(Vector2d current, Vector2d v) {
        return new Vector2d(current.x * v.x, current.y * v.y);
    }

    public static Vector2f sub(Vector2f current, Vector2f v) {
        return new Vector2f(current.x - v.x, current.y - v.y);
    }

    public static Vector2d sub(Vector2d current, Vector2d v) {
        return new Vector2d(current.x - v.x, current.y - v.y);
    }

    public static float dot(Vector2f current, Vector2f v) {
        return current.x * v.x + current.y * v.y;
    }

    public static double dot(Vector2d current, Vector2d v) {
        return current.x * v.x + current.y * v.y;
    }

    public static Vector2f subFrom(Vector2f current, Vector2f v) {
        current.x -= v.x;
        current.y -= v.y;
        return current;
    }

    public static Vector2d subFrom(Vector2d current, Vector2d v) {
        current.x -= v.x;
        current.y -= v.y;
        return current;
    }

    public static Vector2f mulScalar(Vector2f current, float s) {
        return new Vector2f(current.x * s, current.y * s);
    }

    public static Vector2d mulScalar(Vector2d current, double s) {
        return new Vector2d(current.x * s, current.y * s);
    }

    // MulAddScalarTo( v:Vector2, s:Number ):Vector2
    // Multiples v by s and then adds to the current vector.
    public static Vector2f mulAddScalarTo(Vector2f current, Vector2f v, float s) {
        current.x += v.x * s;
        current.y += v.y * s;
        return current;
    }

    public static Vector2d mulAddScalarTo(Vector2d current, Vector2d v, double s) {
        current.x += v.x * s;
        current.y += v.y * s;
        return current;
    }

    public static Vector2f add(Vector2f current, Vector2f v) {
        return new Vector2f(current.x + v.x, current.y + v.y);
    }

    public static Vector2d add(Vector2d current, Vector2d v) {
        return new Vector2d(current.x + v.x, current.y + v.y);
    }

    private static Vector2f minInto(Vector2f current, Vector2f b) {
        current.x = Math.min(current.x, b.x);
        current.y = Math.min(current.y, b.y);
        return current;
    }

    private static Vector2d minInto(Vector2d current, Vector2d b) {
        current.x = Math.min(current.x, b.x);
        current.y = Math.min(current.y, b.y);
        return current;
    }

    public static Vector2f min(Vector2f current, Vector2f b) {
        return minInto(new Vector2f(current), b);
    }

    public static Vector2d min(Vector2d current, Vector2d b) {
        return minInto(new Vector2d(current), b);
    }

    public static Vector2f maxInto(Vector2f current, Vector2f b) {
        current.x = Math.max(current.x, b.x);
        current.y = Math.max(current.y, b.y);
        return current;
    }

    public static Vector2d maxInto(Vector2d current, Vector2d b) {
        current.x = Math.max(current.x, b.x);
        current.y = Math.max(current.y, b.y);
        return current;
    }

    public static Vector2f max(Vector2f current, Vector2f b) {
        return maxInto(new Vector2f(current), b);
    }

    public static Vector2d max(Vector2d current, Vector2d b) {
        return maxInto(new Vector2d(current), b);
    }

    public static Vector2f perp(Vector2f current) {
        return new Vector2f(-current.y, current.x);
    }

    public static Vector2d addYTo(Vector2d current, double y) {
        current.y += y;
        return current;
    }
}

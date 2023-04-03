package brot.lwjgl.engine.scene;

import org.joml.Vector2d;
import org.joml.Vector2i;

public class Constants {
    public static final double GRAVITY = 30;
    public static final double MAX_SPEED = 150;
    public static final Vector2d EXPAND = new Vector2d(5, 5);

    // TODO move to tile scene layer variable.
    public static final Vector2i TILE_SIZE = new Vector2i(32, 32);
}

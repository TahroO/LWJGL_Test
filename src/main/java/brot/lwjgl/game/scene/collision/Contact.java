package brot.lwjgl.game.scene.collision;

import org.dyn4j.geometry.Vector2;
import org.joml.Vector2d;
import org.joml.Vector2f;

public class Contact {

    public void Initialise(Vector2d n, double dist, Vector2d p) {
        m_normal = n;
        m_dist = dist;
        m_impulse = 0;
        m_p = p;
    }
    public Vector2d m_normal;
    public double m_dist;
    public double m_impulse;
    public Vector2d m_p;
}

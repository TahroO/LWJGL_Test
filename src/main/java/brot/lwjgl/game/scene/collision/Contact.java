package brot.lwjgl.game.scene.collision;

import org.dyn4j.geometry.Vector2;
import org.joml.Vector2f;

public class Contact {

    public void Initialise(Vector2f n, float dist, Vector2f p) {
        m_normal = n;
        m_dist = dist;
        m_impulse = 0;
        m_p = p;
    }
    public Vector2f m_normal;
    public float m_dist;
    public float m_impulse;
    public Vector2f m_p;
}

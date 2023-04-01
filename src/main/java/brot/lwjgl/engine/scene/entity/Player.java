package brot.lwjgl.engine.scene.entity;

import brot.lwjgl.game.scene.collision.AabbObject;
import org.joml.Vector2f;

public class Player {
    // how high do they jump?
    protected double kPlayerJumpVel = 900 * 1.2;
    // controls how fast the player's velocity moves towards the target velocity
    // 1.0 = in one frame, 0 = never
    private double kReachTargetScale = 0.7;
    // how fast the player walks
    private double kWalkSpeed = 80;
    private Vector2f m_velTarget;
    private AabbObject m_tileAabb;
    private boolean m_tryToMove;
    private boolean m_flyMode;

    public Player() {
        super();
        m_flyMode = false;
        // temporary storage for collision against tiles
        m_tileAabb = new AabbObject();
        m_velTarget = new Vector2f();
    }

    public void update(float dt) {
//        // integrate velocity
//        if (m_flyMode) {
//            Vector.mulScalarTo(m_vel, 0.5);
//        } else {
//            Vector.addYTo(m_vel, Constants.kGravity);
//        }
//
//        // clamp speed
//        m_vel.m_x = Scalar.Clamp(m_vel.m_x, -Constants.kMaxSpeed, Constants.kMaxSpeed);
//        m_vel.m_y = Math.min(m_vel.m_y, Constants.kMaxSpeed * 2);
    }

}

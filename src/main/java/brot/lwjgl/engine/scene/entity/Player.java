package brot.lwjgl.engine.scene.entity;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Constants;
import brot.lwjgl.game.scene.collision.AabbObject;
import brot.lwjgl.game.scene.collision.Scalar;
import brot.lwjgl.game.scene.collision.Vector;
import org.joml.Vector2d;
import org.joml.Vector2f;

import static org.lwjgl.glfw.GLFW.*;

public class Player extends Character {
    private static final double PLAYER_VELOCITY = 100f;
    protected double kPlayerJumpVel = 345;
    // controls how fast the player's velocity moves towards the target velocity
    // 1.0 = in one frame, 0 = never
    private double kReachTargetScale = 0.7;
    // how fast the player walks
    private double kWalkSpeed = 80;
    private Vector2f m_velTarget;
    private AabbObject m_tileAabb;
    private boolean m_tryToMove;
    private boolean spacePressed;
    private boolean rightPressed;
    private boolean leftPressed;
    private boolean upPressed;
    private boolean downPressed;

    public Player(String id, Sprite sprite, String type, String name) {
        super(id, sprite, type, name);
    }

    public void update(long diffTimeMs) {
        if (leftPressed) {
            velocity.x = -PLAYER_VELOCITY * (onGround ? 1 :  0.65f);
        } else if (rightPressed) {
            velocity.x = PLAYER_VELOCITY * (onGround ? 1 :  0.65f);
        } else {
            velocity.x = 0;
        }
        if (spacePressed && onGround) {
            velocity.y = -kPlayerJumpVel;
        }

        velocity.x = Scalar.clamp( velocity.x, -Constants.MAX_SPEED, Constants.MAX_SPEED );
        velocity.y = Math.min(velocity.y + Constants.GRAVITY, Constants.MAX_SPEED * 2);

        super.update(diffTimeMs);
    }

    public void keyEvent(int key, int action) {
        if (key == GLFW_KEY_SPACE) {
            if (action == GLFW_PRESS && !spacePressed) {
                spacePressed = true;
            } else if (action == GLFW_RELEASE) {
                spacePressed = false;
            }
        }
        if (key == GLFW_KEY_D) {
            if (action == GLFW_PRESS && !rightPressed) {
                rightPressed = true;
            } else if (action == GLFW_RELEASE) {
                rightPressed = false;
            }
        }
        if (key == GLFW_KEY_A) {
            if (action == GLFW_PRESS && !leftPressed) {
                leftPressed = true;
            } else if (action == GLFW_RELEASE) {
                leftPressed = false;
            }
        }
        if (key == GLFW_KEY_W) {
            if (action == GLFW_PRESS && !upPressed) {
                upPressed = true;
            } else if (action == GLFW_RELEASE) {
                upPressed = false;
            }
        }
        if (key == GLFW_KEY_S) {
            if (action == GLFW_PRESS && !downPressed) {
                downPressed = true;
            } else if (action == GLFW_RELEASE) {
                downPressed = false;
            }
        }

    }
}

package brot.lwjgl.game.scene;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.entity.Tile;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import brot.lwjgl.game.scene.collision.AabbObject;
import brot.lwjgl.game.scene.collision.Collide;
import brot.lwjgl.game.scene.collision.Contact;
import brot.lwjgl.game.scene.collision.Vector;
import org.joml.Vector2f;
import org.joml.Vector2i;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.GLFW.*;

public class CollisionScene {
    private static final float DIR_UP_OR_LEFT = -1f;
    private static final float DIR_DOWN_OR_RIGHT = 1f;
    public static final float PLAYER_VELOCITY = 100f;
    GameObject player;
    boolean upPressed, leftPressed, rightPressed, downPressed, spacePressed;

    // ---
    boolean onGroundLast;
    boolean onGround;
    Vector2f kExpand = new Vector2f(5, 5);
    Vector2f kWorldHalfExtents = new Vector2f(320, 320);
    Vector2f gTileHalfExtents = new Vector2f(16, 16);
    Vector2f gTileCentreOffset = new Vector2f(16, 16);
    int kTileSize = 32;
    public static Vector2i mapSize = new Vector2i(20, 20);
    SceneLayer tileLayer;
    Map<String, Entity> tiles;
    Map<String, Sprite> sprites;
    // ---
    Vector2f m_vel = new Vector2f();
    Vector2f m_pos = new Vector2f();
    Vector2f m_posCorrect = new Vector2f();
    long landingTransition = 0;
    Sprite langingSprite, idleSprite;
    boolean m_ApplyFriction = false;
    // GameObject.
    private float kGroundFriction = .6f;
    private boolean m_ApplyGravity = true;
    private float kGravity = 50f;
    private float kMaxSpeed = 300f;
    private float kPlayerJumpVel = 450 * 1.2f;

    public CollisionScene() {
        tiles = new HashMap<>();
    }

    public void init(Window window, Scene scene) {
        XmlLoader.setBasePath("/tiled/testmap/");
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "collisions.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        Map<String, Entity> namedEntities = map.layers.stream()
                .filter(tiledLayer -> tiledLayer instanceof TiledTileLayer || tiledLayer instanceof TiledObjectLayer || tiledLayer instanceof TiledImageLayer)
                .flatMap(tiledLayer -> tiledLayer.createSceneLayer(map, scene).entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        player = (GameObject) namedEntities.get("player");
        tileLayer = scene.getLayers().get(0);
        tiles = tileLayer.getEntities().stream()
                .peek(entity -> entity.sprite = tileLayer.getSprite(entity.getSpriteId()))
                .collect(Collectors.toMap(Entity::getId, Function.identity()));

        SceneLayer playerLayer = scene.getLayers().get(1);
        idleSprite = playerLayer.getSprite(player.getSpriteId());
        player.addState(new GameObject.State("idle", idleSprite));
        player.switchState("idle");

        TiledTileSet tileset = XmlLoader.loadTileSet("colors-large.tsx");
        langingSprite = tileset.getSprite(6, 69);
        langingSprite.addEntity(player);
        playerLayer.addSprite(langingSprite);
        player.addState(new GameObject.State("landing", langingSprite));
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
                player.velocity.x = DIR_DOWN_OR_RIGHT * PLAYER_VELOCITY;
            } else if (action == GLFW_RELEASE) {
                player.velocity.x = leftPressed ? DIR_UP_OR_LEFT * PLAYER_VELOCITY : 0;
                rightPressed = false;
            }
        }
        if (key == GLFW_KEY_A) {
            if (action == GLFW_PRESS && !leftPressed) {
                player.velocity.x = DIR_UP_OR_LEFT * PLAYER_VELOCITY;
                leftPressed = true;
            } else if (action == GLFW_RELEASE) {
                player.velocity.x = rightPressed ? DIR_DOWN_OR_RIGHT * PLAYER_VELOCITY : 0;
                leftPressed = false;
            }
        }
        if (key == GLFW_KEY_W) {
            if (action == GLFW_PRESS && !upPressed) {
                player.velocity.y = DIR_UP_OR_LEFT * PLAYER_VELOCITY;
                upPressed = true;
            } else if (action == GLFW_RELEASE) {
                player.velocity.y = downPressed ? DIR_DOWN_OR_RIGHT * PLAYER_VELOCITY : 0;
                upPressed = false;
            }
        }
        if (key == GLFW_KEY_S) {
            if (action == GLFW_PRESS && !downPressed) {
                player.velocity.y = DIR_DOWN_OR_RIGHT * PLAYER_VELOCITY;
                downPressed = true;
            } else if (action == GLFW_RELEASE) {
                player.velocity.y = upPressed ? DIR_UP_OR_LEFT * PLAYER_VELOCITY : 0;
                downPressed = false;
            }
        }
    }

    public void input(Window window, Scene scene, long diffTimeMs) {

    }

    public void update(Scene scene, long diffTimeMs) {
//        player.velocity.y = DIR_DOWN_OR_RIGHT * PLAYER_VELOCITY;
        if (onGround && leftPressed) {
            player.velocity.x = DIR_UP_OR_LEFT * PLAYER_VELOCITY;
        } else if (onGround && rightPressed) {
            player.velocity.x = DIR_DOWN_OR_RIGHT * PLAYER_VELOCITY;
        } else {
            player.velocity.x = 0;
        }
        m_vel.x = player.velocity.x;

        if (spacePressed && onGround) {
            m_vel.y -= kPlayerJumpVel;
        }

        if (m_ApplyGravity) {
            Vector.addYTo(m_vel, kGravity);
            // clamp max speed
            m_vel.y = Math.min(m_vel.y, kMaxSpeed * 2);
        }

        m_pos.x = player.getPosition().x;
        m_pos.y = player.getPosition().y;
        if (player.getCollisionObject() != null) {
            checkCollisions(1f / diffTimeMs);
            // integrate position
//        Vector.subFrom(m_pos, player.getCollisionObject().offset());
        }

        Vector.mulAddScalarTo(m_pos, Vector.add(m_vel, m_posCorrect), 1f / diffTimeMs);
        // force the setter to act
        player.setPosition(m_pos.x, m_pos.y);
        player.updateModelMatrix();
        m_posCorrect.x = 0;
        m_posCorrect.y = 0;

//        if (landingTransition > 0) {
//            landingTransition -= diffTimeMs;
//        }
//        if (landingTransition <= 0) {
//            player.switchState("idle");
//        }
    }

    private void checkCollisions(float dt) {
        // Where are we predicted to be next frame?
        Vector2f xxx = new Vector2f(player.getCollisionBoxPosition());
        Vector2f predictedPos = Vector.mulAddScalarTo(new Vector2f(xxx), m_vel, dt);
        // Find min/max.
        Vector2f min = Vector.min(xxx, predictedPos);
        Vector2f max = Vector.max(xxx, predictedPos);
//        System.out.println("---");
//        System.out.println(player.getPosition().y + " - " + player.getCollisionBoxPosition().y + " - " + player.getCollisionObject().offset().y());
//        System.out.println(min.y + " - " + max.y + " - " + predictedPos.y());

        // Extend by radius.
//        Vector.subFrom(min, player.getHalfExtents());
        Vector.addTo(max, player.getCollisionObject().size());

        // Extend a bit more - this helps when player is very close to boundary of one map cell
        // but not intersecting the next one and is up a ladder.
//        Vector.subFrom(min, kExpand);
//        Vector.addTo(max, kExpand);

        // PreCollisionCode.
        onGroundLast = onGround;
        onGround = false;
//        System.out.printf("%s - %s%n", min.y, max.y);
        doActionToTilesWithinAabb(min, max, dt);
    }


    // Call out to the action for each tile within the given world space bounds.
    private void doActionToTilesWithinAabb(Vector2f min, Vector2f max, float dt) {
        // Round down.
        int minI = worldCoordsToTileX(min.x);
        int minJ = worldCoordsToTileY(min.y);

        //  Round up.
        int maxI = worldCoordsToTileX(max.x + 0.5f);
        int maxJ = worldCoordsToTileY(max.y + 1.5f);

        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                Entity tile = getTile(i, j);
                // Generate aabb for this tile.
                AabbObject aabbTemp = new AabbObject();
                fillInTileAabb(i, j, aabbTemp, tile);
                // TODO Tile can be null here.
                innerCollide(aabbTemp, tile, dt, i, j);
            }
        }
    }

    private Entity getTile(int i, int j) {
        return tiles.get(Entity.ID_FORMAT.formatted(1, j * mapSize.x + i));
    }

    private int worldCoordsToTileX(float worldX) {
        return (int) worldX / kTileSize;
    }

    private int worldCoordsToTileY(float worldY) {
        return (int) worldY / kTileSize;
    }

    private float tileCoordsToWorldX(int i) {
        return i * kTileSize;
    }

    private float tileCoordsToWorldY(int j) {
        return j * kTileSize;
    }

    private void fillInTileAabb(int i, int j, AabbObject outAabb, Entity tile) {
        Vector2f v = new Vector2f(tileCoordsToWorldX(i), tileCoordsToWorldY(j));
        outAabb.initialise(Vector.addTo(v, gTileCentreOffset), gTileHalfExtents);
    }

    private void innerCollide(AabbObject tileAabb, Entity tile, float dt, int i, int j) {
        if (tile != null && tile.sprite.hasCollisionData()) {
            Contact contact = new Contact();
            boolean collided = Collide.AabbVsAabb(player, tileAabb, contact, i, j, tiles, true);
            if (collided) {
                collisionResponse(contact.m_normal, contact.m_dist, dt);
            }
        }
    }

    private void collisionResponse(Vector2f normal, float dist, float dt) {
        // get the separation and penetration separately, this is to stop pentration
        // from causing the objects to ping apart
        float separation = Math.max(dist, 0);
        float penetration = Math.min(dist, 0);

        // compute relative normal velocity require to be object to an exact stop at the surface
        float nv = m_vel.dot(normal) + separation / dt;

        // accumulate the penetration correction, this is applied in Update() and ensures
        // we don't add any energy to the system
        Vector.subFrom(m_posCorrect, Vector.mulScalar(normal, penetration / dt));

        if (nv < 0) {
            // remove normal velocity
            Vector.subFrom(m_vel, Vector.mulScalar(normal, nv));

            // is this some ground?
            if (normal.y < 0) {
                onGround = true;

                // friction
                if (m_ApplyFriction) {
                    // get the tanget from the normal (perp vector)
                    Vector2f tangent = Vector.perp(normal);

                    // compute the tangential velocity, scale by friction
                    float tv = Vector.dot(m_vel, tangent) * kGroundFriction;

                    // subtract that from the main velocity
                    Vector.subFrom(m_vel, Vector.mulScalar(tangent, tv));
                }

                if (!onGroundLast) {
                    // this transition occurs when this object 'lands' on the ground
//                    System.out.println("LandingTransition()");
//                    landingTransition = 350;
//                    player.switchState("landing");
                }
            }
        }
    }
}

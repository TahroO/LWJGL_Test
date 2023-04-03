package brot.lwjgl.game.scene;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector2d;
import org.joml.Vector2f;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.GLFW.*;

public class KingPigsScene {
    private static final float DIR_UP_OR_LEFT = -1f;
    private static final float DIR_DOWN_OR_RIGHT = 1f;
    public static final float PLAYER_VELOCITY = 150f;
    GameObject player;
    Sprite runSprite;
    Sprite idleSprite;
    Vector2f direction;
    public Vector2d step = new Vector2d();

    boolean upPressed, leftPressed, rightPressed, downPressed;

    public KingPigsScene() {
        direction = new Vector2f();
    }

    public void init(Scene scene) {
        XmlLoader.setBasePath("/tiled/king-pigs/");
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "map-2.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        Map<String, Entity> namedEntities = map.layers.stream()
                .filter(tiledLayer -> tiledLayer instanceof TiledTileLayer || tiledLayer instanceof TiledObjectLayer || tiledLayer instanceof TiledImageLayer)
                .flatMap(tiledLayer -> tiledLayer.createSceneLayer(map, scene).entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        player = (GameObject) namedEntities.get("king");
        SceneLayer playerLayer = scene.getLayers().get(3);
        // Idle state.
        idleSprite = playerLayer.getSprite(player.getSpriteId());
        player.addState(new GameObject.State("idle", idleSprite));
        player.switchState("idle");
        // Run state.
        TiledTileSet tileset = XmlLoader.loadTileSet("king-run-78x58.tsx");
        runSprite = tileset.getSprite(1000, 1000);
        runSprite.addEntity(player);
        playerLayer.addSprite(runSprite);
        player.addState(new GameObject.State("run", runSprite));
    }

    public void keyEvent(int key, int action) {
        if (key == GLFW_KEY_D) {
            if (action == GLFW_PRESS && !rightPressed) {
                direction.x = DIR_DOWN_OR_RIGHT;
                updatePlayerDir();
                rightPressed = true;
            } else if (action == GLFW_RELEASE) {
                direction.x = leftPressed ? DIR_UP_OR_LEFT : 0;
                updatePlayerDir();
                rightPressed = false;
            }
        }
        if (key == GLFW_KEY_A) {
            if (action == GLFW_PRESS && !leftPressed) {
                direction.x = DIR_UP_OR_LEFT;
                updatePlayerDir();
                leftPressed = true;
            } else if (action == GLFW_RELEASE) {
                direction.x = rightPressed ? DIR_DOWN_OR_RIGHT : 0;
                updatePlayerDir();
                leftPressed = false;
            }
        }
        if (key == GLFW_KEY_W) {
            if (action == GLFW_PRESS && !upPressed) {
                upPressed = true;
            } else if (action == GLFW_RELEASE) {
                direction.y = downPressed ? DIR_DOWN_OR_RIGHT : 0;
                upPressed = false;
            }
        }
        if (key == GLFW_KEY_S) {
            if (action == GLFW_PRESS && !downPressed) {
                downPressed = true;
            } else if (action == GLFW_RELEASE) {
                direction.y = upPressed ? DIR_UP_OR_LEFT : 0;
                downPressed = false;
            }
        }
    }

    protected void updatePlayerDir() {
        if (direction.x > 0 || direction.x < 0) {
            player.getOrientation().x = direction.x;
            player.switchState("run");
            player.sprite = runSprite;
        } else {
            player.switchState("idle");
            player.sprite = idleSprite;
        }
    }

    public void input(Window window, Scene scene, long diffTimeMillis) {

    }

    public void update(Scene scene, long diffTimeMillis) {
        Vector2d pos = player.getPosition();
        double dx = direction.x * PLAYER_VELOCITY * diffTimeMillis / 1000d;
        double dy = direction.y * PLAYER_VELOCITY * diffTimeMillis / 1000d;
        pos.x += dx;
        pos.y += dy;
        step.x = dx;
        step.y = dy;
        player.updateModelMatrix();
//        scene.getLayers().stream()
//                .map(layer -> layer.getCollisions(player, diffTimeMillis))
//                .filter(results -> !results.isEmpty())
//                .forEach(this::resolveCollision);
    }

//    protected void resolveCollision(Map<Entity, List<SceneLayer.CollisionResultTest>> results) {
//        results.forEach((player, value) -> {
//            var dx = value.stream()
//                    .mapToDouble(result -> result.playerRes().x)
//                    .filter(delta -> delta > 0 && step.x < 0 || delta < 0 && step.x > 0)
//                    .distinct()
//                    .findFirst();
//            var dy = value.stream()
//                    .mapToDouble(result -> result.playerRes().y)
//                    .filter(delta -> delta > 0 && step.y < 0 || delta < 0 && step.y > 0)
//                    .distinct()
//                    .findFirst();
//            var x = (float) dx.orElse(0d);
//            var y = (float) dy.orElse(0d);
//            if (Math.abs(x) > Math.abs(y)) {
//                player.getPosition().x += x;
//            } else {
//                player.getPosition().y += y;
//            }
////            player.addPosition((float) dx.orElse(0d), (float) dy.orElse(0d));
//            player.updateModelMatrix();
//        });
//    }

}

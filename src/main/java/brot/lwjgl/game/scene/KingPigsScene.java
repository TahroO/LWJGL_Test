package brot.lwjgl.game.scene;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector2f;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.GLFW.*;

public class KingPigsScene {
    private static final float DIR_UP_OR_LEFT = -1f;
    private static final float DIR_DOWN_OR_RIGHT = 1f;
    public static final float MOVE_SPEED = 2f;
    Entity player;
    Vector2f direction;

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
        player = namedEntities.get("king");
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
                direction.y = DIR_UP_OR_LEFT;
                upPressed = true;
            } else if (action == GLFW_RELEASE) {
                direction.y = downPressed ? DIR_DOWN_OR_RIGHT : 0;
                upPressed = false;
            }
        }
        if (key == GLFW_KEY_S) {
            if (action == GLFW_PRESS && !downPressed) {
                direction.y = DIR_DOWN_OR_RIGHT;
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
        }
    }

    public void input(Window window, Scene scene, long diffTimeMillis) {
        player.updateModelMatrix();

    }

    public void update(Scene scene, long diffTimeMillis) {
        Vector3f pos = player.getPosition();
        pos.x += direction.x * MOVE_SPEED;
        player.updateModelMatrix();
    }

}

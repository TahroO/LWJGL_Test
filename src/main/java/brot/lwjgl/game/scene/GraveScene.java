package brot.lwjgl.game.scene;

import brot.lwjgl.engine.MouseInput;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector2f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class GraveScene {
    Entity player;
    private static final float MOUSE_SENSITIVITY = 40f;
    private static final float MOVEMENT_SPEED = .3f;

    public void init(Scene scene) {
        XmlLoader.setBasePath("/tiled/grave/");
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "graveTest.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        map.layers.stream()
                .filter(tiledLayer -> tiledLayer instanceof TiledTileLayer || tiledLayer instanceof TiledObjectLayer || tiledLayer instanceof TiledImageLayer)
                .forEach(tiledLayer -> tiledLayer.createSceneLayer(map, scene));
    }

    public void input(Window window, Scene scene, long diffTimeMillis) {
        float move = Math.round(diffTimeMillis * MOVEMENT_SPEED);
        Camera camera = scene.getCamera();
        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveUp(move);
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveDown(move);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);
        }

        MouseInput mouseInput = window.getMouseInput();
        if (mouseInput.isRightButtonPressed()) {
            Vector2f displVec = mouseInput.getDisplVec();
            camera.moveUp(Math.round(Math.toRadians(-displVec.x * MOUSE_SENSITIVITY)));
            camera.moveRight(Math.round(Math.toRadians(-displVec.y * MOUSE_SENSITIVITY)));
        }

        Vector3f cameraPosition = camera.getPosition();
        float camY = Math.min(Math.max(cameraPosition.y, 0), scene.getHeight() - scene.getViewportHeight());
        float camX = Math.min(Math.max(cameraPosition.x, 0), scene.getWidth() - scene.getViewportWidth());
        camera.setPosition(camX, camY);
//        if (window.isKeyPressed(GLFW_KEY_A)) {
//            player.getPosition().x -= 1.8;
//            player.setOrientationX(-1);
//        } else if (window.isKeyPressed(GLFW_KEY_D)) {
//            player.getPosition().x += 1.8;
//            player.setOrientationX(1);
//        }
//        player.updateModelMatrix();

    }

    public void update(Scene scene, long diffTimeMillis) {
//        updatePlayerGravity();
    }

    private void updatePlayerGravity() {
        player.getPosition().y += 8;
    }

}

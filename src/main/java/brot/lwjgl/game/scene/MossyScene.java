package brot.lwjgl.game.scene;

import brot.lwjgl.engine.MouseInput;
import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.TiledImageLayer;
import brot.lwjgl.engine.tiled.TiledMap;
import brot.lwjgl.engine.tiled.TiledObjectLayer;
import brot.lwjgl.engine.tiled.TiledTileLayer;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector2f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class MossyScene {
    private static final float MOUSE_SENSITIVITY = 55f;
    private static final float MOVEMENT_SPEED = .3f;
    Entity player;

    public void init(Window window, Scene scene) {
        XmlLoader.setBasePath("/tiled/Mossy/");
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "mossy.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        scene.getCamera().setScale(.25f);
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
        float camY = Math.min(Math.max(cameraPosition.y, 0), scene.getHeight() * camera.getScale() - scene.getViewportHeight());
        float camX = Math.min(Math.max(cameraPosition.x, 0), scene.getWidth() * camera.getScale() - scene.getViewportWidth());
        camera.setPosition(camX, camY);
    }

    public void update(Scene scene, long diffTimeMillis) {
    }

}

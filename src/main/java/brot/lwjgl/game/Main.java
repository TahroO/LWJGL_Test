package brot.lwjgl.game;

import brot.lwjgl.engine.*;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteAtlas;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Layer;
import brot.lwjgl.engine.scene.Scene;
import org.joml.Math;
import org.joml.Vector2f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;

/**
 * TODO
 * - entity fps
 * - entity start, stop animation
 * - entity multiple sprites, animations
 * - entity switch sprite
 * - layer show, hide
 */
public class Main implements AppLogic {
    private static final float MOUSE_SENSITIVITY = 40f;
    private static final float MOVEMENT_SPEED = .3f;
    private Entity dude;
    private float dudePositionX = -32f;
    private float dudePositionY = 8 * 32 + 5;
    private boolean moveCameraBack;

    public static void main(String[] args) {
        Main main = new Main();
        Window.WindowOptions windowOptions = new Window.WindowOptions();
        windowOptions.width = 640;
        windowOptions.height = 640;
        Engine gameEng = new Engine("chapter-02", windowOptions, main);
        gameEng.start();
    }

    @Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Render render) {
        initTowerDefense(scene);
    }

    protected void initTowerDefense(Scene scene) {
        scene.addLayer(new Layer("0"));
        scene.addLayer(new Layer("1"));
        scene.addLayer(new Layer("effects"));
        SpriteAtlas spriteAtlas = new SpriteAtlas("/models/spriteatlas.png", 10, 5);
        SpriteAtlas dudeAtlas = new SpriteAtlas("/models/dude-walking.png", 9, 1);

        Sprite waterSprite = new Sprite("water", spriteAtlas, 0, 4, 1);
        Sprite explosionSprite = new Sprite("explosion", spriteAtlas, 20, 6, 9);
        Sprite grassSprite = new Sprite("grass", spriteAtlas, 9);
        Sprite pathSprite = new Sprite("path", spriteAtlas, 8);
        Sprite batSprite = new Sprite("enemy", spriteAtlas, 12);
        Sprite borderSprite = new Sprite("border", spriteAtlas, 6);
        Sprite dudeSprite = new Sprite("dude", dudeAtlas, 0, 9, 14f);
        scene.addSprite(grassSprite);
        scene.addSprite(borderSprite);
        scene.addSprite(pathSprite);
        scene.addSprite(explosionSprite);
        scene.addSprite(waterSprite);
        scene.addSprite(batSprite);
        scene.addSprite(dudeSprite);

        Entity entity;
        for (int x = 0; x < 40; x++) {
            for (int y = 0; y < 40; y++) {
                entity = new Entity("tile-%d-%d".formatted(x, y), y > 9 ? "water" : "grass");
                entity.setPosition(x * 32, y * 32).updateModelMatrix();
                scene.addEntity("0", entity);
                if (y == 8) {
                    entity = new Entity("path-%d-%d".formatted(0, 0), "path");
                    entity.setPosition(x * 32, y * 32).updateModelMatrix();
                    scene.addEntity("1", entity);
                    entity = new Entity("border-%d-%d".formatted(0, 0), "border");
                    entity.setPosition(x * 32, 10 * 32).updateModelMatrix();
                    scene.addEntity("1", entity);
                }
            }
        }

        entity = new Entity("explosion", "explosion");
        entity.setPosition(9 * 32 + 16, 5 * 32).updateModelMatrix();
        scene.addEntity("effects", entity);

        entity = new Entity("bat-0", "enemy");
        entity.setPosition(24 * 32, 7 * 32).updateModelMatrix();
        scene.addEntity("1", entity);

        entity = new Entity("dude-0", "dude");
        entity.setPosition(-32, 8 * 32 + 5).updateModelMatrix();
        scene.addEntity("1", entity);
        dude = entity;
    }

    @Override
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
        float camX = cameraPosition.x;
        float camY = cameraPosition.y;
        if (camY < 0) {
            camY = 0;
        } else if (camY > 640) {
            camY = 640;
        }
        if (camX < 0) {
            camX = 0;
        } else if(camX > 640) {
            camX = 640;
        }
        camera.setPosition(camX, camY);
    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        dudePositionX += 1;
        dudePositionY = 8 * 32 - 9;
        Camera camera = scene.getCamera();
        if (dudePositionX > 320 && camera.getPosition().x < 640 && !moveCameraBack) {
            scene.getCamera().moveRight(1f);
//            scene.getCamera().moveUp((float) Math.sin(dudePositionX / 70f));
//            scene.getCamera().moveUp(2f);
        }
        if (dudePositionX > 640 * 2) {
            dudePositionX = -32;
            moveCameraBack = true;
        }
        if (moveCameraBack) {
            if (camera.getPosition().x > 40) {
                camera.moveLeft(20);
            } else {
                moveCameraBack = false;
                camera.setPosition(0, 0);
            }
        }
        dude.setPosition(dudePositionX, dudePositionY).updateModelMatrix();
    }

}
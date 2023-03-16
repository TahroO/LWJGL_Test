package brot.lwjgl.game;

import brot.lwjgl.engine.*;
import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteAtlas;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Layer;
import brot.lwjgl.engine.scene.Scene;
import org.lwjgl.glfw.GLFW;

public class Main implements AppLogic {
    private int direction = 0;
    private float clearColor = 0f;
    private Entity enemy;
    private float enemyPosition = -32f;

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
        Sprite dudeSprite = new Sprite("dude", dudeAtlas, 0, 9, 9f);
        scene.addSprite(grassSprite);
        scene.addSprite(borderSprite);
        scene.addSprite(pathSprite);
        scene.addSprite(explosionSprite);
        scene.addSprite(waterSprite);
        scene.addSprite(batSprite);
        scene.addSprite(dudeSprite);

        Entity entity;
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
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

        entity = new Entity("dude-0", "dude");
        entity.setPosition(-32, 8 * 32 + 5).updateModelMatrix();
        scene.addEntity("1", entity);
        enemy = entity;
    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis) {
        if (window.isKeyPressed(GLFW.GLFW_KEY_UP)) {
            direction = 1;
        } else if (window.isKeyPressed(GLFW.GLFW_KEY_DOWN)) {
            direction = -1;
        } else {
            direction = 0;
        }
    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        clearColor += direction * 0.01f;
        if (clearColor > 1) {
            clearColor = 1.0f;
        } else if (clearColor < 0) {
            clearColor = 0.0f;
        }
        enemyPosition += 1;
        if (enemyPosition > 640) {
            enemyPosition = -32;
        }
        enemy.setPosition(enemyPosition, 8 * 32 - 9).updateModelMatrix();
        window.setClearColor(clearColor, clearColor, clearColor);
    }

}
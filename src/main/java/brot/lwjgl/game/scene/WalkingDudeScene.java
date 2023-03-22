package brot.lwjgl.game.scene;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.SceneLayer;
import brot.lwjgl.engine.scene.Scene;

public class WalkingDudeScene {
    private static Entity dude;
    private static float dudePositionX;
    private static float dudePositionY;
    private static boolean moveCameraBack;

    public static void init(Scene scene) {
        scene.addLayer(new SceneLayer("0"));
        scene.addLayer(new SceneLayer("1"));
        scene.addLayer(new SceneLayer("effects"));
        SpriteSheet spriteAtlas = new SpriteSheet("/models/spriteatlas.png", 10, 5);
        SpriteSheet dudeAtlas = new SpriteSheet("/models/dude-walking.png", 9, 1);

        Sprite waterSprite = new Sprite("water", spriteAtlas, 0);
        Sprite explosionSprite = new Sprite("explosion", spriteAtlas, 20);
        Sprite grassSprite = new Sprite("grass", spriteAtlas, 9);
        Sprite pathSprite = new Sprite("path", spriteAtlas, 8);
        Sprite batSprite = new Sprite("enemy", spriteAtlas, 12);
        Sprite borderSprite = new Sprite("border", spriteAtlas, 6);
        Sprite dudeSprite = new Sprite("dude", dudeAtlas, 0);
        scene.addSprite(grassSprite);
        scene.addSprite(borderSprite);
        scene.addSprite(pathSprite);
        scene.addSprite(explosionSprite);
        scene.addSprite(waterSprite);
        scene.addSprite(batSprite);
        scene.addSprite(dudeSprite);

        int width = 40;
        int height = 40;
        scene.setDimension(width * 32, height * 32);

        Entity entity;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
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

    public static void input(Scene scene) {

    }

    public static void update(Scene scene) {
        dudePositionX += 1;
        dudePositionY = 8 * 32 - 9;

        Camera camera = scene.getCamera();
        if (dudePositionX > scene.getViewportWidth() / 2f && camera.getPosition().x < scene.getWidth() - scene.getViewportWidth() && !WalkingDudeScene.moveCameraBack) {
            scene.getCamera().moveRight(1f);
        }
        if (dudePositionX > scene.getWidth()) {
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

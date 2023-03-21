package brot.lwjgl.engine.testing.scenes;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.layers.ObjectLayer;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.layers.TileLayer;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.joml.Vector2f;

import java.util.*;

import static org.lwjgl.glfw.GLFW.*;

public class TiledMapScene {
    Entity player;

    public void init(Scene scene) {
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "map-2.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        for (TiledLayer layer : map.layers) {
            if (layer instanceof TiledTileLayer || layer instanceof TiledObjectLayer) {
                SceneLayer sceneLayer = addSceneLayer(scene, map, layer);
                if (layer.id == 4) {

                    player = sceneLayer.getEntities().stream()
                            .filter(entity -> entity.getName() != null && entity.getType().equals("player"))
                            .findFirst()
                            .orElseThrow(RuntimeException::new);
                    player.sprite = sceneLayer.getSprite("tile-308");
                }
            }
        }
    }

    private SceneLayer addSceneLayer(Scene scene, TiledMap map, TiledLayer tiledLayer) {
        // Add scene layer.
        SceneLayer sceneLayer;
        if (tiledLayer instanceof TiledTileLayer) {
            sceneLayer = new TileLayer("tiled-layer-%s".formatted(tiledLayer.id));
        } else if (tiledLayer instanceof TiledObjectLayer) {
            sceneLayer = new ObjectLayer("tiled-layer-%s".formatted(tiledLayer.id));
        } else {
            throw new RuntimeException("Missing scene layer type for " + tiledLayer.getClass().getName());
        }
        scene.addLayer(sceneLayer);

        // Add sprites.
        tiledLayer.getSprites(map).forEach(sceneLayer::addSprite);

        // Add entities.
        tiledLayer.getEntities(map).forEach(sceneLayer::addEntity);

        return sceneLayer;
    }

    public void input(Window window, Scene scene, long diffTimeMillis) {
        if (window.isKeyPressed(GLFW_KEY_A)) {
            player.getPosition().x -= 1.8;
            player.setOrientationX(-1);
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            player.getPosition().x += 1.8;
            player.setOrientationX(1);
        }
        player.updateModelMatrix();

    }

    public void update(Scene scene, long diffTimeMillis) {
//        updatePlayerGravity();
        scene.getLayers().stream()
                .map(layer -> layer.getCollisions(player))
                .flatMap(c -> c.entrySet().stream())
                .forEach(this::resolveCollision);
    }

    protected void resolveCollision(Map.Entry<Entity, List<SceneLayer.CollisionResultTest>> collisions) {
//        Entity layerEntity = collisions.getValue().get(0).layerEntity();
//
//        Sprite layerEntitySprite = collisions.getValue().get(0).layerSprite();
//        Entity otherEntity = collisions.getValue().get(0).otherEntity();
//        Sprite otherEntitySprite = player.sprite;
        for (SceneLayer.CollisionResultTest cr : collisions.getValue()) {
            Sprite.CollisionObject lco = cr.c1();
            Sprite.CollisionObject pco = cr.c2();
            Vector2f lep = cr.p1();
            Vector2f pep = cr.p2();
            if (lep.x < pep.x) {
                // Move back right.
                cr.e2().getPosition().x = lco.x() + lco.width() + 10;
            } else if (lep.x > pep.x) {
                // Move back left.
                cr.e2().getPosition().x = lep.x + 1;
            }
        }


        int x = 1;
    }

    private void updatePlayerGravity() {
        player.getPosition().y += 8;
    }

}

package brot.lwjgl.game.scene;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.entity.Player;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.util.XmlLoader;
import brot.lwjgl.game.scene.collision.Vector;

import java.util.*;

public class CollisionScene {
    Player player;
    private List<GameObject> birds = new ArrayList<>();
    private Sprite idleSprite;

    public CollisionScene() {
    }

    public void init(Window window, Scene scene) {
        XmlLoader.setBasePath("/tiled/testmap/");
        Map<String, Entity> namedEntities = XmlLoader.loadScene(scene, "collisions-2.tmx");

        player = (Player) namedEntities.get("player");
        SceneLayer playerLayer = scene.getLayer(SceneLayer.ID_FORMAT.formatted(2));
        idleSprite = playerLayer.getSprite(player.getSpriteId());
        player.addState(new GameObject.State("idle", idleSprite));
        player.switchState("idle");

        birds.add((GameObject) namedEntities.get("bird1"));
        birds.add((GameObject) namedEntities.get("bird2"));
        birds.add((GameObject) namedEntities.get("bird3"));
        Random rng = new Random();
        birds.forEach(bird -> bird.velocity.x = 30 + rng.nextInt(20));
    }

    public void keyEvent(int key, int action) {
        player.keyEvent(key, action);
    }

    public void input(Window window, Scene scene, long diffTimeMs) {
    }

    public void update(Scene scene, long diffTimeMs) {
        for (GameObject bird : birds) {
            if (bird.getPosition().x > 800 && bird.velocity.x > 0
                    || bird.getPosition().x < 150 && bird.velocity.x < 0) {
                bird.velocity.x *= -1;
            }
            Vector.mulAddScalarTo(bird.getPosition(), bird.getVelocity(), 1d / diffTimeMs);
            bird.update(diffTimeMs);
            bird.updateModelMatrix();
        }

        player.update(diffTimeMs);

        if (player.getCollisionObject() != null) {
            scene.getLayers().stream()
                    .filter(SceneLayer::isVisible)
                    .forEach(layer -> layer.checkCollisions(player, 1d / diffTimeMs));
        }

        Vector.mulAddScalarTo(player.getPosition(), Vector.add(player.getVelocity(), player.m_posCorrect), 1d / diffTimeMs);
        player.m_posCorrect.set(0, 0);
        player.updateModelMatrix();
        updateCamera(scene);
    }

    private void updateCamera(Scene scene) {
        float scrollPos = 0.75f;
        Camera camera = scene.getCamera();
        double playerViewportPosition = player.getPosition().x() - camera.getPosition().x();
        if (player.velocity.x > 0
                && playerViewportPosition > scene.getViewportWidth() * scrollPos
                && camera.getPosition().x <= scene.getWidth() - scene.getViewportWidth()) {
            int cameraX = Math.min((int) (player.getPosition().x() - scene.getViewportWidth() * scrollPos), scene.getWidth() - scene.getViewportWidth());
            scene.getCamera().setPosition(cameraX, camera.getPosition().y);
        } else if (player.velocity.x < 0
                && playerViewportPosition < scene.getViewportWidth() * (1 - scrollPos)
                && camera.getPosition().x >= 0) {
            int cameraX = Math.max((int) (player.getPosition().x() - scene.getViewportWidth() * (1 - scrollPos)), 0);
            scene.getCamera().setPosition(cameraX, camera.getPosition().y);
        }
    }

}

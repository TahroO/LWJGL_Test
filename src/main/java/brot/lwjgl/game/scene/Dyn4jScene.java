package brot.lwjgl.game.scene;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.tiled.*;
import brot.lwjgl.engine.util.XmlLoader;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.*;
import org.dyn4j.world.World;

import java.util.Map;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.GLFW.*;

public class Dyn4jScene {
    float scale = 100f;
    GameObject player;
    boolean upPressed, leftPressed, rightPressed, downPressed;
    World<Body> world = new World<>();
    Body no;

    public Dyn4jScene() {

    }

    public void init(Window window, Scene scene) {
        XmlLoader.setBasePath("/tiled/testmap/");
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, "dyn4j-test.tmx");
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        Map<String, Entity> namedEntities = map.layers.stream()
                .filter(tiledLayer -> tiledLayer instanceof TiledTileLayer || tiledLayer instanceof TiledObjectLayer || tiledLayer instanceof TiledImageLayer)
                .flatMap(tiledLayer -> tiledLayer.createSceneLayer(map, scene).entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        player = (GameObject) namedEntities.get("player");

//        player.setPosition(player.getPosition().x + 16, player.getPosition().y + 16).updateModelMatrix();
//        player.setRotation(3f).updateModelMatrix();
//        player.setPosition(player.getPosition().x - 16, player.getPosition().y - 16).updateModelMatrix();

        Body bottom = new Body();
        bottom.addFixture(Geometry.createRectangle(640.0 / scale, 32.0 / scale));
        bottom.translate(toWorldCoorinates(0f, 608f, 640f, 32f));
        bottom.setMass(MassType.INFINITE);
        world.addBody(bottom);

        no = new Body();
        no.setUserData("player");
        no.addFixture(Geometry.createSquare(32 / scale), 3, 0.1, .75);
        no.translate(toWorldCoorinates(player.getPosition().x, player.getPosition().y, 32, 32));
        no.setMass(MassType.NORMAL);
//        no.getTransform().setRotation(1f);
        world.addBody(no);

        player.getModelMatrix().translate(16, 16, 0);
        player.getModelMatrix().rotateZ(1f);
        player.getModelMatrix().translate(-16, -16, 0);

    }

    public void keyEvent(int key, int action) {
        if (key == GLFW_KEY_D) {
            if (action == GLFW_PRESS && !rightPressed) {
                rightPressed = true;
            } else if (action == GLFW_RELEASE) {
                rightPressed = false;
            }
        }
        if (key == GLFW_KEY_A) {
            if (action == GLFW_PRESS && !leftPressed) {
                leftPressed = true;
            } else if (action == GLFW_RELEASE) {
                leftPressed = false;
            }
        }
        if (key == GLFW_KEY_W) {
            if (action == GLFW_PRESS && !upPressed) {
                upPressed = true;
            } else if (action == GLFW_RELEASE) {
                upPressed = false;
            }
        }
        if (key == GLFW_KEY_S) {
            if (action == GLFW_PRESS && !downPressed) {
                downPressed = true;
            } else if (action == GLFW_RELEASE) {
                downPressed = false;
            }
        }
    }

    public void input(Window window, Scene scene, long diffTimeMillis) {

    }

    private Vector2 toWorldCoorinates(double x, double y, double width, double height) {
        double vpHeight = 640;
        Vector2 v = new Vector2();
        // convert the screen space point to world space
        v.x = (x + width * 0.5) / scale;
        v.y = (vpHeight - y - height * 0.5) / scale;
        return v;
    }

    private Vector2 toScreenCoordinates(float x, float y, float width, float height) {
        float vpHeight = 640;
        Vector2 v = new Vector2();
        v.x = (x - width * 0.5) * scale;
        v.y = vpHeight - (y + height * 0.5) * scale;
        return v;
    }

    public void update(Scene scene, long diffTimeMillis) {
//        player.setPosition(player.getPosition().x + 16, player.getPosition().y + 16).updateModelMatrix();
//        player.setRotation(.05f);
//        player.setPosition(player.getPosition().x - 16, player.getPosition().y - 16).updateModelMatrix();
//        player.getModelMatrix().translate(16, 16, 0);
//        player.getModelMatrix().rotateZ(.05f);
//        player.getModelMatrix().translate(-16, -16, 0);
//        player.setPosition(player.getPosition().x - 16, player.getPosition().y - 16).updateModelMatrix();
        if (rightPressed) {
            no.applyForce(new Vector2(.1, 0));
        } else if (leftPressed) {
            no.applyForce(new Vector2(-.1, 0));
        }


        world.update(diffTimeMillis / 1000f);
        for (Body body : world.getBodies()) {
            // get the updated body center
            Vector2 xy = body.getWorldCenter();
            Object userData = body.getUserData();
            for (BodyFixture fixture : body.getFixtures()) {
                Convex c = fixture.getShape();

                if (c instanceof Rectangle && userData != null && userData.equals("player")) {
                    float rot = (float) body.getTransform().getRotationAngle();
                    player.getModelMatrix().translate(16, 16, 0);
                    player.getModelMatrix().rotateZ(rot);
                    player.getModelMatrix().translate(-16, -16, 0);
                    Vector2 v = toScreenCoordinates((float) xy.x, (float) xy.y, (float) ((Rectangle) c).getWidth(), (float) ((Rectangle) c).getHeight());
                    player.setPosition((float) v.x, (float) v.y).updateModelMatrix();
//                    player.getModelMatrix().translate(player.getPosition().x - (float) v.x, player.getPosition().y - (float) v.y, 0);
                }
            }
        }
    }

}

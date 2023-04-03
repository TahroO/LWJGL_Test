package brot.lwjgl.game.scene;

import brot.lwjgl.engine.Window;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Camera;
import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.engine.scene.entity.Player;
import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.util.XmlLoader;
import brot.lwjgl.game.scene.collision.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ParallaxScene {

    public void init(Window window, Scene scene) {
        XmlLoader.setBasePath("/tiled/testmap/");
        Map<String, Entity> namedEntities = XmlLoader.loadScene(scene, "parallax-wood.tmx");
    }

    public void keyEvent(int key, int action) {
    }

    public void input(Window window, Scene scene, long diffTimeMs) {
    }

    public void update(Window window, Scene scene, long diffTimeMs) {
        CameraHelper.moveCameraWithKeys(window, scene, diffTimeMs);
    }

}

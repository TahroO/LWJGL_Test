package brot.lwjgl.engine;

import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.scene.Scene;

public interface AppLogic {

    void cleanup();

    void init(Window window, Scene scene, Render render);

    void input(Window window, Scene scene, long diffTimeMillis);

    void update(Window window, Scene scene, long diffTimeMillis);

    void keyEvent(int key, int action);
}
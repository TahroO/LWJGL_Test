package brot.lwjgl.engine.control;

import static org.lwjgl.glfw.GLFW.*;

public class Keyboard {
    protected final int numKeyCodes = GLFW_KEY_LAST;
    protected final boolean[] liveKeyState;
    protected final boolean[] keyState;
    protected final boolean[] lastKeyState;

    public Keyboard() {
        liveKeyState = new boolean[numKeyCodes];
        keyState = new boolean[numKeyCodes];
        lastKeyState = new boolean[numKeyCodes];
    }

    public void keyEvent(int key, int action) {
        if (action == GLFW_PRESS) {
            liveKeyState[key] = true;
        } else if (action == GLFW_RELEASE) {
            liveKeyState[key] = false;
        }
    }

    public void update() {
        for (int i = 0; i < numKeyCodes; i++) {
            lastKeyState[i] = keyState[i];
            keyState[i] = liveKeyState[i];
        }
    }

    public boolean isKeyDown(int key) {
        return keyState[key];
    }

    public boolean isKeyDownTransition(int key) {
        return lastKeyState[key] && keyState[key];
    }

}

package brot.lwjgl.engine;

import brot.lwjgl.engine.graph.Render;
import brot.lwjgl.engine.scene.Scene;

public class Engine {

    public static final int TARGET_UPS = 60;
    private final AppLogic appLogic;
    private final Window window;
    private Render render;
    private boolean running;
    private Scene scene;
    private int targetFps;
    private int targetUps;

    public Engine(String windowTitle, Window.WindowOptions opts, AppLogic appLogic) {
        window = new Window(windowTitle, opts, this::resize, this::keyEvent);
        targetFps = opts.fps;
        targetUps = opts.ups;
        this.appLogic = appLogic;
        render = new Render();
        scene = new Scene(window.getWidth(), window.getHeight());
        appLogic.init(window, scene, render);
        running = true;
    }

    private void cleanup() {
        appLogic.cleanup();
        render.cleanup();
        scene.cleanup();
        window.cleanup();
    }

    private Void resize() {
        scene.resize(window.getWidth(), window.getHeight());
        return null;
    }

    // Debugging.
    private boolean printUpdateDurations;
    private long timeer;
    private int frames;
    private int durationSum;

    private void run() {
        long initialTime = System.currentTimeMillis();
        float timeU = 1000.0f / targetUps;
        float timeR = targetFps > 0 ? 1000.0f / targetFps : 0;
        float deltaUpdate = 0;
        float deltaFps = 0;

        long updateTime = initialTime;
        while (running && !window.windowShouldClose()) {
            window.pollEvents();

            long now = System.currentTimeMillis();
            long startUpdate = System.nanoTime();
            deltaUpdate += (now - initialTime) / timeU;
            deltaFps += (now - initialTime) / timeR;

            if (targetFps <= 0 || deltaFps >= 1) {
                window.getMouseInput().input();
                appLogic.input(window, scene, now - initialTime);
            }

            if (deltaUpdate >= 1) {
                long diffTimeMillis = now - updateTime;
                appLogic.update(window, scene, diffTimeMillis);
                updateTime = now;
                deltaUpdate--;
            }

            long updateDuration = System.nanoTime() - startUpdate;
            durationSum += updateDuration;
            frames++;
            if (printUpdateDurations && startUpdate - timeer > 1000000000L) {
                System.out.println((durationSum / (float) frames) / 1000000f + " ms");
                timeer = startUpdate;
                frames = 0;
                durationSum = 0;
            }

            if (targetFps <= 0 || deltaFps >= 1) {
                render.render(window, scene);
                deltaFps--;
                window.update();
            }
            initialTime = now;
        }

        cleanup();
    }

    public void start() {
        running = true;
        run();
    }

    public void stop() {
        running = false;
    }

    public Void keyEvent(int key, int action) {
        appLogic.keyEvent(key, action);
        return null;
    }

}
package brot.lwjgl.engine.scene;

import brot.lwjgl.engine.scene.layer.SceneLayer;
import brot.lwjgl.engine.scene.projection.Ortho2D;
import brot.lwjgl.engine.scene.projection.Projection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Scene {
    protected int sceneWidth;
    protected int sceneHeight;
    protected int viewportWidth;
    protected int viewportHeight;
    private Projection projection;
    private Map<String, SceneLayer> layers;
    protected Camera camera;
    protected float aspectRatio;

    public Scene(int width, int height) {
        this.sceneWidth = width;
        this.sceneHeight = height;
        this.viewportWidth = width;
        this.viewportHeight = height;
        this.aspectRatio = (float) viewportWidth / (float) viewportHeight;
        projection = new Ortho2D(width, height, width, height);
        layers = new HashMap<>();
        camera = new Camera();
    }

    public void cleanup() {
        layers.values().forEach(SceneLayer::cleanup);
    }

    /**
     * Sets the scene dimension.
     *
     * @param width Scene width in pixel.
     * @param height Scene height in pixel.
     */
    public void setDimension(int width, int height) {
        this.sceneWidth = width;
        this.sceneHeight = height;
    }

    public int getViewportWidth() {
        return viewportWidth;
    }

    public int getViewportHeight() {
        return viewportHeight;
    }

    public int getWidth() {
        return sceneWidth;
    }

    public int getHeight() {
        return sceneHeight;
    }

    public void addLayer(SceneLayer layer) {
        layers.put(layer.getId(), layer);
    }

    public List<SceneLayer> getLayers() {
        return layers
                .values()
                .stream()
                .sorted(Comparator.comparingInt(SceneLayer::getWeight))
                .collect(Collectors.toList());
    }

    public Camera getCamera() {
        return camera;
    }

    public Projection getProjection() {
        return projection;
    }

    public void resize(int windowWidth, int windowHeight) {
//        float v = (float) windowWidth / (float) windowHeight;
//        if (v * aspectRatio >= 1f) {
//            viewportWidth = Math.round(windowWidth / v * aspectRatio);
//            viewportHeight = windowHeight;
//        } else {
//            viewportWidth = windowWidth;
//            viewportHeight = Math.round(windowHeight / v * aspectRatio);
//        }
//        projection.updateProjMatrix(windowWidth, windowHeight);
    }

}

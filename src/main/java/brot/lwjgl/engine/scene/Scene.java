package brot.lwjgl.engine.scene;

import brot.lwjgl.engine.scene.layers.SceneLayer;
import brot.lwjgl.engine.scene.projection.Ortho2D;
import brot.lwjgl.engine.scene.projection.Projection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Scene {
    protected int width;
    protected int height;
    protected int viewportWidth;
    protected int viewportHeight;
    private Projection projection;
    private Map<String, SceneLayer> layers;
    protected Camera camera;

    public Scene(int width, int height) {
        this.width = width;
        this.height = height;
        this.viewportWidth = width;
        this.viewportHeight = height;
        projection = new Ortho2D(width, height);
        layers = new HashMap<>();
        camera = new Camera();
    }

    public void cleanup() {
        layers.values().forEach(SceneLayer::cleanup);
    }

    public void setDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getViewportWidth() {
        return viewportWidth;
    }

    public int getViewportHeight() {
        return viewportHeight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public void resize(int width, int height) {
        //projection.updateProjMatrix(width, height);
    }

}

package brot.lwjgl.engine.scene;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.model.Sprite;
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

    private Map<String, Mesh> meshMap;
    private Projection projection;
    protected Map<String, Sprite> spriteMap;
    private Map<String, SceneLayer> layers;
    protected Camera camera;

    public Scene(int width, int height) {
        this.width = width;
        this.height = height;
        this.viewportWidth = width;
        this.viewportHeight = height;
        meshMap = new HashMap<>();
        spriteMap = new HashMap<>();
        projection = new Ortho2D(width, height);
        layers = new HashMap<>();
        camera = new Camera();
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

    public void cleanup() {
        meshMap.values().forEach(Mesh::cleanup);
    }

    public void addMesh(String meshId, Mesh mesh) {
        meshMap.put(meshId, mesh);
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

    public Map<String, Mesh> getMeshMap() {
        return meshMap;
    }

    public void addSprite(Sprite sprite) {
        spriteMap.put(sprite.getId(), sprite);
    }

    public void addEntity(String layerId, Entity entity) {
        String spriteId = entity.getSpriteId();
        Sprite sprite = spriteMap.get(spriteId);
        if (sprite == null) {
            throw new RuntimeException("Could not find model [" + spriteId + "]");
        }
        sprite.addEntity(entity);
        layers.get(layerId).addEntity(entity);
    }

    public Map<String, Sprite> getSprites() {
        return spriteMap;
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

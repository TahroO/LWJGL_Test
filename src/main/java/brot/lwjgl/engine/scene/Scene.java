package brot.lwjgl.engine.scene;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.scene.projection.OrthographicProjection;
import brot.lwjgl.engine.scene.projection.Projection;

import java.util.HashMap;
import java.util.Map;

public class Scene {

    private Map<String, Mesh> meshMap;
    private Projection projection;

    public Scene(int width, int height) {
        meshMap = new HashMap<>();
        projection = new OrthographicProjection(width, height);
    }

    public void cleanup() {
        meshMap.values().forEach(Mesh::cleanup);
    }

    public void addMesh(String meshId, Mesh mesh) {
        meshMap.put(meshId, mesh);
    }

    public Map<String, Mesh> getMeshMap() {
        return meshMap;
    }

    public Projection getProjection() {
        return projection;
    }

    public void resize(int width, int height) {
        projection.updateProjMatrix(width, height);
    }

}

package brot.lwjgl.engine.graph;

import brot.lwjgl.engine.scene.Scene;
import org.joml.Matrix4f;
import org.joml.Vector2i;

import java.util.*;

import static org.lwjgl.opengl.GL30.*;

public class SceneRender {
    private ShaderProgram shaderProgram;
    private UniformsMap uniformsMap;

    private Texture texture;
    private long startedTime;

    public SceneRender() {
        List<ShaderProgram.ShaderModuleData> shaderModuleDataList = new ArrayList<>();
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("/shaders/scene.vert", GL_VERTEX_SHADER));
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("/shaders/scene.frag", GL_FRAGMENT_SHADER));
        shaderProgram = new ShaderProgram(shaderModuleDataList);
        createUniforms();
        texture = new Texture("/models/bird-animation.png");
        startedTime = System.currentTimeMillis();
    }

    public void cleanup() {
        shaderProgram.cleanup();
    }

    private void createUniforms() {
        uniformsMap = new UniformsMap(shaderProgram.getProgramId());
        uniformsMap.createUniform("projectionMatrix");
        uniformsMap.createUniform("modelMatrix");
        uniformsMap.createUniform("time");
        uniformsMap.createUniform("txtSampler");
        uniformsMap.createUniform("txtSize");
        uniformsMap.createUniform("txtFps");
        uniformsMap.createUniform("txtFrames");
        uniformsMap.createUniform("txtIndex");
    }

    public void render(Scene scene) {
        shaderProgram.bind();
        uniformsMap.setUniform("projectionMatrix", scene.getProjection().getProjMatrix());
        uniformsMap.setUniform("time", (System.currentTimeMillis() - startedTime) / 1000f);
        uniformsMap.setUniform("txtSampler", 0);
        uniformsMap.setUniform("txtSize", new Vector2i(4, 2));
        uniformsMap.setUniform("txtIndex", 0);
        uniformsMap.setUniform("txtFrames", 8);
        uniformsMap.setUniform("txtFps", 8f);

        glActiveTexture(GL_TEXTURE0);
        texture.bind();

        scene.getMeshMap().values().forEach(mesh -> {
            glBindVertexArray(mesh.getVaoId());
            uniformsMap.setUniform("modelMatrix", new Matrix4f());
            glDrawElements(GL_TRIANGLES, mesh.getNumVertices(), GL_UNSIGNED_INT, 0);
        });

        glBindVertexArray(0);
        shaderProgram.unbind();
    }

}
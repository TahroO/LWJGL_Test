package brot.lwjgl.engine.graph;

import brot.lwjgl.engine.graph.texture.SpriteAtlas;
import brot.lwjgl.engine.scene.Scene;
import org.joml.Matrix4f;
import org.joml.Vector2f;

import java.util.*;

import static org.lwjgl.opengl.GL30.*;

public class SceneRender {
    private ShaderProgram shaderProgram;
    private UniformsMap uniformsMap;

    private SpriteAtlas spriteAtlas;
    private long startedTime;

    public SceneRender() {
        List<ShaderProgram.ShaderModuleData> shaderModuleDataList = new ArrayList<>();
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("/shaders/sprite.vert", GL_VERTEX_SHADER));
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("/shaders/sprite.frag", GL_FRAGMENT_SHADER));
        shaderProgram = new ShaderProgram(shaderModuleDataList);
        createUniforms();
        spriteAtlas = new SpriteAtlas("/models/bird-animation.png", 2, 4);
        startedTime = System.currentTimeMillis();
    }

    public void cleanup() {
        shaderProgram.cleanup();
        spriteAtlas.cleanup();
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
        uniformsMap.setUniform("txtSize", spriteAtlas.getSize());
        uniformsMap.setUniform("txtIndex", 0f);
        uniformsMap.setUniform("txtFrames", 8f);
        uniformsMap.setUniform("txtFps", 12f);

        glActiveTexture(GL_TEXTURE0);
        spriteAtlas.bind();

        scene.getMeshMap().values().forEach(mesh -> {
            glBindVertexArray(mesh.getVaoId());
            uniformsMap.setUniform("modelMatrix", new Matrix4f());
            glDrawElements(GL_TRIANGLES, mesh.getNumVertices(), GL_UNSIGNED_INT, 0);
        });

        glBindVertexArray(0);
        shaderProgram.unbind();
    }

}
package brot.lwjgl.engine.testing;

import brot.lwjgl.engine.graph.ShaderProgram;
import brot.lwjgl.engine.graph.UniformsMap;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Scene;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class TestSceneRender {
    private final ShaderProgram shaderProgram;
    private UniformsMap uniformsMap;
    private long startedTime;

    private ColorMesh mesh1 = ColorMesh.getTestTriangle(1.5f);
    private ColorMesh mesh2 = ColorMesh.getTestTriangle(0.3f, ColorMesh.colorWhite());
    private Matrix4f projectionMatrix = new Matrix4f();

    public TestSceneRender() {
        List<ShaderProgram.ShaderModuleData> shaderModuleDataList = new ArrayList<>();
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("/shaders/test.vert", GL_VERTEX_SHADER));
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("/shaders/test.frag", GL_FRAGMENT_SHADER));
        shaderProgram = new ShaderProgram(shaderModuleDataList);
        createUniforms();
        startedTime = System.currentTimeMillis();


    }

    public void cleanup() {
        shaderProgram.cleanup();
    }

    private void createUniforms() {
        uniformsMap = new UniformsMap(shaderProgram.getProgramId());
        uniformsMap.createUniform("projectionMatrix");
//        uniformsMap.createUniform("useTexture");
//        uniformsMap.createUniform("viewMatrix");
//        uniformsMap.createUniform("modelMatrix");
    }

    public void render(Scene scene) {
        glEnable(GL_BLEND);
        glBlendEquation(GL_FUNC_ADD);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        shaderProgram.bind();

        uniformsMap.setUniform("projectionMatrix", scene.getProjection().getProjMatrix());
//        uniformsMap.setUniform("viewMatrix", scene.getCamera().getViewMatrix());

        glViewport(160, 160, 320, 320);
//        stencilTest();
        glBindVertexArray(mesh1.getVaoId());
        glDrawElements(GL_TRIANGLES, mesh1.getNumVertices(), GL_UNSIGNED_INT, 0);


        glBindVertexArray(0);
        shaderProgram.unbind();
    }

    private void stencilTest() {
        glEnable(GL_STENCIL_TEST);
        glStencilFunc(GL_ALWAYS, 1, 0xff);
        glStencilOp(GL_KEEP, GL_KEEP, GL_REPLACE);
        glBindVertexArray(mesh2.getVaoId());
        glDrawElements(GL_TRIANGLES, mesh2.getNumVertices(), GL_UNSIGNED_INT, 0);

        glStencilFunc(GL_EQUAL, 1, 0xff);
        glStencilOp(GL_KEEP, GL_KEEP, GL_KEEP);
        glBindVertexArray(mesh1.getVaoId());
        glDrawElements(GL_TRIANGLES, mesh1.getNumVertices(), GL_UNSIGNED_INT, 0);
    }

    protected void renderEntity(Entity entity) {

    }

}
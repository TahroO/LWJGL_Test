package brot.lwjgl.engine.graph;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.layers.SceneLayer;
import brot.lwjgl.engine.scene.Scene;

import java.util.*;

import static org.lwjgl.opengl.GL30.*;

public class SceneRender {
    private final ShaderProgram shaderProgram;
    private UniformsMap uniformsMap;
    private long startedTime;

    public SceneRender() {
        List<ShaderProgram.ShaderModuleData> shaderModuleDataList = new ArrayList<>();
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("/shaders/sprite.vert", GL_VERTEX_SHADER));
        shaderModuleDataList.add(new ShaderProgram.ShaderModuleData("/shaders/sprite.frag", GL_FRAGMENT_SHADER));
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
        uniformsMap.createUniform("viewMatrix");
        uniformsMap.createUniform("modelMatrix");
        uniformsMap.createUniform("txtSampler");
        uniformsMap.createUniform("spriteSheetSize");
        uniformsMap.createUniform("spriteIndex");
//        uniformsMap.createUniform("spriteOrientation");
    }

    /**
     * Renders a scene.
     *
     * @param scene A scene object.
     */
    public void render(Scene scene) {
        glEnable(GL_BLEND);
        glBlendEquation(GL_FUNC_ADD);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        shaderProgram.bind();
        uniformsMap.setUniform("projectionMatrix", scene.getProjection().getProjMatrix());
        uniformsMap.setUniform("viewMatrix", scene.getCamera().getViewMatrix());
        uniformsMap.setUniform("txtSampler", 0);
        // TODO Animation start time from entity.
        long time = System.currentTimeMillis() - startedTime;
        scene.getLayers().forEach(layer -> renderLayer(layer, time));
        glBindVertexArray(0);
        shaderProgram.unbind();
    }

    /**
     * Renders a scene layer.
     *
     * @param layer The scene layer.
     * @param time Current time delta sth.
     */
    protected void renderLayer(SceneLayer layer, long time) {
        for (Map.Entry<SpriteSheet, Collection<Sprite>> spriteSheetEntry : layer.getTextures().entrySet()) {
            SpriteSheet spriteSheet = spriteSheetEntry.getKey();
            glActiveTexture(GL_TEXTURE0);
            spriteSheet.bind();
            Mesh spriteMesh = spriteSheet.getSpriteMesh();
            glBindVertexArray(spriteMesh.getVaoId());
            uniformsMap.setUniform("spriteSheetSize", spriteSheet.getSize());
            for (Sprite sprite : spriteSheetEntry.getValue()) {
                uniformsMap.setUniform("spriteIndex", sprite.hasAnimation() ? sprite.getAnimationFrame(time) : sprite.getSpriteIndex());
                for (Entity entity : sprite.getEntities()) {
//                    uniformsMap.setUniform("spriteOrientation", entity.getOrientation());
                    uniformsMap.setUniform("modelMatrix", entity.getModelMatrix());
                    glDrawElements(GL_TRIANGLES, spriteMesh.getNumVertices(), GL_UNSIGNED_INT, 0);
                }
            }
        }
    }

}
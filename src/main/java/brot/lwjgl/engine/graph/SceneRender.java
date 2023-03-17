package brot.lwjgl.engine.graph;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteAtlas;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.Layer;
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
        uniformsMap.createUniform("time");
        uniformsMap.createUniform("txtSampler");
        uniformsMap.createUniform("spriteAtlasSize");
        uniformsMap.createUniform("spriteFps");
        uniformsMap.createUniform("spriteFrames");
        uniformsMap.createUniform("spriteIndex");
    }

    public void render(Scene scene) {
        glEnable(GL_BLEND);
        glBlendEquation(GL_FUNC_ADD);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        shaderProgram.bind();

        uniformsMap.setUniform("projectionMatrix", scene.getProjection().getProjMatrix());
        uniformsMap.setUniform("viewMatrix", scene.getCamera().getViewMatrix());
        uniformsMap.setUniform("time", (System.currentTimeMillis() - startedTime) / 1000f);
        uniformsMap.setUniform("txtSampler", 0);

        Map<String, Sprite> sprites = scene.getSprites();
        for (Layer layer : scene.getLayers()) {
            for (Entity entity : layer.getEntities()) {
                Sprite sprite = sprites.get(entity.getSpriteId());
                SpriteAtlas sa = sprite.getSpriteAtlas();
                glActiveTexture(GL_TEXTURE0);
                sa.bind();
                Mesh mesh = sa.getSpriteMesh();
                glBindVertexArray(mesh.getVaoId());
                // ---
                uniformsMap.setUniform("spriteAtlasSize", sa.getSize());
                uniformsMap.setUniform("spriteIndex", sprite.getSpriteIndex());
                uniformsMap.setUniform("spriteFrames", sprite.getFrames());
                uniformsMap.setUniform("spriteFps", sprite.getFps());
                uniformsMap.setUniform("modelMatrix", entity.getModelMatrix());
                glDrawElements(GL_TRIANGLES, mesh.getNumVertices(), GL_UNSIGNED_INT, 0);
            }
        }

//        for (Sprite sprite : scene.getSprites().values()) {
//            SpriteAtlas sa = sprite.getSpriteAtlas();
//            glActiveTexture(GL_TEXTURE0);
//            sa.bind();
//            Mesh mesh = sa.getSpriteMesh();
//            glBindVertexArray(mesh.getVaoId());
//            for (Entity entity : sprite.getEntities()) {
//                uniformsMap.setUniform("spriteAtlasSize", sa.getSize());
//                uniformsMap.setUniform("spriteIndex", sprite.getSpriteIndex());
//                uniformsMap.setUniform("spriteFrames", sprite.getFrames());
//                uniformsMap.setUniform("spriteFps", sprite.getFps());
//                uniformsMap.setUniform("modelMatrix", entity.getModelMatrix());
//                glDrawElements(GL_TRIANGLES, mesh.getNumVertices(), GL_UNSIGNED_INT, 0);
//            }
//        }

        glBindVertexArray(0);
        shaderProgram.unbind();
    }

    protected void renderEntity(Entity entity) {

    }

}
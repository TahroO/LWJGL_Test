package brot.lwjgl.engine.graph;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.scene.SceneLayer;
import brot.lwjgl.engine.scene.Scene;
import org.joml.Vector2f;

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
        uniformsMap.createUniform("spriteOrientation");
    }

    public void render(Scene scene) {
        glEnable(GL_BLEND);
        glBlendEquation(GL_FUNC_ADD);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        shaderProgram.bind();

        long time = System.currentTimeMillis() - startedTime;
        uniformsMap.setUniform("projectionMatrix", scene.getProjection().getProjMatrix());
        uniformsMap.setUniform("viewMatrix", scene.getCamera().getViewMatrix());
        uniformsMap.setUniform("txtSampler", 0);

        SpriteSheet currentSpriteSheet = null;
        Mesh mesh = null;
        Map<String, Sprite> sprites = scene.getSprites();
        for (SceneLayer layer : scene.getLayers()) {
            for (Entity entity : layer.getEntities()) {
                Sprite sprite = sprites.get(entity.getSpriteId());
                // TODO bind mesh and texture only once per sprite sheet.
                SpriteSheet sa = sprite.getSpriteSheet();
                if (currentSpriteSheet != sa) {
                    glActiveTexture(GL_TEXTURE0);
                    sa.bind();
                    mesh = sa.getSpriteMesh();
                    glBindVertexArray(mesh.getVaoId());
                    uniformsMap.setUniform("spriteSheetSize", sa.getSize());
                    currentSpriteSheet = sa;
                }
                uniformsMap.setUniform("spriteIndex", sprite.hasAnimation() ? sprite.getAnimationFrame(time) : sprite.getSpriteIndex());
                uniformsMap.setUniform("spriteOrientation", entity.getOrientation());
                uniformsMap.setUniform("modelMatrix", entity.getModelMatrix());
                glDrawElements(GL_TRIANGLES, mesh.getNumVertices(), GL_UNSIGNED_INT, 0);
            }
        }
        glBindVertexArray(0);
        shaderProgram.unbind();
    }

}
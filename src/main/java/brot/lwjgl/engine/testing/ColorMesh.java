package brot.lwjgl.engine.testing;


import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;

import java.nio.*;
import java.util.*;

import static org.lwjgl.opengl.GL30.*;

public class ColorMesh {

    private int numVertices;
    private int vaoId;
    private List<Integer> vboIdList;

    public ColorMesh(float[] positions, float[] colors, int[] indices) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            numVertices = indices.length;
            vboIdList = new ArrayList<>();

            vaoId = glGenVertexArrays();
            glBindVertexArray(vaoId);

            // Positions VBO
            int vboId = glGenBuffers();
            vboIdList.add(vboId);
            FloatBuffer positionsBuffer = stack.callocFloat(positions.length);
            positionsBuffer.put(0, positions);
            glBindBuffer(GL_ARRAY_BUFFER, vboId);
            glBufferData(GL_ARRAY_BUFFER, positionsBuffer, GL_STATIC_DRAW);
            glEnableVertexAttribArray(0);
            glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);

            // Color VBO
            vboId = glGenBuffers();
            vboIdList.add(vboId);
            FloatBuffer colorsBuffer = stack.callocFloat(colors.length);
            colorsBuffer.put(0, colors);
            glBindBuffer(GL_ARRAY_BUFFER, vboId);
            glBufferData(GL_ARRAY_BUFFER, colorsBuffer, GL_STATIC_DRAW);
            glEnableVertexAttribArray(1);
            glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);

            // Index VBO
            vboId = glGenBuffers();
            vboIdList.add(vboId);
            IntBuffer indicesBuffer = stack.callocInt(indices.length);
            indicesBuffer.put(0, indices);
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboId);
            glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);

            glBindBuffer(GL_ARRAY_BUFFER, 0);
            glBindVertexArray(0);
        }
    }

    public static ColorMesh getTestTriangle(float scale, float[] colors) {
        float[] positions = new float[]{
                0f, scale,
                -scale, -scale,
                scale, -scale,
        };
        int[] indices = new int[]{
                0, 1, 2
        };
        return new ColorMesh(positions, colors, indices);
    }

    public static float[] colorRgb() {
        return new float[]{
                1f, 0.0f, 0.0f,
                0.0f, 1f, 0.0f,
                0.0f, 0.0f, 1f,
        };
    }

    public static float[] colorWhite() {
        return new float[]{
                1f, 1f, 1f,
                1f, 1f, 1f,
                1f, 1f, 1f,
        };
    }

    public static ColorMesh getTestTriangle(float scale) {
        return ColorMesh.getTestTriangle(scale, ColorMesh.colorRgb());
    }

    public void cleanup() {
        vboIdList.stream().forEach(GL30::glDeleteBuffers);
        glDeleteVertexArrays(vaoId);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public final int getVaoId() {
        return vaoId;
    }
}

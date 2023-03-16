package brot.lwjgl.engine.graph.mesh;

public class Quad extends Mesh {
    protected static final int[] vertexIndices = new int[]{0, 1, 3, 3, 1, 2};

    public Quad(float width, float height, float[] textureCoordinates) {
        super(Quad.getVertexPositions(width, height), textureCoordinates, vertexIndices);
    }

    /**
     * Gets vertex positions.
     *
     * @param width
     * @param height
     * @return
     */
    protected static float[] getVertexPositions(float width, float height) {
        return new float[]{0, 0, 0, height, width, height, width, 0};
    }

}

package brot.lwjgl.engine.graph.mesh;

/**
 * Defines a 2D quad mesh.
 */
public class Quad extends Mesh {
    protected static final int[] vertexIndices = new int[]{0, 1, 3, 3, 1, 2};

    /**
     * Creates a Quad object.
     *
     * @param width Quad width.
     * @param height Quad height.
     * @param textureCoordinates Texture UV coordinates.
     */
    public Quad(float width, float height, float[] textureCoordinates) {
        super(Quad.getVertexPositions(width, height), textureCoordinates, vertexIndices);
    }

    /**
     * Gets the quad's vertex positions.
     *
     * @param width Quad width.
     * @param height Quad height.
     * @return Array with 2D vertex positions.
     */
    protected static float[] getVertexPositions(float width, float height) {
        return new float[]{0, 0, 0, height, width, height, width, 0};
    }

}

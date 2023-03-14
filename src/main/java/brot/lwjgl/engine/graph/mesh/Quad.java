package brot.lwjgl.engine.graph.mesh;

public class Quad extends Mesh {

    public Quad(float width, float height, float[] textureCoordinates) {
        super(
                new float[]{-width, height, -width, -height, width, -height, width, height},
                textureCoordinates,
                new int[]{0, 1, 3, 3, 1, 2}
        );
    }

}

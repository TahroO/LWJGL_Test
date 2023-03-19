package brot.lwjgl.engine.graph.texture;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.*;

import static org.lwjgl.opengl.GL30.*;

/**
 * Defines a texture.
 */
public class Texture {
    protected final int textureId;
    protected final int width;
    protected final int height;

    /**
     * Creates a new Texture object from a byte buffer.
     *
     * @param buf The byte buffer.
     * @param width Image width.
     * @param height Image height.
     */
    public Texture(ByteBuffer buf, int width, int height) {
        this.textureId = createTexture(width, height, buf);
        this.width = width;
        this.height = height;
    }

    /**
     * Creates a new Texture object from a resource name.
     *
     * @param resourceName Name of the image resource to use.
     */
    public Texture(String resourceName) {
        try {
            InputStream is = Texture.class.getResourceAsStream(resourceName);
            BufferedImage image = ImageIO.read(is);
            this.width = image.getWidth();
            this.height = image.getHeight();
            ByteBuffer byteBuffer = convertImage(image);
            this.textureId = createTexture(image.getWidth(), image.getHeight(), byteBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts BufferedImage to ByteBuffer for use as GL texture.
     *
     * @param image The BufferedImage.
     * @return The ByteBuffer.
     */
    protected ByteBuffer convertImage(BufferedImage image) {
        int bytesPerPixel = 4;
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
        ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * bytesPerPixel);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = pixels[y * image.getWidth() + x];
                // RGBA components.
                buffer.put((byte) ((pixel >> 16) & 0xFF));
                buffer.put((byte) ((pixel >> 8) & 0xFF));
                buffer.put((byte) (pixel & 0xFF));
                buffer.put((byte) ((pixel >> 24) & 0xFF));
            }
        }
        buffer.flip();
        return buffer;
    }

    /**
     * Binds the GL texture object.
     */
    public void bind() {
        glBindTexture(GL_TEXTURE_2D, textureId);
    }

    /**
     * Deletes the GL texture object.
     */
    public void cleanup() {
        glDeleteTextures(textureId);
    }

    /**
     * Creates the GL texture object.
     *
     * @param width  Texture width.
     * @param height Texture height.
     * @param buf    The texel data.
     * @return The GL texture name.
     */
    private int createTexture(int width, int height, ByteBuffer buf) {
        int textureId = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, textureId);
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
        glGenerateMipmap(GL_TEXTURE_2D);
        return textureId;
    }

    /**
     * Gets texture width.
     *
     * @return Texture width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets texture height.
     *
     * @return Texture height.
     */
    public int getHeight() {
        return height;
    }

}

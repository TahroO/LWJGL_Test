package brot.lwjgl.engine.graph.texture;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.*;

import static org.lwjgl.opengl.GL30.*;

public class Texture {
    protected final int textureId;
    protected final String resourceName;
    protected final int width;
    protected final int height;

    public Texture(ByteBuffer buf, int width, int height, String resourceName) {
        this.textureId = generateTexture(width, height, buf);
        this.width = width;
        this.height = height;
        this.resourceName = "TEXTURE_%d".formatted(textureId);
    }

    public Texture(String resourceName) {
        try {
            InputStream is = Texture.class.getResourceAsStream(resourceName);
            BufferedImage image = ImageIO.read(is);
            this.width = image.getWidth();
            this.height = image.getHeight();
            ByteBuffer byteBuffer = convertImage(image);
            this.textureId= generateTexture(image.getWidth(), image.getHeight(), byteBuffer);
            this.resourceName = resourceName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, textureId);
    }

    public void cleanup() {
        glDeleteTextures(textureId);
    }

    private int generateTexture(int width, int height, ByteBuffer buf) {
        int textureId = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, textureId);
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
        glGenerateMipmap(GL_TEXTURE_2D);
        return textureId;
    }

    public String getResourceName() {
        return resourceName;
    }

}
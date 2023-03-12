package brot.lwjgl.engine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Utils {

    private Utils() {
        // Utility class
    }

    public static String readFile(String resourceName) {
        try (InputStream is = Utils.class.getResourceAsStream(resourceName)) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int length; (length = is.read(buffer)) != -1; ) {
                os.write(buffer, 0, length);
            }
            return os.toString(StandardCharsets.UTF_8);
        } catch (IOException excp) {
            throw new RuntimeException("Error reading file [" + resourceName + "]", excp);
        }
    }

}

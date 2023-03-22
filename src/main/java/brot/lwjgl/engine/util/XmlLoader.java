package brot.lwjgl.engine.util;

import brot.lwjgl.engine.tiled.TiledTileSet;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XmlLoader {
    private static String basePath;
    private static String basePathFormat;
    private static Map<String, TiledTileSet> tileSetCache;
    private static final Map<Class<?>, JAXBContext> jaxbContexts;

    static {
        jaxbContexts = new ConcurrentHashMap<>();
        tileSetCache = new HashMap<>();
        setBasePath("/tiled/king-pigs/");
    }

    public static void setBasePath(String basePath) {
        XmlLoader.basePath = basePath.endsWith("/") ? basePath : basePath + "/";
        basePathFormat = basePath + "%s";
    }

    public static String getBasePath() {
        return basePath;
    }

    public static <T> T loadTiledXml(Class<T> cls, String resourceName) {
        return XmlLoader.load(cls, basePathFormat.formatted(resourceName));
    }

    public static TiledTileSet loadTileSet(String resourceName) {
        if (!tileSetCache.containsKey(resourceName)) {
            tileSetCache.put(resourceName, loadTiledXml(TiledTileSet.class, resourceName));
        }
        return tileSetCache.get(resourceName);
    }

    public static <T> T load(Class<T> cls, String resourceName) {
        final JAXBContext jaxbContext = getContext(cls);
        try (InputStream inputStream = XmlLoader.class.getResourceAsStream(resourceName)) {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            T o = (T) jaxbUnmarshaller.unmarshal(inputStream);
            return o;
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> JAXBContext getContext(Class<T> cls) {
        try {
            final JAXBContext jaxbContext;
            if (jaxbContexts.containsKey(cls)) {
                jaxbContext = jaxbContexts.get(cls);
            } else {
                jaxbContext = JAXBContext.newInstance(cls);
                jaxbContexts.put(cls, jaxbContext);
            }
            return jaxbContext;
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}

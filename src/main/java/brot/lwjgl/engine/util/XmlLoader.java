package brot.lwjgl.engine.util;

import brot.lwjgl.engine.scene.Scene;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.tiled.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
        basePathFormat = XmlLoader.basePath + "%s";
    }

    public static String getBasePath() {
        return basePath;
    }

    /**
     * Creates a scene from a tmx file.
     *
     * @param resourceName Name of tmx resource file.
     */
    public static Map<String, Entity> loadScene(Scene scene, String resourceName) {
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, resourceName);
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        return map.layers.stream()
                .filter(tiledLayer -> tiledLayer instanceof TiledTileLayer || tiledLayer instanceof TiledObjectLayer || tiledLayer instanceof TiledImageLayer)
                .flatMap(tiledLayer -> tiledLayer.createSceneLayer(map, scene).entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Entity> loadSceneFullPath(Scene scene, String resourceName) {
        Path resourcePath = new File(resourceName).toPath();
        setBasePath("/" + resourcePath.subpath(0, resourcePath.getNameCount() - 1));
        String tmxFile = resourcePath.getFileName().toString();
        TiledMap map = XmlLoader.loadTiledXml(TiledMap.class, tmxFile);
        scene.setDimension(map.width * map.tilewidth, map.height * map.tileheight);
        return map.layers.stream()
                .filter(tiledLayer -> tiledLayer instanceof TiledTileLayer || tiledLayer instanceof TiledObjectLayer || tiledLayer instanceof TiledImageLayer)
                .flatMap(tiledLayer -> tiledLayer.createSceneLayer(map, scene).entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static <T> T loadTiledXml(Class<T> cls, String resourceName) {
        return XmlLoader.load(cls, Paths.get(basePathFormat.formatted(resourceName)).normalize().toString());
    }

    public static TiledTileSet loadTileSet(String resourceName) {
        if (!tileSetCache.containsKey(resourceName)) {
            TiledTileSet tileSet = loadTiledXml(TiledTileSet.class, resourceName);
            Path tsxPath = Paths.get(basePathFormat.formatted(resourceName)).normalize();
            tileSet.setBasePath("/" + tsxPath.subpath(0, tsxPath.getNameCount() - 1) + "/");
            tileSetCache.put(resourceName, tileSet);
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

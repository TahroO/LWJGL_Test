package brot.lwjgl.engine.tiled;

import brot.lwjgl.engine.graph.mesh.Mesh;
import brot.lwjgl.engine.graph.mesh.Quad;
import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.graph.texture.SpriteSheet;
import brot.lwjgl.engine.scene.Entity;
import brot.lwjgl.engine.tiled.xml.BooleanIntegerAdapter;
import brot.lwjgl.engine.util.XmlLoader;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.List;
import java.util.stream.Stream;

public class TiledImageLayer extends TiledLayer {
    @XmlElement
    private TiledImage image;

//    @XmlJavaTypeAdapter(ColorAdapter.class)
    @XmlAttribute
    private String trans;

    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanIntegerAdapter.class)
    private Boolean repeatx;

    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanIntegerAdapter.class)
    private Boolean repeaty;

    @Override
    public List<Sprite> getSprites(TiledMap map) {
        float mapWidth = map.width * map.tilewidth;
        float mapHeight = map.height * map.tileheight;
        float meshWidth = repeatx == null || !repeatx ? image.width : mapWidth;
        float meshHeight = repeaty == null || !repeaty ? image.height : mapHeight;
        Mesh quad = new Quad(meshWidth, meshHeight, SpriteSheet.getTextureCoordinates(image.width / meshWidth, image.height / meshHeight));
        SpriteSheet spriteSheet = new SpriteSheet(XmlLoader.getBasePath() + image.source, quad, 1, 1);
        return List.of(new Sprite(getSpriteId(), spriteSheet, 0));
    }

    @Override
    public List<Entity> getEntities(TiledMap map) {
        return List.of(new Entity("imagelayer-%s-1".formatted(this.id), getSpriteId()));
    }

    @Override
    public Stream<Integer> getGids() {
        return null;
    }

    protected String getSpriteId() {
        return "imagelayer-%s".formatted(this.id);
    }

}

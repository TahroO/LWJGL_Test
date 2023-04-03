package brot.lwjgl.engine.scene.layer;

import brot.lwjgl.engine.graph.model.Sprite;
import brot.lwjgl.engine.scene.Constants;
import brot.lwjgl.engine.scene.entity.Entity;
import brot.lwjgl.engine.scene.entity.GameObject;
import brot.lwjgl.game.scene.CollisionScene;
import brot.lwjgl.game.scene.collision.AabbObject;
import brot.lwjgl.game.scene.collision.Collide;
import brot.lwjgl.game.scene.collision.Contact;
import brot.lwjgl.game.scene.collision.Vector;
import org.joml.Vector2d;
import org.joml.Vector2i;

public class TileLayer extends SceneLayer {
    protected Vector2i mapSize;
    /**
     * Creates a new TileLayer object.
     *
     * @param id Layer ID.
     */
    public TileLayer(String id, Vector2i mapSize) {
        super(id);
        this.mapSize = mapSize;
    }

    @Override
    public void checkCollisions(GameObject gameObject, double dt) {
        // Where are we predicted to be next frame?
        Vector2d collisionBoxPos = gameObject.getCollisionBoxPosition();
//        Vector2d predictedPos = Vector.mulAddScalarTo(new Vector2d(collisionBoxPos), gameObject.getVelocity(), dt);
        Vector2d predictedPos = new Vector2d(gameObject.getVelocity())
                .mul(dt)
                .add(collisionBoxPos);
        // Find min/max.
//        Vector2d min = Vector.min(collisionBoxPos, predictedPos);
        Vector2d min = new Vector2d(collisionBoxPos).min(predictedPos);
//        Vector2d max = nVector.max(collisionBoxPos, predictedPos);
        Vector2d max = new Vector2d(collisionBoxPos).max(predictedPos);
        // Extend by radius.
        max.add(gameObject.getCollisionObject().size());
        // Extend a bit more - this helps when player is very close to boundary of one map cell
        // but not intersecting the next one and is up a ladder.
        min.sub(Constants.EXPAND);
        max.add(Constants.EXPAND);
        // PreCollisionCode.
        gameObject.setOnGroundLast();
        gameObject.setOnGround(false);
        doActionToTilesWithinAabb(gameObject, min, max, dt);
    }

    protected int worldCoordsToTileX(double worldX) {
        return (int) worldX / Constants.TILE_SIZE.x;
    }

    protected int worldCoordsToTileY(double worldY) {
        return (int) worldY / Constants.TILE_SIZE.y;
    }

    protected Entity getTile(int i, int j) {
        return entityMap.get(Entity.ID_FORMAT.formatted(1, j * mapSize.x + i));
    }

    protected void doActionToTilesWithinAabb(GameObject gameObject, Vector2d min, Vector2d max, double dt) {
        // Round down.
        int minI = worldCoordsToTileX(min.x);
        int minJ = worldCoordsToTileY(min.y);

        //  Round up.
        int maxI = worldCoordsToTileX(max.x + 0.5f);
        int maxJ = worldCoordsToTileY(max.y + 0.5f);

        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                Entity tile = getTile(i, j);
                // TODO Tile can be null here.
                innerCollide(gameObject, tile, dt, i, j);
            }
        }
    }

    private void fillInTileAabb(AabbObject outAabb, Entity tile) {
        Sprite.CollisionObject collisionObject = tile.sprite.getCollisionObjects().stream().findFirst().orElseThrow();
        Vector2d v1 = new Vector2d(tile.getPosition().x() + collisionObject.offset().x(), tile.getPosition().y() + collisionObject.offset().y());
        Vector2d halfExtent = new Vector2d(collisionObject.size()).div(2f);
        outAabb.initialise(Vector.addTo(v1, halfExtent), halfExtent);
    }

    private void innerCollide(GameObject gameObject, Entity tile, double dt, int i, int j) {
        if (tile != null && tile.sprite.hasCollisionData()) {
            Contact contact = new Contact();
            // Generate aabb for this tile.
            AabbObject tileAabb = new AabbObject();
            fillInTileAabb(tileAabb, tile);
            boolean collided = Collide.AabbVsAabb(gameObject, tileAabb, contact, i, j, this, true);
            if (collided && !isInternalCollision(i, j, contact.m_normal)) {
                gameObject.collisionResponse(contact.m_normal, contact.m_dist, dt);
            }
        }
    }

    /// <summary>
    /// Helper function which checks for internal edges
    /// </summary>
    private boolean isInternalCollision(int tileI, int tileJ, Vector2d normal) {
        int nextTileI = tileI + (int) normal.x;
        int nextTileJ = tileJ + (int) normal.y;
        int nextTileIndex = nextTileJ * mapSize.x + nextTileI;
        return entityMap.get(Entity.ID_FORMAT.formatted(1, nextTileIndex)).sprite.hasCollisionData();
    }

}

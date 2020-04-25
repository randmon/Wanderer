package dev.randmon.wanderer.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

    //STATIC INSTANCES OF TILES

    public static Tile[] tiles = new Tile[256]; //Will hold one instance of every tile

    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);

    public static Tile brickMidTile = new BrickMidTile(2);
    public static Tile brickLeftTile = new BrickLeftTile(3);
    public static Tile brickRightTile = new BrickRightTile(4);
    public static Tile brickSingleTile = new BrickSingleTile(5);


    //CLASS

    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    /** constructor
     * @param texture image applied to the tile
     * @param id unique identity of each tile
     */
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /** isSolid method decides if you can walk on a tile or not
     * default false (you can walk on it) */
    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }
}

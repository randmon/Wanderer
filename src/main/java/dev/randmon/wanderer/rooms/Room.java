package dev.randmon.wanderer.rooms;

import dev.randmon.wanderer.Handler;
import dev.randmon.wanderer.entities.EntityManager;
import dev.randmon.wanderer.entities.creatures.Player;
import dev.randmon.wanderer.entities.statics.Tree;
import dev.randmon.wanderer.tiles.Tile;
import dev.randmon.wanderer.utils.Utils;

import java.awt.*;

public class Room {

    private Handler handler;
    private int width, height; // number of tiles
    private int spawnX, spawnY; // where player first appears
    private int[][] tiles; // list of all tiles loaded from room file

    //ENTITIES
    private EntityManager entityManager;

    /** constructor
     * @param path location of world file to load
     * */
    public Room(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*4));
        entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*7));
        entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*10));

        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick() {
        entityManager.tick();
    }

    public void render(Graphics g) {
        //Background void
        g.setColor(Color.black);
        g.fillRect(0,0,handler.getWidth(), handler.getHeight());

        //Tiles user can currently see
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) /Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) /Tile.TILE_HEIGHT + 1);

        //Render tiles
        for(int y = yStart; y< yEnd; y++){
            for(int x = xStart; x< xEnd; x++){
                Tile tileToRender = getTile(x, y); //Current tile

                // Define connected texture
                if (tileToRender.hasConnectedTexture()){

                    int type =0;

                    //Check the tile below
                    boolean hasNoShadow = y+1 <= handler.getHeight() && getTile(x, y+1).getId() == tileToRender.getId();


                    //Check tile to the left
                    if (x-1 >= 0 && getTile(x-1, y).getId() == tileToRender.getId()) {

                       //Check tile to the right
                       if (x+1 <= handler.getWidth() && getTile(x+1, y).getId() == tileToRender.getId()) {
                           if (hasNoShadow) {
                               //Mid tile
                               type = 1;
                           } else {
                               //Shadow mid tile
                               type = 5;
                           }
                       } else {
                           if (hasNoShadow) {
                               //Right tile
                               type = 2;
                           }
                           else {
                               //Shadow right tile
                               type = 6;
                           }
                       }
                    } else {
                        //Check tile to the right
                        if (x+1 <= handler.getWidth() && getTile(x+1, y).getId() == tileToRender.getId()) {
                            if (hasNoShadow) {
                                // Left tile
                                type = 0;
                            } else {
                                //Shadow left tile
                                type = 4;
                            }
                        } else {
                            //All 3 tiles are different
                            if (hasNoShadow) {
                                type = 3;
                            } else {
                                type = 7;
                            }
                        }
                    }

                    //Render connected texture
                    tileToRender.render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
                            (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()),
                            type);

                //No connected texture
                } else {
                    tileToRender.render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
                            (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
                }
            }
        }
        //Entities
        entityManager.render(g);
    }

    //Find tile by id
    public Tile getTile(int x, int y) {

        //If player is outside of world, prevent error by saying they are on grass
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null) {
            return Tile.grassTile;
        }
        return t;

    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+"); //Split file by white space

        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);

        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y<height; y++){
            for(int x = 0; x<width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}

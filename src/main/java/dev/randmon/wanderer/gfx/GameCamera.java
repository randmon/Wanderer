package dev.randmon.wanderer.gfx;

import dev.randmon.wanderer.Handler;
import dev.randmon.wanderer.entities.Entity;
import dev.randmon.wanderer.tiles.Tile;

public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    /** Check if camera is showing blank space*/
    public void checkBlankSpace() {
        if (handler.getWidth() < handler.getRoom().getWidth() * Tile.TILE_WIDTH) {
            if (xOffset < 0) {
                xOffset = 0;
            } else if (xOffset > handler.getRoom().getWidth() * Tile.TILE_WIDTH - handler.getWidth()) {
                xOffset = handler.getRoom().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
            }
        } else {
            xOffset = handler.getRoom().getWidth() * Tile.TILE_WIDTH / 2 - handler.getWidth() / 2;
        }

        if (handler.getHeight() < handler.getRoom().getHeight() * Tile.TILE_HEIGHT) {
            if (yOffset < 0) {
                yOffset = 0;
            } else if (yOffset > handler.getRoom().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()) {
                yOffset = handler.getRoom().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
            }
        } else {
            yOffset = handler.getRoom().getHeight() * Tile.TILE_HEIGHT / 2 - handler.getHeight() / 2;
        }
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}

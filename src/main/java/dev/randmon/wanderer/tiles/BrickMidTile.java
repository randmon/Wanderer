package dev.randmon.wanderer.tiles;

import dev.randmon.wanderer.gfx.Assets;

public class BrickMidTile extends Tile {

    public BrickMidTile(int id) {
        super(Assets.brickMid, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

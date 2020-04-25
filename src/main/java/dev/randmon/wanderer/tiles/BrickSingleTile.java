package dev.randmon.wanderer.tiles;

import dev.randmon.wanderer.gfx.Assets;

public class BrickSingleTile extends Tile{

    public BrickSingleTile(int id) {
        super(Assets.brickSingle, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

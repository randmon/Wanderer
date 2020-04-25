package dev.randmon.wanderer.tiles;

import dev.randmon.wanderer.gfx.Assets;

public class BrickRightTile extends Tile{

    public BrickRightTile(int id) {
        super(Assets.brickRight, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

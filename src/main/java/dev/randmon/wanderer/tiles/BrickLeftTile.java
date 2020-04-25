package dev.randmon.wanderer.tiles;

import dev.randmon.wanderer.gfx.Assets;

public class BrickLeftTile extends Tile{

    public BrickLeftTile(int id) {
        super(Assets.brickLeft, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

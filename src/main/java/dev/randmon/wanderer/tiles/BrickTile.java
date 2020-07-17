package dev.randmon.wanderer.tiles;

import dev.randmon.wanderer.gfx.Assets;

public class BrickTile extends Tile {

    public BrickTile(int id) {
        super(Assets.brickSingle, id);
        autoTexture[0] = Assets.brickLeft;
        autoTexture[1] = Assets.brickMid;
        autoTexture[2] = Assets.brickRight;
        autoTexture[3] = Assets.brickSingle;
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public boolean autoTexture() {
        return true;
    }
}

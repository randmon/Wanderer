package dev.randmon.wanderer.tiles;

import dev.randmon.wanderer.gfx.Assets;

public class BrickTile extends Tile {

    public BrickTile(int id) {
        super(Assets.brickSingle, id);
        connectedTextures[0] = Assets.brickLeft;
        connectedTextures[1] = Assets.brickMid;
        connectedTextures[2] = Assets.brickRight;
        connectedTextures[3] = Assets.brickSingle;
        connectedTextures[4] = Assets.brickLeftShadow;
        connectedTextures[5] = Assets.brickMidShadow;
        connectedTextures[6] = Assets.brickRightShadow;
        connectedTextures[7] = Assets.brickSingleShadow;
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public boolean hasConnectedTexture() {
        return true;
    }
}

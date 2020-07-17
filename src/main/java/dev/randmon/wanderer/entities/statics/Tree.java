package dev.randmon.wanderer.entities.statics;

import dev.randmon.wanderer.Handler;
import dev.randmon.wanderer.Launcher;
import dev.randmon.wanderer.gfx.Assets;
import dev.randmon.wanderer.tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity{
    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH*2 , Tile.TILE_HEIGHT *2);

        bounds.x = 70;
        bounds.y = (int) (height / 1.3f);
        bounds.width = width/2 - 20;
        bounds.height = (int) (height - height / 1.3f - 10);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,
                (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()),
                width, height, null);

        //temporary display bounding box tree
        if (Launcher.debug) {
            g.setColor(Color.red);
            g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                    (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                    bounds.width, bounds.height);
        }
    }
}

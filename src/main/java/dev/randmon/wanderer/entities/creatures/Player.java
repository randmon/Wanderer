package dev.randmon.wanderer.entities.creatures;

import dev.randmon.wanderer.Game;
import dev.randmon.wanderer.Handler;
import dev.randmon.wanderer.gfx.Animation;
import dev.randmon.wanderer.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //Animations
    private Animation animDown, animUp, animLeft, animRight;

    /** constructor */

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 33;
        bounds.y = 64;
        bounds.width = 63;
        bounds.height = 63;

        //Animations
        animDown = new Animation(200, Assets.player_down);
        animUp = new Animation(200, Assets.player_up);
        animLeft = new Animation(200, Assets.player_left);
        animRight= new Animation(200, Assets.player_right);
    }

    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up) { yMove = -speed; }
        if(handler.getKeyManager().down) { yMove = speed; }
        if(handler.getKeyManager().left) { xMove = -speed; }
        if(handler.getKeyManager().right) { xMove = speed; }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(),
                (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()),
                width, height, null);

        //temporary display bounding box player
        /*g.setColor(Color.red);
        g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);

         */

    }

    private BufferedImage getCurrentAnimationFrame() {
        if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else if (yMove > 0) {
            return animDown.getCurrentFrame();
        } else if(xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();

        } else {
            return Assets.player;
        }
    }
}

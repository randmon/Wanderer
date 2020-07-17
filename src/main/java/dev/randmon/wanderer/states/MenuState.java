package dev.randmon.wanderer.states;

import dev.randmon.wanderer.Handler;
import dev.randmon.wanderer.gfx.Animation;
import dev.randmon.wanderer.gfx.Assets;
import dev.randmon.wanderer.gfx.ImageLoader;
import dev.randmon.wanderer.tiles.Tile;
import dev.randmon.wanderer.ui.UIImageButton;
import dev.randmon.wanderer.ui.UIManager;

import java.awt.*;

public class MenuState extends State{

    private UIManager uiManager;
    private Animation flowersAnim, dogAnim;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        //Add start button
        uiManager.addObject(new UIImageButton(handler.getWidth()/2-64,handler.getHeight()/4+200, 128, 64, Assets.btn_start, () -> {
            handler.getMouseManager().setUiManager(null);
            State.setState(handler.getGame().gameState);
        }));

        flowersAnim = new Animation(100, Assets.flowers);
        dogAnim = new Animation(100, Assets.dogSmall);

    }

    @Override
    public void tick() {
        uiManager.tick();
        flowersAnim.tick();
        dogAnim.tick();
    }

    @Override
    public void render(Graphics g) {

        for (int x = -20; x < handler.getWidth(); x+= Tile.TILE_WIDTH){
            for (int y = -20; y < handler.getWidth(); y+= Tile.TILE_WIDTH){
                g.drawImage(flowersAnim.getCurrentFrame(), x, y, null);
            }
        }

        g.setColor(new Color(0,0,0, 200));
        g.fillRoundRect(handler.getWidth()/2-(handler.getWidth()/4/2),handler.getHeight()/4,handler.getWidth()/4, handler.getHeight()/2, 50, 50);

        for (int x = -20; x < handler.getWidth(); x+= Tile.TILE_WIDTH){
            g.drawImage(Assets.grass3d, x, handler.getHeight()-Tile.TILE_HEIGHT, null);
        }

        g.drawImage(dogAnim.getCurrentFrame(), handler.getWidth()/2-Tile.TILE_WIDTH/2, (int) (handler.getHeight()-(Tile.TILE_HEIGHT*1.5)), null);

        uiManager.render(g);
    }
}

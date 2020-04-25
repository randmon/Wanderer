package dev.randmon.wanderer.states;

import dev.randmon.wanderer.Handler;
import dev.randmon.wanderer.gfx.Assets;
import dev.randmon.wanderer.ui.ClickListener;
import dev.randmon.wanderer.ui.UIImageButton;
import dev.randmon.wanderer.ui.UIManager;

import java.awt.*;

public class MenuState extends State{

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        //Add start button
        uiManager.addObject(new UIImageButton(300, 300, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));

    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}

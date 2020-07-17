package dev.randmon.wanderer;

import dev.randmon.wanderer.gfx.GameCamera;
import dev.randmon.wanderer.input.KeyManager;
import dev.randmon.wanderer.input.MouseManager;
import dev.randmon.wanderer.rooms.Room;

/** Provides important variables to everywhere! */
public class Handler {

    private Game game;
    private Room room;

    /** constructor */
    public Handler(Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public int getWidth() {
        return game.getWidth();
    }
    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

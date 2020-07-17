package dev.randmon.wanderer.states;

import dev.randmon.wanderer.Handler;
import dev.randmon.wanderer.worlds.Room;

import java.awt.*;

public class GameState extends State{

    private Room room;

    //constructor
    public GameState(Handler handler){
        super(handler);

        room = new Room(handler, "res/worlds/room1.txt");
        handler.setRoom(room);

    }

    @Override
    public void tick() {
        room.tick();
    }

    @Override
    public void render(Graphics g) {
        room.render(g);
    }
}
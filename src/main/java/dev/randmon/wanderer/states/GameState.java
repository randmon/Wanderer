package dev.randmon.wanderer.states;

import dev.randmon.wanderer.Handler;
import dev.randmon.wanderer.entities.creatures.Player;
import dev.randmon.wanderer.worlds.World;

import java.awt.*;

public class GameState extends State{

    private World world;

    //constructor
    public GameState(Handler handler){
        super(handler);

        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);

    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
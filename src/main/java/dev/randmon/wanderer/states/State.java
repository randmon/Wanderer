package dev.randmon.wanderer.states;

import dev.randmon.wanderer.Handler;

import java.awt.*;

/** State class contains the code which every state must have */

public abstract class State {

    //State manager
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }


    //CLASS

    protected Handler handler;

    /** constructor */
    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}

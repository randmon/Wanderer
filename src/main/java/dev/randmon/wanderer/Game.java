package dev.randmon.wanderer;

import dev.randmon.wanderer.display.Display;
import dev.randmon.wanderer.gfx.Assets;
import dev.randmon.wanderer.gfx.GameCamera;
import dev.randmon.wanderer.input.KeyManager;
import dev.randmon.wanderer.input.MouseManager;
import dev.randmon.wanderer.states.GameState;
import dev.randmon.wanderer.states.MenuState;
import dev.randmon.wanderer.states.State;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * Main class for the game
 * */

public class Game implements Runnable {

    private Display display;

    private int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    /** States */
    public State gameState;
    public State menuState;

    /** Input */
    private KeyManager keyManager;
    private MouseManager mouseManager;

    /** Camera */
    private GameCamera gameCamera;

    /** Handler */
    private Handler handler;


    /**constructor
     * @param title - String that shows up on top bar of window
     * @param height, width - dimensions given to the display
     * */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    /** initialize graphics */
    private void init() {
        display = new Display(title, width, height);

        display.getFrame().addKeyListener(keyManager);

        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0,0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(gameState);
    }

    //"GAME LOOP"

    /** update variables*/
    private void tick() {
        keyManager.tick();

        if(State.getState() != null) {
            State.getState().tick();
        }

    }

    /** render to screen*/
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        //create buffer strategy
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //Clear screen
        g.clearRect(0,0, width, height);

        //Start drawing
        if(State.getState() != null) {
            State.getState().render(g);
        }


        //End drawing

        //display it
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        init();

        int fps = 60; //ticks per second

        //there are 1E9 nanosecs in 1 sec
        double timePerTick = 1E9 / fps; //max time to run 1 tick
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); //current time of computer
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1E9){
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        /* If start method gets called while game already running
        prevent from reinitializing the thread */
        if (running) {return;}

        //Else start
        running = true;

        //start Game class on new thread
        thread = new Thread(this);
        thread.start(); //calls run method
    }

    public synchronized void stop() {
        /* If stop method gets called while game already stopped
        prevent from throwing a bunch of errors */
        if (!running) {return;}

        //Else stop
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

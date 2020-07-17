package dev.randmon.wanderer;

/**
 * Responsible for starting up game
*/

public class Launcher {

    public static boolean debug = false;

    public static void main(String[] args) {
        Game game = new Game("Wanderer", 1920, 1080);
        game.start();
    }

}

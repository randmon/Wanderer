package dev.randmon.wanderer;

/**
 * Responsible for starting up game
*/

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("Wanderer", 1000, 600);
        game.start();
    }

}

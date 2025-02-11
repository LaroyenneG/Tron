import tron.Clu;
import tron.Grid;
import tron.Human;

import java.awt.*;

public final class AppTron {

    private static final int GAME_SPEED_MS = 100;

    private AppTron() {}

    public static void main(String[] args) {

        var grid = new Grid();

        System.out.println("Setup players");

        var username = System.getProperty("user.name");
        var human = new Human(username, Color.WHITE);

        var clu = new Clu("v1", Color.CYAN);

        grid.addPlayer(human);
        grid.addPlayer(clu);

        System.out.println("Game initialization");
        grid.init();
        grid.display();

        System.out.println("Game started !");

        while (grid.isPlaying()) {

            var start = System.currentTimeMillis();

            grid.play();
            grid.move();
            grid.display();

            var end = System.currentTimeMillis();

            try {
                Thread.sleep(Math.max(GAME_SPEED_MS - (end - start), 0));
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
                break;
            }
        }

        System.out.println("Game over !");
        System.out.println("The winner is " + grid.winner());
    }
}
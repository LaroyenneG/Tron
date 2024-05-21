import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {

    public static final int SIZE = 50;

    private final List<Player> players;

    public Grid() {

        this.players = new ArrayList<>();

        Human human = new Human("Guillaume", Color.CYAN);
        Clu clu = new Clu(Color.ORANGE);

        this.players.add(human);
        this.players.add(clu);
    }


    public void move() {
        for (Player player : players) {
            if (player.isAlive()) {
                Bike bike = player.getBike();
                bike.move();
            }
        }
    }

    private void drawGrid() {

        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        StdDraw.setPenRadius(0.0005);

        for (int i = 0; i <= SIZE; i++) {
            StdDraw.line(i, 0, i, SIZE);
            StdDraw.line(0, i, SIZE, i);
        }
    }

    public void display() {

        drawGrid();

        for (Player player : players) {
            player.draw();
        }

        StdDraw.show();
    }


    public void init() {
        StdDraw.setTitle("Tron");
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setScale(0, SIZE);
        drawGrid();
        StdDraw.show();
    }

    public boolean isPlaying() {

        int counter = 0;

        for (Player player : players) {
            if (player.isAlive()) {
                counter++;
            }
        }

        return counter >= 2;
    }


    public Player winner() {

        Player winner = null;

        for (Player player : players) {
            if (player.isAlive()) {
                winner = player;
            }
        }

        return winner;
    }

    public void play() {

        List<Player> players = new ArrayList<>(this.players);

        Collections.shuffle(players);

        for (Player player : players) {

            players.remove(player);

            if (player.isAlive()) {
                if (player.isCrashed(players)) {
                    player.kill();
                } else {
                    player.play(players);
                }
            }
        }
    }
}

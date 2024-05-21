import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Grid {

    private static final Random RANDOM = new Random();

    public static final int SIZE = 50;

    private List<Player> players;

    public Grid() {
        this.players = new ArrayList<>();
    }

    public void init() {
        StdDraw.setTitle("Tron");
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setScale(0, SIZE);
        drawGrid();
        StdDraw.show();
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

        for (int i = 0; i < SIZE; i++) {
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

    public void addPlayer(Player player) {

        Heading[] headings = Heading.values();

        Bike bike = player.getBike();
        bike.setX(RANDOM.nextInt(Grid.SIZE));
        bike.setY(RANDOM.nextInt(Grid.SIZE));
        bike.setHeading(headings[RANDOM.nextInt(headings.length)]);

        this.players.add(player);
    }

    public void play() {

        List<Player> players = new ArrayList<>(this.players);

        Collections.shuffle(players);

        for (Player player : players) {

            players.remove(player);

            if (player.isAlive()) {
                if (isCrashed(player)) {
                    player.kill();
                } else {
                    player.play(this);
                }
            }
        }
    }

    public boolean isCrashed(Player player) {

        Bike bike = player.getBike();

        int x = bike.getX();
        int y = bike.getY();

        if (isOutOfBounds(x, y)) return true;

        List<Player> others = new ArrayList<>(this.players);
        others.remove(player);

        for (Player other : others) {

            Bike otherBike = other.getBike();

            if (bike.equals(otherBike)) {
                return true;
            }

            for (Wall wall : bike.getWalls()) {
                if (bike.equals(wall)) {
                    return true;
                }
            }

            for (Wall wall : otherBike.getWalls()) {
                if (bike.equals(wall)) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean isOutOfBounds(Element element) {
        return isOutOfBounds(element.getX(), element.getY());
    }

    public boolean isOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= Grid.SIZE || y >= Grid.SIZE;
    }

    public boolean hasConflict(Element element) {
        return hasConflict(element.getX(), element.getY());
    }

    public boolean hasConflict(int x, int y) {

        boolean result = false;

        for (Player player : players) {
            Bike bike = player.getBike();
            if (bike.touch(x, y)) {
                result = true;
                break;
            }
        }

        return result;
    }
}

package tron;

import lib.StdDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Grid {

    private static final String TITLE = "Tron";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    private static final Random RANDOM = new Random();

    public static final int SIZE = 50;

    private final List<Player> players;

    public Grid() {
        this.players = new ArrayList<>();
    }

    public void init() {
        StdDraw.setTitle(TITLE);
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setScale(0, SIZE);
        drawGrid();
        StdDraw.show();
    }

    public void move() {
        for (var player : players) {
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

        for (var player : players) {
            player.draw();
        }

        StdDraw.show();
    }

    public boolean isPlaying() {

        int counter = 0;

        for (var player : players) {
            if (player.isAlive()) {
                counter++;
            }
        }

        return counter >= 2;
    }


    public Player winner() {

        Player result = null;

        for (var player : players) {
            if (player.isAlive()) {
                result = player;
            }
        }

        return result;
    }

    public void addPlayer(Player player) {

        var headings = Heading.values();

        Bike bike = player.getBike();
        bike.setX(RANDOM.nextInt(Grid.SIZE));
        bike.setY(RANDOM.nextInt(Grid.SIZE));
        bike.setHeading(headings[RANDOM.nextInt(headings.length)]);

        this.players.add(player);
    }

    public void play() {

        var players = new ArrayList<>(this.players);
        Collections.shuffle(players);

        for (var player : players) {
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

        var bike = player.getBike();

        int x = bike.getX();
        int y = bike.getY();

        if (isOutOfBounds(x, y)) return true;

        for (var wall : bike.getWalls()) {
            if (bike.equals(wall)) {
                return true;
            }
        }

        var others = new ArrayList<>(this.players);
        others.remove(player);

        for (var other : others) {

            var otherBike = other.getBike();

            if (bike.equals(otherBike)) {
                return true;
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

        for (var player : players) {
            var bike = player.getBike();
            if (bike.touch(x, y)) {
                result = true;
                break;
            }
        }

        return result;
    }
}

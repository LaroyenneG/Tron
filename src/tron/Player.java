package tron;

import lib.StdDraw;

import java.awt.*;

public abstract class Player {

    private final String name;
    private final Color color;
    private final Bike bike;

    private boolean alive;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.alive = true;
        bike = new Bike();
    }

    public abstract void play(Grid grid);

    public Bike getBike() {
        return bike;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        this.alive = false;
    }

    public void draw() {
        if (alive) {
            StdDraw.setPenColor(color);
            bike.draw();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Player that)) return false;
        return color.equals(that.color);
    }

    @Override
    public String toString() {
        return "Player: " + name;
    }
}

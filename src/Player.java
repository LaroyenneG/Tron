import java.awt.*;

public abstract class Player {

    private final String name;

    private final Color color;

    private boolean alive;

    private final Bike bike;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.alive = true;
        bike = new Bike();
    }

    public void play(Grid grid) {
        // TODO: override me
    }

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

    public boolean equals(Player player) {
        return player.color.equals(color);
    }

    public String toString() {
        return "Player: " + name;
    }
}

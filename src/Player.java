import java.awt.*;
import java.util.List;

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

    public boolean isCrashed(List<Player> others) {

        int x = bike.getX();
        int y = bike.getY();

        if (x < 0 || y < 0 || x > Grid.SIZE || y > Grid.SIZE) return true;

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

    public void play(List<Player> others) {

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

    public String toString() {
        return "Player: " + name;
    }
}

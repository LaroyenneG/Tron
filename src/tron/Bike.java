package tron;

import lib.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class Bike extends Element {

    private final List<Wall> walls;

    private Heading heading;

    public Bike() {
        super();
        heading = Heading.UP;
        walls = new ArrayList<>();
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void addWall(Wall wall) {
        walls.add(wall);
    }

    public Heading getHeading() {
        return heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    public int nextX() {

        int result = getX();

        switch (heading) {
            case RIGHT:
                result += 1;
                break;
            case LEFT:
                result -= 1;
                break;
        }

        return result;
    }

    public int nextY() {

        int result = getY();

        switch (heading) {
            case UP:
                result += 1;
                break;
            case DOWN:
                result -= 1;
                break;
        }

        return result;
    }

    public void move() {

        int x = getX();
        int y = getY();

        Wall wall = new Wall();
        wall.setX(x);
        wall.setY(y);

        x = nextX();
        y = nextY();

        setX(x);
        setY(y);
        addWall(wall);
    }

    public boolean touch(int x, int y) {

        boolean result = false;

        for (var wall : walls) {
            if (wall.getX() == x && wall.getY() == y) {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public void draw() {

        StdDraw.filledCircle(getX(), getY(), 0.8);

        for (var wall : walls) {
            wall.draw();
        }
    }
}

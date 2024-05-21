import java.util.ArrayList;
import java.util.List;

public class Bike extends Element {

    private final List<Wall> walls;

    private Orientation orientation;

    public Bike() {
        super();
        orientation = Orientation.North;
        walls = new ArrayList<>();
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void addWall(Wall wall) {
        walls.add(wall);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void draw() {

        StdDraw.filledCircle(getX(), getY(), 1);

        for (Wall wall : walls) {
            wall.draw();
        }
    }

    public void move() {

        int x = getX();
        int y = getY();

        Wall wall = new Wall();
        wall.setX(x);
        wall.setY(y);
        addWall(wall);

        switch (orientation) {
            case North:
                y += 1;
                break;
            case South:
                y -= 1;
                break;
            case East:
                x += 1;
                break;
            case West:
                x -= 1;
                break;
        }

        setX(x);
        setY(y);
    }
}

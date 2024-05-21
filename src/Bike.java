import java.util.ArrayList;
import java.util.List;

public class Bike extends Component {

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

    public void move() {

        int x = getX();
        int y = getY();

        Wall wall = new Wall();
        wall.setX(x);
        wall.setY(y);

        switch (heading) {
            case UP:
                y += 1;
                break;
            case DOWN:
                y -= 1;
                break;
            case RIGHT:
                x += 1;
                break;
            case LEFT:
                x -= 1;
                break;
        }

        setX(x);
        setY(y);
        addWall(wall);
    }

    public void draw() {

        StdDraw.filledCircle(getX(), getY(), 1);

        for (Wall wall : walls) {
            wall.draw();
        }
    }
}

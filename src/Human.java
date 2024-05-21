import java.awt.*;
import java.util.List;

public class Human extends Player {

    public Human(String name, Color color) {
        super(name, color);

        Bike bike = getBike();
        bike.setHeading(Heading.UP);
        bike.setX(Grid.SIZE);
        bike.setY(Grid.SIZE);
    }

    public void play(List<Player> others) {

        Bike bike = getBike();

        StdDraw.nextKeyTyped();

        boolean left = StdDraw.isKeyPressed(37);
        boolean up = StdDraw.isKeyPressed(38);
        boolean right = StdDraw.isKeyPressed(39);
        boolean down = StdDraw.isKeyPressed(40);

        if (left) {
            bike.setHeading(Heading.LEFT);
        }
        if (up) {
            bike.setHeading(Heading.UP);
        }
        if (right) {
            bike.setHeading(Heading.RIGHT);
        }
        if (down) {
            bike.setHeading(Heading.DOWN);
        }
    }
}

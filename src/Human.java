import java.awt.*;
import java.util.List;

public class Human extends Player {

    public Human(String name, Color color) {
        super(name, color);

        Bike bike = getBike();
        bike.setOrientation(Orientation.West);
        bike.setX(Grid.SIZE);
        bike.setY(Grid.SIZE);
    }

    public void play(List<Player> others) {

        Bike bike = getBike();

        boolean left = StdDraw.isKeyPressed(37);
        boolean up = StdDraw.isKeyPressed(38);
        boolean right = StdDraw.isKeyPressed(39);
        boolean down = StdDraw.isKeyPressed(40);

        if (left) {
            bike.setOrientation(Orientation.West);
        }
        if (up) {
            bike.setOrientation(Orientation.North);
        }
        if (right) {
            bike.setOrientation(Orientation.East);
        }
        if (down) {
            bike.setOrientation(Orientation.South);
        }
    }
}

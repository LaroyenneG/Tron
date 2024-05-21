import java.awt.*;

public class Human extends Player {

    public Human(String name, Color color) {
        super(name, color);
    }

    public void play(Grid grid) {

        Bike bike = getBike();

        /*
        StdDraw.hasNextKeyTyped();
        StdDraw.nextKeyTyped();
        */


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

package tron;

import lib.StdDraw;

import java.awt.*;

public class Human extends Player {

    private static final int KEY_LEFT = 37;
    private static final int KEY_UP = 38;
    private static final int KEY_RIGHT = 39;
    private static final int KEY_DOWN = 40;

    public Human(String name, Color color) {
        super(name, color);
    }

    @Override
    public void play(Grid grid) {

        var bike = getBike();

        var left = StdDraw.isKeyPressed(KEY_LEFT);
        var up = StdDraw.isKeyPressed(KEY_UP);
        var right = StdDraw.isKeyPressed(KEY_RIGHT);
        var down = StdDraw.isKeyPressed(KEY_DOWN);

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

package tron;

import lib.StdDraw;

public final class Wall extends Element {

    private static final double SIZE = 1.0;

    public Wall() {
        super();
    }

    public void draw() {
        StdDraw.filledSquare(getX(), getY(), SIZE / 2.0);
    }
}

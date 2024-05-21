import java.awt.*;

public abstract class Element {

    private int x;
    private int y;

    public Element() {
        x = 0;
        y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw() {
        StdDraw.setPenColor(Color.PINK);
        StdDraw.point(x, y);
    }

    public boolean equals(Element element) {
        return x == element.x && y == element.y;
    }

    public String toString() {
        return "Element{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

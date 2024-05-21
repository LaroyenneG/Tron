import java.awt.*;

public abstract class Component {

    private int x;
    private int y;

    public Component() {
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

    public boolean equals(Component component) {
        return x == component.x && y == component.y;
    }

    public String toString() {
        return "Component{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

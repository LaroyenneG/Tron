package tron;

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

    public abstract void draw();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Element that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public String toString() {
        return "Element{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

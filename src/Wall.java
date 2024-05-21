public class Wall extends Element {

    public Wall() {
        super();
    }

    public void draw() {
        StdDraw.filledSquare(getX(), getY(), 0.5);
    }
}

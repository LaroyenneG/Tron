public class Wall extends Component {

    public Wall() {
        super();
    }

    public void draw() {
        StdDraw.filledSquare(getX(), getY(), 0.5);
    }
}

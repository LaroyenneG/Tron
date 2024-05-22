import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clu extends Player {

    private List<Heading> headings;

    public Clu(String version, Color color) {
        super("Clu:" + version, color);
        headings = new ArrayList<>(List.of(Heading.values()));
        Collections.shuffle(headings);
    }

    public void play(Grid grid) {

        Bike myBike = getBike();

        List<Heading> headings = new ArrayList<>(this.headings);

        while (!headings.isEmpty()) {

            Heading heading = headings.removeFirst();
            myBike.setHeading(heading);

            int x = myBike.nextX();
            int y = myBike.nextY();

            if (!grid.isOutOfBounds(x, y) && !grid.hasConflict(x, y)) {
                return;
            }
        }
    }
}

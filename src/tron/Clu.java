package tron;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clu extends Player {

    private static final String NAME = "Clu";

    private final List<Heading> headings;

    public Clu(String version, Color color) {
        super(NAME + ":" + version, color);
        headings = new ArrayList<>(List.of(Heading.values()));
        Collections.shuffle(headings);
    }

    public void play(Grid grid) {

        var myBike = getBike();

        var headings = new ArrayList<>(this.headings);

        while (!headings.isEmpty()) {

            var heading = headings.removeFirst();
            myBike.setHeading(heading);

            int x = myBike.nextX();
            int y = myBike.nextY();

            if (!grid.isOutOfBounds(x, y) && !grid.hasConflict(x, y)) {
                return;
            }
        }
    }
}

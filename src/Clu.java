import java.awt.*;
import java.util.List;
import java.util.Random;

public class Clu extends Player {

    private static final Random RANDOM = new Random();

    public Clu(Color color) {
        super("Clu", color);

        Bike bike = getBike();
        //bike.setHeading(Heading.East);
        bike.setX(0);
        bike.setY(0);
    }

    public void play(List<Player> others) {

        Bike bike = getBike();

        /*
        Orientation orientation = Orientation.values()[RANDOM.nextInt(Orientation.values().length)];
        if (orientation == Orientation.South) {
            orientation = Orientation.North;
        }

               if (RANDOM.nextBoolean()) {
            bike.setOrientation(Orientation.East);
        } else {
            bike.setOrientation(Orientation.North);
        }
        */

    }
}

import java.awt.*;

public class Main {

    public static void main(String[] args) {


        Grid grid = new Grid();

        System.out.println("Setup players");

        grid.addPlayer(new Clu("v1", Color.ORANGE));
        grid.addPlayer(new Human("Guillaume", Color.CYAN));

        System.out.println("Game initialization");
        grid.init();
        grid.display();

        System.out.println("Game started !");

        while (grid.isPlaying()) {

            long start = System.currentTimeMillis();

            grid.play();
            grid.move();
            grid.display();

            long end = System.currentTimeMillis();

            try {
                Thread.sleep(Math.max(100 - (end - start), 0));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println("Game over !");
        System.out.println("The winner is " + grid.winner());
    }
}
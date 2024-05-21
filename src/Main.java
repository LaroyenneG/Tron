//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid();
        grid.init();

        grid.display();

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
            }
        }

        System.out.println("The winner is " + grid.winner());
    }
}
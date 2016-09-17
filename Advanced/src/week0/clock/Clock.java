package week0.clock;

/**
 * Created by Zhang on 9/13/2015 1:26 下午.
 */
public class Clock {

    private Display hour = new Display(24);
    private Display minute = new Display(60);

    public Clock() {
    }

    public void start() {
        while (true) {
            if (minute.increase())
                hour.increase();
            System.out.printf("%02d:%02d\n", hour.getValue(), minute.getValue());
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.start();
    }

}

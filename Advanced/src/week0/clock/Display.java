package week0.clock;

/**
 * Created by Zhang on 9/13/2015 1:07 下午.
 */
public class Display {

    private int value;
    private int limit;

    public Display(int limit) {
        this.value = 0;
        this.limit = limit;
    }

    public boolean increase() {
        value++;
        if (value == limit) {
            value = 0;
            return true;
        }
        return false;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Display display = new Display(24);

        for (; ; ) {
            display.increase();
            System.out.println(display.getValue());
        }
    }

}

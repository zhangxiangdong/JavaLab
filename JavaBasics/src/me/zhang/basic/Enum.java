package me.zhang.basic;

/**
 * Created by Li on 4/12/2016 9:59 PM.
 */
public class Enum {
    public enum Color {
        RED(1), YELLOW(2), BLUE(3); //each is an instance of Color

        private int value;

        Color(int i) {
            this.value = i;
        }

        public void printValue() {
            System.out.println(this.value);
        }
    }

    public static void main(String[] args) {
        for (Color color : Color.values()) {
            color.printValue();
        }
    }

    public void doSomethingWithColor(int color) { // This method is ambiguous and other developers have no idea about what value to use
        // do something with color
    }

    public void doSomethingWithColor(Color color) { // The code calling this method will be far more readable
        // do something with color
    }
}

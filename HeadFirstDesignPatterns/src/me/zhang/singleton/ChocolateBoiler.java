package me.zhang.singleton;

/**
 * Created by Zhang on 11/4/2015 9:15 下午.
 */
public class ChocolateBoiler {

    private boolean empty;
    private boolean boiled;

    private static volatile ChocolateBoiler uniqueBoiler;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (uniqueBoiler == null)
            synchronized (ChocolateBoiler.class) {
                if (uniqueBoiler == null)
                    uniqueBoiler = new ChocolateBoiler();
            }
        return uniqueBoiler;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // 在锅炉内填满巧克力和牛奶的混合物
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // 排除煮沸的巧克力和牛奶
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // 将炉内物煮沸
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}

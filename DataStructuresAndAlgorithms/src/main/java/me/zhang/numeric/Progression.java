package me.zhang.numeric;

/**
 * Created by zhangxiangdong on 2017/4/21.
 * <p>
 * Generates a simple progression, by default: 0, 1, 2...
 */
public class Progression {

    protected long current;

    public Progression() {
        this(0);
    }

    public Progression(long start) {
        current = start;
    }

    public long nextValue() {
        advance();
        return current;
    }

    protected long advance() {
        return ++current;
    }

    public String printProgression(int n) {
        StringBuilder pBuilder = new StringBuilder();
        pBuilder.append(current);
        for (int i = 0; i < n; i++) {
            pBuilder.append(", ");
            pBuilder.append(nextValue());
        }
        return pBuilder.toString();
    }
}

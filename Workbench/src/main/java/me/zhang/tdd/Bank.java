package me.zhang.tdd;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by zhangxiangdong on 2017/3/1.
 */
public class Bank {

    private Map<Pair, Integer> rates = new Hashtable<>();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) { // e.g. from "USD" to "USD"
            return 1;
        }
        return rates.get(new Pair(from, to));
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    private class Pair {

        private String from;
        private String to;

        Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object object) {
            Pair pair = (Pair) object;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        @Override
        public int hashCode() {
            return 0;
        }

    }

}

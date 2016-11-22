package me.zhang.templatemethod;

/**
 * Created by Zhang on 11/19/2015 8:31 下午.
 */
public class Duck implements Comparable {

    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " weighs " + weight;
    }

    @Override
    public int compareTo(Object o) {
        Duck other = (Duck) o;
        int result;
        if (this.weight < other.weight) {
            result = -1;
        } else if (this.weight == other.weight) {
            result = 0;
        } else {
            result = 1;
        }
        return result;
    }
}

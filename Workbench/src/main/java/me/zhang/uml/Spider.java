package me.zhang.uml;

public class Spider extends Animal {

    public Spider() {
        legs = 8;
    }

    @Override
    public void eat() {
        System.out.println("Spider eats mosquitos.");
    }

}

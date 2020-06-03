package me.zhang.uml;

public abstract class Animal {

    protected int legs;
    protected String name;

    protected Animal() {
    }

    public void walk() {
        System.out.println("Crawl");
    }

    public abstract void eat();

}

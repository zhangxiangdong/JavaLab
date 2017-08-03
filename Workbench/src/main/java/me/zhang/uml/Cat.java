package me.zhang.uml;

public class Cat extends Animal implements Pet {

    public Cat() {
        legs = 4;
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " likes fish.");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name + " plays with clew.");
    }
}

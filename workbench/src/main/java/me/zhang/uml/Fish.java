package me.zhang.uml;

public class Fish extends Animal implements Pet {

    public Fish() {
        legs = 0;
    }

    @Override
    public void walk() {
    }

    @Override
    public void eat() {
        System.out.println(name + " eats bugs.");
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
        System.out.println(name + " spits bubbles.");
    }
}

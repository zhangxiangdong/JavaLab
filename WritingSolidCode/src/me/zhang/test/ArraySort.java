package me.zhang.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Zhang on 2016/3/21 上午 9:36 .
 */
public class ArraySort {
    public static void main(String[] args) {
        Dog d1 = new Dog(2, 50);
        Dog d2 = new Dog(1, 30);
        Dog d3 = new Dog(3, 40);

        Dog[] dogArray = {d1, d2, d3};
        printDogs(dogArray);

        Arrays.sort(dogArray, new DogSizeComparator());
        printDogs(dogArray);

        Arrays.sort(dogArray, new DogWeightComparator());
        printDogs(dogArray);

        Arrays.sort(dogArray, new AnimalSizeComparator());
        printDogs(dogArray);
    }

    public static void printDogs(Dog[] dogs) {
        for (Dog d : dogs) {
            System.out.print("size: " + d.size + " weight: " + d.weight + "\t");
        }

        System.out.println();
    }
}

class Dog extends Animal {
    int weight;

    public Dog(int s, int w) {
        super.size = s;
        weight = w;
    }
}

abstract class Animal {
    int size;
}

class AnimalSizeComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.size - o2.size;
    }
    //in this way, all sub classes of Animal can use this comparator.
}

class DogSizeComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.size - o2.size;
    }
}

class DogWeightComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.weight - o2.weight;
    }
}

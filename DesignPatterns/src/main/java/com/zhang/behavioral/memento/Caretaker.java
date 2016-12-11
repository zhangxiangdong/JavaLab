package com.zhang.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang on 12/11/2016 9:40 PM.
 */
public class Caretaker {

    // Where all mementos are saved
    private List<Memento> savedMementos = new ArrayList<>();

    // Adds memento to the ArrayList
    public void addMemento(Memento memento) {
        savedMementos.add(memento);
    }

    // Gets the memento requested from the ArrayList
    public Memento getMemento(int index) {
        return savedMementos.get(index);
    }

}

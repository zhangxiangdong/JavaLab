package com.zhang.behavioral.memento;

/**
 * Created by Zhang on 12/11/2016 9:34 PM.
 */
public class Memento {

    // Memento Design Pattern
    // Used stores an objects state at a point in time
    // so it can be returned to that state later. It
    // simply allows you to undo/redo changes on an Object

    // The article stored in memento Object
    private String article;

    public Memento(String articleSave) {
        this.article = articleSave;
    }

    // Return the value stored in article
    public String getSavedArticle() {
        return article;
    }

}

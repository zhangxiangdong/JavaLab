package me.zhang.reflection;

import java.io.Serializable;

/**
 * Created by Zhang on 12/10/2016 6:29 PM.
 */
public class Enemy extends Person implements Serializable, Cloneable {

    private int vitality;

    public Enemy(int vitality) {
        this.vitality = vitality;
        System.out.println("New Instance Here.");
    }

    public void attack() {
        System.out.println("Fire in the hole!");
    }

    public void defend() {
        System.out.println("Protect your country!");
    }

    public int getVitality() {
        return vitality;
    }

    private void setVitality(int vitality) {
        this.vitality = vitality;
    }

    private String innerGetter() {
        return "Oh, you get me! Vitality = " + vitality;
    }
}

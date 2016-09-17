package week7.foxandrabbit.animal;

import week7.foxandrabbit.cell.Cell;

import java.awt.*;

public class Rabbit extends Animal implements Cell {
    public Rabbit() {
        super(10, 2);
    }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        int alpha = (int) ((1 - getAgePercent()) * 255);
        g.setColor(new Color(255, 0, 0, alpha));
        g.fillRect(x, y, size, size);
    }

    @Override
    public double getBreedRandom() {
        return 0.12;
    }

    @Override
    public Animal getChild() {
        return new Rabbit();
    }

    @Override
    public String toString() {
        return "Rabbit:" + super.toString();
    }
}

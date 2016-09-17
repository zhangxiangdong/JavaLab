package week7.foxandrabbit.foxnrabbit;

import week7.foxandrabbit.animal.Animal;
import week7.foxandrabbit.animal.Fox;
import week7.foxandrabbit.animal.Rabbit;
import week7.foxandrabbit.cell.Cell;
import week7.foxandrabbit.field.Field;
import week7.foxandrabbit.field.Location;
import week7.foxandrabbit.field.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoxAndRabbit {
    private Field theField;
    private View theView;

    public FoxAndRabbit(int size) {
        theField = new Field(size, size);
        for (int row = 0; row < theField.getHeight(); row++) {
            for (int col = 0; col < theField.getWidth(); col++) {
                double probability = Math.random();
                if (probability < 0.05) {
                    theField.place(row, col, new Fox());
                } else if (probability < 0.15) {
                    theField.place(row, col, new Rabbit());
                }
            }
        }
        theView = new View(theField);
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Cells");
        frame.add(theView);
        JButton button = new JButton("Speed Up");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Speed Up");
                step();
                frame.repaint();
            }
        });
        frame.add(button, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    public void start(int steps) {
        for (int i = 0; i < steps; i++) {
            step();
            theView.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void step() {
        for (int row = 0; row < theField.getHeight(); row++) {
            for (int col = 0; col < theField.getWidth(); col++) {
                Cell cell = theField.get(row, col);
                if (cell != null) {
                    Animal animal = (Animal) cell;
                    animal.grow();
                    if (animal.isAlive()) {
                        //	move
                        Location loc = animal.move(theField.getFreeNeighbour(row, col));
                        if (loc != null) {
                            theField.move(row, col, loc);
                        }
                        //	eat
//						animal.eat(theField);
                        Cell[] neighbour = theField.getNeighbour(row, col);
                        ArrayList<Animal> listRabbit = new ArrayList<Animal>();
                        for (Cell an : neighbour) {
                            if (an instanceof Rabbit) {
                                listRabbit.add((Rabbit) an);
                            }
                        }
                        if (!listRabbit.isEmpty()) {
                            Animal fed = animal.feed(listRabbit);
                            if (fed != null) {
                                theField.remove((Cell) fed);
                            }
                        }
                        //	breed
                        Animal baby = animal.breed();
                        if (baby != null) {
                            theField.placeRandomAdj(row, col, (Cell) baby);
                        }
                    } else {
                        theField.remove(row, col);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        FoxAndRabbit fnr = new FoxAndRabbit(30);
        fnr.start(200);
    }

}

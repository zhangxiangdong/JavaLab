package me.zhang.designPatterns.mediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by zhangxiangdong on 2017/2/22.
 * <p>
 * Concrete colleague
 */
public class BtnBook extends JButton implements Command {
    private static final long serialVersionUID = 7219751321557333004L;

    Mediator med;

    public BtnBook(ActionListener al, Mediator med) {
        super("Book");
        addActionListener(al);
        this.med = med;
        this.med.registerBook(this);
    }

    @Override
    public void execute() {
        med.book();
    }
}

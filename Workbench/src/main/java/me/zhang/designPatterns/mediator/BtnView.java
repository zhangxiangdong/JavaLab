package me.zhang.designPatterns.mediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by zhangxiangdong on 2017/2/22.
 * <p>
 * Concrete colleague
 */
public class BtnView extends JButton implements Command {

    private static final long serialVersionUID = -3480049383116833614L;

    Mediator md;

    public BtnView(ActionListener al, Mediator md) {
        super("View");
        addActionListener(al);
        this.md = md;
        this.md.registerView(this);
    }

    @Override
    public void execute() {
        md.view();
    }
}

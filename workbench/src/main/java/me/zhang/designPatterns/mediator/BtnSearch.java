package me.zhang.designPatterns.mediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by zhangxiangdong on 2017/2/22.
 * <p>
 * Concrete colleague
 */
public class BtnSearch extends JButton implements Command {
    private static final long serialVersionUID = 7988165556950644065L;

    Mediator md;

    public BtnSearch(ActionListener al, Mediator md) {
        super("Search");
        addActionListener(al);
        this.md = md;
        this.md.registerSearch(this);
    }

    @Override
    public void execute() {
        md.search();
    }
}

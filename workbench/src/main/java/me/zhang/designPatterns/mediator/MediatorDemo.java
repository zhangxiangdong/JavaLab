package me.zhang.designPatterns.mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhangxiangdong on 2017/2/22.
 */
class MediatorDemo extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1074339312985218926L;

    Mediator med = new ParticipantMediator();

    MediatorDemo() {
        JPanel p = new JPanel();
        p.add(new BtnView(this, med));
        p.add(new BtnBook(this, med));
        p.add(new BtnSearch(this, med));

        getContentPane().add(new LblDisplay(med), BorderLayout.NORTH);
        getContentPane().add(p, BorderLayout.SOUTH);
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Command cmd = (Command) ae.getSource();
        cmd.execute();
    }

    public static void main(String[] args) {
        new MediatorDemo();
    }

}

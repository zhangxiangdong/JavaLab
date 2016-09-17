package week8;

import javax.swing.*;

/**
 * Created by Zhang on 11/14/2015 6:37 下午.
 */
public class KCB {

    public static void main(String[] args) {
        JFrame frame = new JFrame("课程表");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTable table = new JTable(new KCBData());
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
    }

}

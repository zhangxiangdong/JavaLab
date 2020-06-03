package me.zhang.designPatterns.mediator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhangxiangdong on 2017/2/22.
 */
public class LblDisplay extends JLabel {
    private static final long serialVersionUID = 4608903993434298306L;

    Mediator md;

    public LblDisplay(Mediator md) {
        setHorizontalAlignment(SwingConstants.CENTER);
        this.md = md;
        this.md.registerDisplay(this);
        setFont(new Font("Arial", Font.BOLD, 24));
    }
}

package me.zhang.proxy.virtual;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Zhang on 1/11/2016 10:01 下午.
 */
public class ImageComponent extends JComponent {

    private static final long serialVersionUID = -23721399657958694L;
    private Icon icon;

    public ImageComponent(Icon icon) {
        this.icon = icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        int x = (800 - w) / 2;
        int y = (600 - h) / 2;
        icon.paintIcon(this, g, x, y);
    }
}

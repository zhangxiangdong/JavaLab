package me.zhang.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Zhang on 1/11/2016 9:47 下午.
 */
public class ImageProxy implements Icon {

    Icon imageIcon;

    public ImageProxy(URL url) {
        imageIcon = new DefaultIcon(this, url);
    }

    public void setImageIcon(Icon icon) {
        this.imageIcon = icon;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        imageIcon.paintIcon(c, g, x, y);
    }

    @Override
    public int getIconWidth() {
        return imageIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return imageIcon.getIconHeight();
    }
}

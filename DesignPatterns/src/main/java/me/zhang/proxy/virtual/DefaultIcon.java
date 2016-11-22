package me.zhang.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Li on 1/23/2016 10:36 AM.
 */
public class DefaultIcon implements Icon {

    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;
    ImageProxy imageProxy;
    Thread retrievalThread;
    boolean retrieving = false;
    URL imageURL;

    public DefaultIcon(ImageProxy imageProxy, URL url) {
        this.imageProxy = imageProxy;
        imageURL = url;
    }

    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        g.drawString("Loading CD cover, please wait...", x + 300, y + 200);
        if (!retrieving) {
            retrieving = true;
            retrievalThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        /* 切换Icon状态：DefaultIcon → ImageIcon */
                        imageProxy.setImageIcon(new ImageIcon(imageURL, "CD Cover"));
                        c.repaint();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            retrievalThread.start();
        }
    }

    @Override
    public int getIconWidth() {
        return DEFAULT_WIDTH;
    }

    @Override
    public int getIconHeight() {
        return DEFAULT_HEIGHT;
    }
}

package me.zhang.recursion;

/**
 * Created by zhangxiangdong on 2017/5/16.
 */
public class EnglishRulerDrawer {

    public void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);
        for (int i = 1; i < nInches; i++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, i);

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    private void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }

    private void drawLine(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++) {
            System.out.print("-");
        }
        if (tickLabel >= 0) {
            System.out.print(" " + tickLabel);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        EnglishRulerDrawer drawer = new EnglishRulerDrawer();
        drawer.drawRuler(10, 3);
    }

}

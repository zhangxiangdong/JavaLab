package me.zhang.coreJava.threads;

/**
 * Created by Zhang on 12/10/2017 2:20 PM.
 */
public class InterruptionTest {

    public static void main(String[] args) {
        final Thread a = new Thread(new R());

        Thread b = new Thread(() -> {
            try {
                /* Interrupt thread a after 10s */
                Thread.sleep(10 * 1000);
                a.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
    }

    static class R implements Runnable {

        static int counter = 0;

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("R" + counter++);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}

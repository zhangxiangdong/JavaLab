package me.zhang.coreJava.threads;

/**
 * Created by Zhang on 12/10/2017 2:20 PM.
 */
public class InterruptionTest {

    private static final int ONE_SECOND_IN_MILLIS = 1000; // 1s

    public static void main(String[] args) {
        final Thread a = new Thread(new R());

        Thread b = new Thread(() -> {
            try {
                /* Interrupt thread a after 10s */
                Thread.sleep(10 * ONE_SECOND_IN_MILLIS);
                a.interrupt();
            } catch (InterruptedException ignored) {

            }
        });

        a.start();
        b.start();
    }

    static class R implements Runnable {

        static int counter = 0;

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("R" + counter++);
                try {
                    Thread.sleep(ONE_SECOND_IN_MILLIS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}

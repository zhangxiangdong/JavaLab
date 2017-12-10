package me.zhang.coreJava.threads;

/**
 * Created by Zhang on 12/10/2017 5:17 PM.
 */
public class JoinTest {

    public static void main(String[] args) {
        final Thread m = new Thread(() -> {
            System.out.println("m is working...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {

            }
            System.out.println("m is done now");
        });
        final Thread n = new Thread(() -> {
            try {
                m.join(); // Causes the current thread (n) to pause execution until thread m terminates.
                // m.join(1000); // Causes the current thread (n) to pause execution for 1s.
                Thread.sleep(1000);
                System.out.println("n is working...");
                Thread.sleep(3000);
                System.out.println("n is done now");
            } catch (InterruptedException ignored) {

            }
        });
        m.start();
        n.start();
    }

}

package me.zhang.coreJava.threads;

/**
 * Created by zhangxiangdong on 2017/12/12.
 */
public class GuardedTest {

    private boolean joy = false;

    public synchronized void guardedJoy() {
        System.out.println("Joy has been started...");
        while (!joy) {
            try {
                wait();
                // When wait is invoked, the thread releases the lock and suspends execution.
            } catch (InterruptedException ignored) {

            }
        }
        System.out.println("Joy have been achieved.");
    }

    public synchronized void notifyJoy() {
        joy = true;
        notifyAll();
    }

    public static void main(String[] args) {
        GuardedTest test = new GuardedTest();
        new Thread(test::guardedJoy).start();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {

            }
            test.notifyJoy();
            // This thread has released the lock,
            // the first thread reacquires the lock
            // and resumes by returning from the invocation of wait.
        }).start();
    }

}

package me.zhang.coreJava.threads;

/**
 * Created by zhangxiangdong on 2017/12/12.
 * <p>
 * https://stackoverflow.com/a/14555496/3094830
 */
public class DeadlockTest {

    public void method0() {
        synchronized (String.class) {
            System.out.println("Acquired lock on String.class object");

            synchronized (Integer.class) {
                System.out.println("Acquired lock on Integer.class object");
            }
        }
    }

    public void method1() {
        synchronized (Integer.class) {
            System.out.println("Acquired lock on Integer.class object");

            synchronized (String.class) {
                System.out.println("Acquired lock on String.class object");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockTest test = new DeadlockTest();
        new Thread(test::method0).start();
        new Thread(test::method1).start();
    }

}

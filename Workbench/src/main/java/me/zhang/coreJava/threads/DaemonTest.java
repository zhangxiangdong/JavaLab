package me.zhang.coreJava.threads;

/**
 * Created by zhangxiangdong on 2017/12/12.
 */
public class DaemonTest {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("Daemon Thread Started...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon Thread");
        });
        t.setDaemon(true);
        t.start();

        System.out.println("Main Thread");
    }

}

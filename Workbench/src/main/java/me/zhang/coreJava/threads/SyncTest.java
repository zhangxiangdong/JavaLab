package me.zhang.coreJava.threads;

/**
 * Created by zhangxiangdong on 2017/12/11.
 */
public class SyncTest {

    public static void main(String[] args) {
        C obj = new C();
        Thread a = new Thread(obj::doHeavyWork0);
        Thread b = new Thread(obj::doHeavyWork1);
        Thread d = new Thread(obj::doHeavyWork2);
        Thread e = new Thread(C::staticHeavyWork);

        a.start(); // Acquires the intrinsic lock for object c and releases it when the doHeavyWork method returns
        b.start(); // Suspend execution
        d.start();
        e.start();
    }

    static class C {

        private final Object lock2 = new Object();

        public synchronized void doHeavyWork0() {
            try {
                System.out.println("Heavy0 work start...");
                Thread.sleep(1000);
                System.out.println("Heavy0 work is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void doHeavyWork1() {
            try {
                System.out.println("Heavy1 work start...");
                Thread.sleep(1000);
                System.out.println("Heavy1 work is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doHeavyWork2() {
            synchronized (lock2) {
                try {
                    System.out.println("Heavy2 work start...");
                    Thread.sleep(1000);
                    System.out.println("Heavy2 work is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized static void staticHeavyWork() {
            try {
                System.out.println("Static heavy work start...");
                Thread.sleep(1000);
                System.out.println("Static heavy work is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

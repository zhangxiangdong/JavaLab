package me.zhang.coreJava.threads.producer_consumer;

/**
 * Created by zhangxiangdong on 2017/12/12.
 */
public class PCTest {

    public static void main(String[] args) {
        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }

}

package me.zhang.coreJava.threads.producer_consumer;

import static me.zhang.coreJava.threads.producer_consumer.Drop.MESSAGE_DONE;

/**
 * Created by zhangxiangdong on 2017/12/12.
 */
public class Consumer implements Runnable {

    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String message;
        while (!MESSAGE_DONE.equals(message = drop.take())) {
            System.out.println(message);
            try {
                Thread.sleep((long) (Math.random() * 3000));
            } catch (InterruptedException ignored) {

            }
        }
        System.out.println(MESSAGE_DONE);
    }
}

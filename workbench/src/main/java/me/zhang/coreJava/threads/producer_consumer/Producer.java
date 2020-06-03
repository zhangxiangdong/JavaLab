package me.zhang.coreJava.threads.producer_consumer;

import static me.zhang.coreJava.threads.producer_consumer.Drop.MESSAGE_DONE;

/**
 * Created by zhangxiangdong on 2017/12/12.
 */
public class Producer implements Runnable {

    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String[] messages = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        for (String message : messages) {
            drop.put(message);
            try {
                Thread.sleep((long) (Math.random() * 3000));
            } catch (InterruptedException ignored) {

            }
        }
        drop.put(MESSAGE_DONE);
    }
}

package me.zhang.coreJava.threads.producer_consumer;

/**
 * Created by zhangxiangdong on 2017/12/12.
 */
public class Drop {

    static final String MESSAGE_DONE = "DONE";

    private String message;
    private boolean isEmpty = true;

    public synchronized String take() {
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        isEmpty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException ignored) {

            }
        }
        isEmpty = false;
        this.message = message;
        notifyAll();
    }

}

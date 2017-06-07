package me.zhang.dataStructure.applications;

import me.zhang.dataStructure.CircularQueue;
import me.zhang.dataStructure.CircularlyLinkedQueue;

/**
 * Created by zhangxiangdong on 2017/6/7.
 * <p>
 * https://en.wikipedia.org/wiki/Josephus_problem
 */
public class Josephus {

    public <E> E josephus(CircularQueue<E> queue, int k) {
        if (queue.size() == 0) {
            return null;
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.rotate();
            }
            E e = queue.dequeue();
            System.out.println("\t" + e + " is out.");
        }
        return queue.dequeue();
    }

    public static <E> CircularQueue<E> buildCircularQueue(E[] elements) {
        CircularQueue<E> queue = new CircularlyLinkedQueue<>();
        for (E e : elements) {
            queue.enqueue(e);
        }
        return queue;
    }

    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        CircularQueue<String> queue = buildCircularQueue(new String[]{"Lucia", "Zack", "Jimmy", "Tonny", "Tom"});
        String winner = josephus.josephus(queue, 3);
        System.out.println("Winner is " + winner);
    }

}

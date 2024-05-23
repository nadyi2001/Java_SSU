package task6.t2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public void run() {
        BlockingQueue<Food> queue = new LinkedBlockingQueue<>();

        Prod producer = new Prod(queue);
        Cons consumer1 = new Cons(queue, "Ivan");
        Cons consumer2 = new Cons(queue, "Petr");

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
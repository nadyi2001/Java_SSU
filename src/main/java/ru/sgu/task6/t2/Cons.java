package task6.t2;

import java.util.concurrent.BlockingQueue;

public class Cons implements Runnable {
    private final BlockingQueue<Food> queue;
    private int totalCalories = 0;
    public String name;

    public Cons(BlockingQueue<Food> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Food food = queue.take();
                System.out.println("Consumer: " + this.name);
                System.out.println("\tConsumed: " + food.getName());
                totalCalories += food.getCalories();
                System.out.println("\tTotal calories consumed: " + totalCalories);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

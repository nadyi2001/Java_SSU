package task6.t2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Prod implements Runnable {
    private final BlockingQueue<Food> queue;

    public Prod(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Random random = new Random();
                Thread.sleep((random.nextInt(5) + 1) * 1000);
                int randomIndex = random.nextInt(6);
                switch (randomIndex) {
                    case 0:
                        queue.put(new Food("Pizza", 700));
                        break;
                    case 1:
                        queue.put(new Food("Cola Zero", 0));
                        break;
                    case 2:
                        queue.put(new Food("Cola", 777));
                        break;
                    case 3:
                        queue.put(new Food("Ice cream", 160));
                        break;
                    case 4:
                        queue.put(new Food("Cakes", 500));
                        break;
                    case 5:
                        queue.put(new Food("Rice", 200));
                        break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

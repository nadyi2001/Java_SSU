package task6;

public class t3 {
    private static int counter = 0;
    private static final int INCREMENT_TIMES = 100000;


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> incrementCounter(INCREMENT_TIMES));
        Thread thread2 = new Thread(() -> incrementCounter(INCREMENT_TIMES));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter);

    }

    private synchronized static void incrementCounter(int times) {
        for (int i = 0; i < times; i++) {
            counter++;
        }
    }
}


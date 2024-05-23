package task6.t1;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public void run() {
        int n = new get_n().getNumber();
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new t1(n));
        System.out.println("Fibonacci number at position " + n + " is: " + result);
        pool.close();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
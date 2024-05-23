package task6.t1;

import java.util.concurrent.RecursiveTask;

public class t1 extends RecursiveTask<Integer> {
    final int n;

    t1(int n) {
        this.n = n;
    }

    protected Integer compute() {
        if (n <= 1)
            return n;
        t1 f1 = new t1(n - 1);
        f1.fork();
        t1 f2 = new t1(n - 2);
        return f2.compute() + f1.join();
    }
    
}

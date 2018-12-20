package lock.intrinsic;

import java.util.concurrent.Callable;

public class Worker implements Runnable {
    static Object appLock = new Object();
    int count;

    public Worker(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (appLock){
            count++;
            System.out.println("Thread -" + Thread.currentThread().getName() + " Counter : " + count);
        }
    }
}

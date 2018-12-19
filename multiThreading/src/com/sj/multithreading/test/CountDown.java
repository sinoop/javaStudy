package com.sj.multithreading.test;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements  Runnable{
    private CountDownLatch latch;

    public WorkerThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.latch.getCount());
        this.latch.countDown();
    }
}

public class CountDown {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);

        for(int i = 0;i <10 ; i ++){
            executor.submit(new WorkerThread(latch));
        }
        latch.await();
        System.out.println("Complete main");

    }



}

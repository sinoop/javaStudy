package com.sj.multithreading.test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueue {
    static  BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> producer());
        Thread t2 = new Thread(() -> consumer());

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void producer(){
        Random rand = new Random();

        while(true){
            try {
                queue.put(rand.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void consumer() {
        Random rand = new Random();

        while(true){
            if(rand.nextInt(10) == 0){
                try {
                    System.out.println("taken " + queue.take() + " ; Size : " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

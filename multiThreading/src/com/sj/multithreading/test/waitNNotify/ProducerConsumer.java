package com.sj.multithreading.test.waitNNotify;

import java.util.LinkedList;

public class ProducerConsumer {
    LinkedList<Integer> list = new LinkedList<>();
    Object lock = new Object();
    final int LIMIT = 10;
    int item = 0;

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while(list.size() == LIMIT){
                    lock.wait();
                }
                list.add(item++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while(list.size() == 0){
                    lock.wait();
                }
                System.out.print("Cosuming ");
                int value = list.removeFirst();
                System.out.println(value + "; Size is " + list.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}

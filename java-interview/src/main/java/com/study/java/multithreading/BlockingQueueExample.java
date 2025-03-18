package com.study.java.multithreading;


public class BlockingQueueExample {
    public static void run() {
        BlockingQueue<Integer> queue = new BlockingQueue<>(3);
        System.out.println("BlockingQueueExample ");
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.enqueue(i);
                    System.out.println("BlockingQueueExample Thread Produced: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int item = queue.dequeue();
                    System.out.println("BlockingQueueExample Thread Consumed: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
//13,14-20
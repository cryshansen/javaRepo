package com.study.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
    private final int taskId;

    public WorkerThread(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ThreadPoolExample {
    public static void run() {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Pool of 3 threads

        for (int i = 1; i <= 5; i++) {
            executor.execute(new WorkerThread(i));
        }

        executor.shutdown(); // Prevents new tasks from being submitted
    }
}

package com.study.java.multithreading;
class WorkerThread extends Thread {
    private String task;

    public WorkerThread(String task) {
        this.task = task;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing " + task);
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new WorkerThread("Task 1");
        Thread thread2 = new WorkerThread("Task 2");

        thread1.start();
        thread2.start();
    }
}

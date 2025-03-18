package com.study.java.multithreading;

public class ThreadExample extends Thread {
    private String name;

    public ThreadExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " - Count: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

 // ✅ Static method for Main.java
    public static void startThreads() {
        Thread t1 = new ThreadExample("Thread 1");
        Thread t2 = new ThreadExample("Thread 2");
        t1.start();
        t2.start();
    }
}

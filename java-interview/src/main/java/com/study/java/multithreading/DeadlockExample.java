package com.study.java.multithreading;

public class DeadlockExample {
    public static void run() {
        Resource res1 = new Resource();
        Resource res2 = new Resource();

        Thread t1 = new Thread(() -> res1.methodA(res2), "Thread-1");
        Thread t2 = new Thread(() -> res2.methodA(res1), "Thread-2");

        t1.start();
        t2.start();
    }
}

class Resource {
    void methodA(Resource other) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " locked Resource A");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}

            synchronized (other) {
                System.out.println(Thread.currentThread().getName() + " locked Resource B");
            }
        }
    }
}

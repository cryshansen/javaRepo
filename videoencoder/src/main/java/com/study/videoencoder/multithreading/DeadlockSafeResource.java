package com.study.videoencoder.multithreading;


class Resource {
    void useResource(Resource other) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " locked " + this);
            synchronized (other) {
                System.out.println(Thread.currentThread().getName() + " locked " + other);
            }
        }
    }
}

public class DeadlockSafeResource {
    public static void run() {
        Resource res1 = new Resource();
        Resource res2 = new Resource();

        Thread t1 = new Thread(() -> res1.useResource(res2), "Thread-1");
        Thread t2 = new Thread(() -> res2.useResource(res1), "Thread-2");

        t1.start();
        t2.start();
    }
}

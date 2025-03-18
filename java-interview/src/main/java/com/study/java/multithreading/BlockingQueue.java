package com.study.java.multithreading;
/**
 * #8 Blocking Queue in Java (Thread-Safe)
We’ll use wait() and notifyAll() to ensure thread safety.
 * */

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait if the queue is full
        }
        queue.add(item);
        notifyAll(); // Notify waiting threads
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if the queue is empty
        }
        T item = queue.poll();
        notifyAll(); // Notify waiting threads
        return item;
    }
}

//13,14-20
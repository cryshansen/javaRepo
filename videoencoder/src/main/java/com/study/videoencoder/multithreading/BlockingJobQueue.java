package com.study.videoencoder.multithreading;


import java.util.LinkedList;
import java.util.Queue;

import com.study.videoencoder.core.Job;

public class BlockingJobQueue {
    private final Queue<Job> queue = new LinkedList<>();
    private final int capacity;

    public BlockingJobQueue(int capacity) {
        this.capacity = capacity;
    }

    
    /*
     * If we want to avoid CPU-intensive polling (checking for jobs constantly), we can use BlockingQueue<Job> instead.
     * ✅ Benefit: Threads wait until there’s a job instead of constantly checking.
     * 
     * */
    
    public synchronized void addJob(Job job) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait if queue is full
        }
        queue.add(job);
        notifyAll();
    }

    public synchronized Job getJob() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if queue is empty
        }
        Job job = queue.poll();
        notifyAll();
        return job;
    }

    public synchronized Job[] getAllJobs() {
        return queue.toArray(new Job[0]);
    }
}
package com.study.videoencoder.multithreading;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.study.videoencoder.core.Job;

public class JobProcessor implements Runnable {
	
	private static final Logger logger = Logger.getLogger(JobProcessor.class.getName());

	private final ConcurrentLinkedQueue<Job> jobQueue;

    public JobProcessor(ConcurrentLinkedQueue<Job> jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        while (!jobQueue.isEmpty()) {
            Job job = jobQueue.poll();
            if (job != null) {
                job.process();
            }
        }
    }
}

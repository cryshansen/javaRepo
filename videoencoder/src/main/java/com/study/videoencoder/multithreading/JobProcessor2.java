package com.study.videoencoder.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.study.videoencoder.core.Job;

public class JobProcessor2 implements Runnable {
	
	private static final Logger logger = Logger.getLogger(JobProcessor.class.getName());

	private final BlockingJobQueue jobQueue;

    public JobProcessor2(BlockingJobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }


    @Override
    public void run() {
    	try {
            while (true) {
                Job job = jobQueue.getJob();  // 🛑 Blocks until a job is available
                System.out.println(Thread.currentThread().getName() + " BlockingJobQuue processing job: " + job.getJobId());
                job.process();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore thread interrupt status
        }
    }
}

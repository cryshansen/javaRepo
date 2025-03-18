package com.study.videoencoder.core;
import java.util.concurrent.*;
import com.study.videoencoder.multithreading.*;

public class JobManager {
	private static final int THREAD_POOL_SIZE = 4;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    
    /*
     * We are using ConcurrentLinkedQueue<Job>, which is thread-safe because: ✔ It handles multiple threads safely for adding and removing jobs.
     * ✔ It avoids explicit locking, reducing performance bottlenecks.
     * ✅ Our Job Queue is already safe from race conditions because ConcurrentLinkedQueue is designed for concurrency.
     */
    private final ConcurrentLinkedQueue<Job> jobQueue = new ConcurrentLinkedQueue<>();

    public void submitJob(Job job) {
        jobQueue.add(job);
        executor.submit(new JobProcessor(jobQueue));
    }

    public void shutdown() {
        executor.shutdown();
    }
}

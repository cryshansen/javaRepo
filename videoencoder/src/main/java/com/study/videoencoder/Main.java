package com.study.videoencoder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;

import com.study.videoencoder.core.Job;
import com.study.videoencoder.core.JobManager;
//import com.study.videoencoder.dsa.JobScheduler;
//import com.study.videoencoder.dsa.JobSearch;
//import com.study.videoencoder.multithreading.BlockingJobQueue;
//import com.study.videoencoder.multithreading.JobProcessor;
//import com.study.videoencoder.multithreading.DeadlockSafeResource;
import com.study.videoencoder.multithreading.BlockingJobQueue;
import com.study.videoencoder.multithreading.JobProcessor2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    	
    	JobManager jobManager = new JobManager();

        // Submit jobs
        jobManager.submitJob(new Job(1, 3, "video1.mp4"));
        jobManager.submitJob(new Job(2, 1, "video2.mp4"));
        jobManager.submitJob(new Job(3, 5, "video3.mp4"));
        jobManager.submitJob(new Job(4, 2, "video4.mp4"));

        // Shut down job manager after tasks
        jobManager.shutdown();
        
        
        BlockingJobQueue blockingQueue = new BlockingJobQueue(5);

        // Add jobs
        blockingQueue.addJob(new Job(1, 3, "video1.mp4"));
        blockingQueue.addJob(new Job(2, 1, "video2.mp4"));
        blockingQueue.addJob(new Job(3, 5, "video3.mp4"));
        blockingQueue.addJob(new Job(4, 2, "video4.mp4"));

        // 🏃 Start JobProcessor2 (BlockingQueue-based)
        ExecutorService executor = Executors.newFixedThreadPool(2);  
        executor.submit(new JobProcessor2(blockingQueue));  
        executor.submit(new JobProcessor2(blockingQueue));

        executor.shutdown();

       
    }
}

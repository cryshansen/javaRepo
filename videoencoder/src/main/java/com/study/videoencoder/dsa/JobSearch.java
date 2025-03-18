
package com.study.videoencoder.dsa;


import java.util.Arrays;

import com.study.videoencoder.core.Job;
import com.study.videoencoder.multithreading.BlockingJobQueue;

import java.util.Arrays;

public class JobSearch {
    public static int binarySearch(Job[] jobs, int targetId, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (jobs[mid].getJobId() == targetId) return mid;
        else if (jobs[mid].getJobId() > targetId) return binarySearch(jobs, targetId, left, mid - 1);
        else return binarySearch(jobs, targetId, mid + 1, right);
    }

    public static void search(BlockingJobQueue queue, int jobId) {
        Job[] jobs = queue.getAllJobs();
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.getJobId(), b.getJobId())); // Sort for binary search
        int index = binarySearch(jobs, jobId, 0, jobs.length - 1);
        if (index != -1) System.out.println("Found: " + jobs[index]);
        else System.out.println("Job ID " + jobId + " not found.");
    }
}

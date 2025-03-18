
package com.study.videoencoder.dsa;

import com.study.videoencoder.core.Job;
import com.study.videoencoder.multithreading.*;
import java.util.Arrays;

public class JobScheduler {
    public static void quickSort(Job[] jobs, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(jobs, low, high);
            quickSort(jobs, low, pivotIndex - 1);
            quickSort(jobs, pivotIndex + 1, high);
        }
    }

    private static int partition(Job[] jobs, int low, int high) {
        Job pivot = jobs[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (jobs[j].getPriority() < pivot.getPriority()) {
                i++;
                swap(jobs, i, j);
            }
        }
        swap(jobs, i + 1, high);
        return i + 1;
    }

    private static void swap(Job[] jobs, int i, int j) {
        Job temp = jobs[i];
        jobs[i] = jobs[j];
        jobs[j] = temp;
    }

    public static void sortAndDisplay(BlockingJobQueue queue) {
        Job[] jobs = queue.getAllJobs();
        quickSort(jobs, 0, jobs.length - 1);
        System.out.println("Sorted Jobs by Priority:");
        Arrays.stream(jobs).forEach(System.out::println);
    }
}

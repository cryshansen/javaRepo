package com.study.videoencoder.core;

public class Job implements Comparable<Job> {
    private final int jobId;
    private final int priority;
    private final String fileName;

    public Job(int jobId, int priority, String fileName) {
        this.jobId = jobId;
        this.priority = priority;
        this.fileName = fileName;
    }

    public int getJobId() { return jobId; }
    public int getPriority() { return priority; }
    public String getFileName() { return fileName; }

    @Override
    public int compareTo(Job other) {
        return Integer.compare(this.priority, other.priority); // Sort by priority
    }

    @Override
    public String toString() {
        return "Job{ID=" + jobId + ", Priority=" + priority + ", File='" + fileName + "'}";
    }
    
    public void process() {
        System.out.println("Processing job: " + jobId);
        // Simulate processing time
        try {
            Thread.sleep(2000); // Simulate job execution delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Job " + jobId + " completed.");
    }
}
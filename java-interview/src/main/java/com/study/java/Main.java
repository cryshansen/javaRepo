package com.study.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.java.core.ImmutableClassExample;
import com.study.java.core.MVCDemo;
import com.study.java.dsa.TwoSum;
import com.study.java.dsa.DijkstraAlgorithm.Edge;
import com.study.java.core.SingletonExample;
import com.study.java.designpatterns.behavioral.ObserverPattern;
import com.study.java.designpatterns.creational.FactoryPattern;

import com.study.java.dsa.ReverseLinkedList;

import com.study.java.dsa.FirstNonRepeatingChar;
import com.study.java.dsa.DetectCycle;
import com.study.java.dsa.DijkstraAlgorithm;
import com.study.java.dsa.BFSExample;
import com.study.java.dsa.BinarySearchExample;

import com.study.java.dsa.CacheDemo;
import com.study.java.dsa.QuickSortExample;
import com.study.java.dsa.RecursionExample;
import com.study.java.multithreading.ThreadExample;
import com.study.java.multithreading.ProducerConsumer;
import com.study.java.multithreading.ThreadPoolExample;
import com.study.java.multithreading.BlockingQueueExample;
import com.study.java.multithreading.DeadlockExample;
import com.study.java.multithreading.MultiThreadDemo;


/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Java Interview Practice!");

        // Run sample problems   n0 2?  no3 sttuddeent score alphebetize
        //1
        /*
         * Immutable Class Implementation
         * Problem: Implement an immutable class Person with fields name (String) and age (int). Ensure no external modification is possible.
         * */
        ImmutableClassExample.run();
        //12 Given nums = [2, 7, 11, 15] and target = 9, return indices [0,1]. Optimize beyond brute force O(n²).
        TwoSum.run();
        /*
         * Multithreading & Concurrency Coding Problems
         * 6️⃣ Print Numbers Alternately Using Two Threads
         * Problem: Create two threads where:
         * Thread 1 prints odd numbers. 
         * Thread 2 prints even numbers.
         * Ensure they print numbers in order (1,2,3,4...) without blocking each other indefinitely.
         * */
        ThreadExample.startThreads();
        
        
        /*Implement a Singleton in Java
        	Singleton ensures only one instance of a class exists.
        */
        SingletonExample.run();
        /*	Implement Thread-safe Singleton (Best Practice)
Problem: Implement a thread-safe Singleton with lazy initialization. Use Double-Checked Locking. is this thread safe? #9?
        */
        /*
         * #3 
         * Reverse a Linked List
         * We’ll implement a singly linked list and reverse it.
         * */
        
        ReverseLinkedList.run();
        /*
         * #4: Implement a Producer-Consumer using Threads
			We'll use BlockingQueue for proper synchronization.
         * 
         * */
        ProducerConsumer.run();
        /*
         * 8️⃣ Producer-Consumer Using BlockingQueue
         * Problem: Implement a Producer-Consumer pattern using BlockingQueue where:
         * Producer adds 5 numbers. 
         * Consumer consumes them with a delay.
         * 
         * */

        
        //Blocking Queue (Thread-Safe Queue with wait/notify)
        /*
         * #8: Implement a Blocking Queue in Java (Thread-Safe)
         * We’ll use wait() and notifyAll() to ensure thread safety.
         * */
        BlockingQueueExample.run();
        //QuickSort (Divide & Conquer Sorting Algorithm)
        /*
         * #9: Implement QuickSort
			We’ll use recursion and the divide-and-conquer strategy.
         * */
        QuickSortExample.run();
        //Binary Search (Efficient Search in Sorted Arrays)
        /*
         * #10: Implement Binary Search
         * We’ll use a recursive approach.
         * */
        BinarySearchExample.run();
        //Deadlock Scenario (Two threads locking in opposite order)
        /*
         * Deadlock Detection & Avoidance
         * 
         * Problem: Implement two threads that cause a deadlock, then modify the code to avoid it using tryLock() or ordered locking.
         * #13: Implement a Deadlock Scenario
         * We’ll create two threads trying to acquire the same locks in different orders, leading to deadlock.
         * */
        DeadlockExample.run();
       
        //11 Given "swiss", return 'w' (first character that does not repeat). same as 5
        /*
         * #5: Find the First Non-Repeating Character in a String
			We’ll use a LinkedHashMap to maintain order and track character frequencies.
         * */
        FirstNonRepeatingChar.run();
        
        /*
         * #6: Detect a Cycle in a Linked List (Floyd’s Cycle Detection Algorithm)
         * We’ll use two pointers (slow & fast) to detect cycles in a linked list.
         * 
         * ist this the same?
         * : Implement cycle detection in a Linked List using Floyd’s Tortoise and Hare Algorithm.v
         * */
        DetectCycle.run();
        /*
         * 10 Write a simple Thread Pool implementation using ExecutorService with a fixed number of worker threads.
         * #7: Implement a Thread Pool in Java We’ll use ExecutorService and a fixed thread pool to run multiple tasks concurrently.
         * */
        ThreadPoolExample.run();
        /*
         * Goal: Implement a basic MVC structure (Model-View-Controller)
         * Model stores data
         * ✅ View handles UI
         * ✅ Controller manages logicv
         * 
         * */
        MVCDemo.main(args);
        
        
        /*
         * Goal: Implement a simple cache using HashMapv
         * hashmap stores cached values 
         *O(1) retrieval for fast performance
         * 
        **/
        CacheDemo.main(args);
        
        /*
         * Goal: Create multiple threads to execute tasks in parallel
         * 
         * Each thread runs independently
         * ✅ start() runs tasks asynchronously
         * */
        
        MultiThreadDemo.main(args);
        
        /*
         * Goal: Compute factorial using recursion
         * Base Case stops recursion
         * ✅ Recursive Case calls itself
         * 
         * */
        RecursionExample.main(args); 
        /*
         * 5️⃣ Graph Algorithm: BFS
         * 📌 Goal: Implement Breadth-First Search (BFS) on a graph
         *  Queue + Set for traversal
         *  ✅ Visit each node once
         * */
        BFSExample.main(args);
        
        
        /**
         * Encapsulates object creation
         *  ✅ Makes code more maintainable
         *   ✅ Easy to extend with new types
         * 
         */   
        FactoryPattern.main(args);
        //CarFactory.main(args);
        //Run individual class main feattures
        /*
         *  Decouples subject and observers
         *  ✅ Multiple objects can react to changes
         *  ✅ Useful for real-time updates (e.g., event listeners, notifications)
         *  
         * */
        ObserverPattern.main(args);
       /*
        * #19 DijkstraAlgorithm
        * */

        // Graph represented as an adjacency list
        Map<Integer, List<DijkstraAlgorithm.Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new DijkstraAlgorithm.Edge(1, 4), new DijkstraAlgorithm.Edge(2, 1)));
        graph.put(1, Arrays.asList(new DijkstraAlgorithm.Edge(3, 1)));
        graph.put(2, Arrays.asList(new DijkstraAlgorithm.Edge(1, 2), new DijkstraAlgorithm.Edge(3, 5)));
        graph.put(3, new ArrayList<>());

        int source = 0;
        Map<Integer, Integer> shortestPaths = DijkstraAlgorithm.dijkstra(graph, source);

        System.out.println("Shortest paths from node " + source + ": " + shortestPaths);
        // Expected Output: {0=0, 1=3, 2=1, 3=4}
  
    }
}

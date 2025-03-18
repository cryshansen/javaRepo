package com.study.java.dsa;

import java.util.*;

public class DijkstraAlgorithm {
    public static class Edge {
        public int target, weight;
        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Edge>> graph, int source) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distance = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        minHeap.offer(new int[]{source, 0});
        distance.put(source, 0);

        while (!minHeap.isEmpty()) {
        	//(checking for jobs constantly), we can use BlockingQueue<Job> instead and implementing wait()
            int[] current = minHeap.poll(); // less efficient than creating a function to introduce wait() // Wait if queue is empty se JobProcessor2 of the videoencoder
            int node = current[0], dist = current[1];

            if (visited.contains(node)) continue;
            visited.add(node);

            for (Edge edge : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(edge.target)) {
                    int newDist = dist + edge.weight;
                    if (newDist < distance.getOrDefault(edge.target, Integer.MAX_VALUE)) {
                        distance.put(edge.target, newDist);
                        minHeap.offer(new int[]{edge.target, newDist});
                    }
                }
            }
        }
        return distance;
    }
}
 

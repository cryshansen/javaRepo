package com.study.java.dsa;

public class BinarySearchExample {
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return -1; // Base case: Not found

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, target, left, mid - 1);
        else return binarySearch(arr, target, mid + 1, right);
    }

    public static void run() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int index = binarySearch(arr, target, 0, arr.length - 1);

        System.out.println("Target " + target + " found at index: " + index);
    }
}

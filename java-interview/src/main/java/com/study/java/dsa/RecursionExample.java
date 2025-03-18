package com.study.java.dsa;


public class RecursionExample {
	
    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5)); // Output: 120
    }
    
}

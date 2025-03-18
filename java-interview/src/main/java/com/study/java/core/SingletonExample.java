package com.study.java.core;
//ensure only  one instance of class exists
public class SingletonExample {
    private static SingletonExample instance;

    // Private constructor prevents instantiation
    private SingletonExample() {}

    // Thread-safe Lazy Initialization
    public static synchronized SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance: " + this);
    }

    // ✅ Static method for Main.java
    public static void run() {
        SingletonExample s1 = SingletonExample.getInstance();
        SingletonExample s2 = SingletonExample.getInstance();
        s1.showMessage();
        System.out.println("Same instance? " + (s1 == s2)); // Should print true
    }
}

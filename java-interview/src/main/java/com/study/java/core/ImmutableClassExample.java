
package com.study.java.core;

public final class ImmutableClassExample {
    private final String name;
    private final int age;
    
    //must initiate through constructor ensures immutable
    public ImmutableClassExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public static void run() {
        ImmutableClassExample obj = new ImmutableClassExample("John", 30);
        System.out.println("Immutable Object: " + obj.getName() + ", " + obj.getAge());
    }
}

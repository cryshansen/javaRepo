package com.study.java.designpatterns.creational;
//Step 1: Define an interface
interface Car {
 void drive();
}

//Step 2: Create concrete implementations
class Sedan implements Car {
 public void drive() { System.out.println("Driving a Sedan"); }
}

class SUV implements Car {
 public void drive() { System.out.println("Driving an SUV"); }
}

//Step 3: Create a Factory Class
class CarFactory {
	
 public static Car getCar(String type) {
     if (type.equalsIgnoreCase("Sedan")) return new Sedan();
     if (type.equalsIgnoreCase("SUV")) return new SUV();
     throw new IllegalArgumentException("Unknown car type");
 }
}

/*
 * 
 * Encapsulates object creation
 * ✅ Makes code more maintainable
 * ✅ Easy to extend with new typesEncapsulates object creation
 * ✅ Makes code more maintainable
 * ✅ Easy to extend with new types
 * */

//Step 4: Test in Main
public class FactoryPattern {
 public static void main(String[] args) {
     Car sedan = CarFactory.getCar("Sedan");
     sedan.drive(); // Output: Driving a Sedan

     Car suv = CarFactory.getCar("SUV");
     suv.drive(); // Output: Driving an SUV
 }
}
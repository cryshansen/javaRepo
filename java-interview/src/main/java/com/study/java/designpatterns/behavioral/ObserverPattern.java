package com.study.java.designpatterns.behavioral;
import java.util.ArrayList;
import java.util.List;

// Step 1: Create an Observer Interface
interface Observer {
    void update(float temperature);
}

// Step 2: Create the Subject (Observable)
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) { observers.add(observer); }
    public void removeObserver(Observer observer) { observers.remove(observer); }
    
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Step 3: Create Concrete Observers
class MobileDevice implements Observer {
    private String name;
    
    public MobileDevice(String name) { this.name = name; }
    
    public void update(float temperature) {
        System.out.println(name + " received update: Temperature is " + temperature + "°C");
    }
}

/*
 * Key Concepts
 * Decouples subject and observer
 * ✅ Multiple objects can react to changes
 * ✅ Useful for real-time updates (e.g., event listeners, notifications)
 * 
 * */


// Step 4: Test in Main
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        
        Observer phone1 = new MobileDevice("Phone 1");
        Observer phone2 = new MobileDevice("Phone 2");

        station.addObserver(phone1);
        station.addObserver(phone2);

        station.setTemperature(25.5f);
        // Output:
        // Phone 1 received update: Temperature is 25.5°C
        // Phone 2 received update: Temperature is 25.5°C
    }
}

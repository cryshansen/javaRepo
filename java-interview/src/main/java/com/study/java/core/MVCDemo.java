
package com.study.java.core;

//Model (Data Layer)
class Task {
 private String name;
 public Task(String name) { this.name = name; }
 public String getName() { return name; }
}

//View (UI Layer)
class TaskView {
 public void printTask(String taskName) {
     System.out.println("Task: " + taskName);
 }
}

//Controller (Logic Layer)
class TaskController {
 private Task model;
 private TaskView view;

 public TaskController(Task model, TaskView view) {
     this.model = model;
     this.view = view;
 }

 public void updateView() {
     view.printTask(model.getName());
 }
}

//Main
public class MVCDemo {
 public static void main(String[] args) {
     Task model = new Task("Complete Java Study");
     TaskView view = new TaskView();
     TaskController controller = new TaskController(model, view);

     controller.updateView();
 }
}

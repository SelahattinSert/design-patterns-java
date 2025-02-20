package patterns.design.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Course implements Subject{

    private String courseName;
    private List<Observer> observers = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println(observer + " has been added to " + courseName);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String messageType, String message) {
        for (Observer observer : observers) {
            observer.update(courseName, messageType, message);
        }
    }

    public void postAssignment(String assignment) {
        notifyObservers("new assignment", assignment);
    }

    public void postGradeUpdate(String gradeUpdate) {
        notifyObservers("grade update", gradeUpdate);
    }
}

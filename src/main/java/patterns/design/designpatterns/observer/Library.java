package patterns.design.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Library implements Subject {

    private String title;
    private List<Observer> observers = new ArrayList<>();

    public Library(String title) {
        this.title = title;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String messageType, String message) {
        for (Observer observer : observers) {
            observer.update(title, messageType, message);
        }
    }

    public void addNewBook(String title) {
        notifyObservers("New Book", title);
    }

    public void updateHours(String hours) {
        notifyObservers("Updated Hours", hours);
    }
}

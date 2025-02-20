package patterns.design.designpatterns.task_planner.model;

import patterns.design.designpatterns.task_planner.view.Observer;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
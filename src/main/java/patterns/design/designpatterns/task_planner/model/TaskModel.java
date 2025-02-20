package patterns.design.designpatterns.task_planner.model;



import patterns.design.designpatterns.task_planner.button_action.AddStrategy;
import patterns.design.designpatterns.task_planner.button_action.ButtonAttractionStrategy;
import patterns.design.designpatterns.task_planner.button_action.DeleteStrategy;
import patterns.design.designpatterns.task_planner.button_action.UpdateStrategy;
import patterns.design.designpatterns.task_planner.db.DatabaseManager;
import patterns.design.designpatterns.task_planner.entity.Task;
import patterns.design.designpatterns.task_planner.view.Observer;

import java.util.ArrayList;
import java.util.List;

public class TaskModel implements Subject {


    private List<Task> tasks;
    private final List<Observer> observers;
    private final DatabaseManager databaseManager = new DatabaseManager();
    ButtonAttractionStrategy deleteButtonAction = new DeleteStrategy();
    ButtonAttractionStrategy addButtonAction = new AddStrategy();
    ButtonAttractionStrategy updateButtonAction = new UpdateStrategy();

    public TaskModel() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void handleAddTask(String name, String description, String category, String deadline) {
        if (name != null && description != null && category != null && deadline != null) {
            addButtonAction.pressButton(new Task(0, name, description, category, deadline));
            tasks = databaseManager.getAllTasks();
        }
        notifyObservers();
    }

    public List<Task> handleGetTasks() {
        tasks = databaseManager.getAllTasks();
        notifyObservers();
        return tasks;
    }

    public void handleDeleteTask(int index) {
        List<Task> tasks = databaseManager.getAllTasks();
        Task selectedTask = tasks.get(index);
        //databaseManager.deleteTask(selectedTask);
        deleteButtonAction.pressButton(selectedTask);
    }

    public void handleUpdateTask(int index, String name, String description, String category, String deadline) {
        List<Task> tasks = databaseManager.getAllTasks();
        Task selectedTask = tasks.get(index);

        if (name != null && description != null && category != null && deadline != null) {
            selectedTask.setTaskName(name);
            selectedTask.setDescription(description);
            selectedTask.setCategory(category);
            selectedTask.setDeadline(deadline);
            updateButtonAction.pressButton(selectedTask);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(tasks);
        }
    }
}
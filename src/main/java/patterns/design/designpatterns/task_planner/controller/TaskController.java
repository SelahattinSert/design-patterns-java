package patterns.design.designpatterns.task_planner.controller;

import patterns.design.designpatterns.task_planner.entity.Task;
import patterns.design.designpatterns.task_planner.model.TaskModel;
import patterns.design.designpatterns.task_planner.view.TaskPlannerSwingView;

import javax.swing.*;
import java.util.List;

public class TaskController {

    private final TaskModel taskModel;
    private final TaskPlannerSwingView taskPlannerSwingView;

    public TaskController(TaskModel taskModel, TaskPlannerSwingView taskPlannerSwingView) {
        this.taskPlannerSwingView = taskPlannerSwingView;
        this.taskModel = taskModel;
    }

    public void addTask(String name, String description, String category, String deadline) {
        taskModel.handleAddTask(name, description, category, deadline);
        taskPlannerSwingView.update(getTasks());
    }

    public List<Task> getTasks() {
        return taskModel.handleGetTasks();
    }

    public void updateTask(int index, String name, String description, String category, String deadline) {
        taskModel.handleUpdateTask(index, name, description, category, deadline);
        taskPlannerSwingView.update(getTasks());
    }

    public void deleteTask(int index) {
        taskModel.handleDeleteTask(index);
        taskPlannerSwingView.update(getTasks());
    }

    public void createAndShowTaskPlannerSwingView() {
        SwingUtilities.invokeLater(taskPlannerSwingView::createAndShowGUI);
    }
}
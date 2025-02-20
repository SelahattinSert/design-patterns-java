package patterns.design.designpatterns.task_planner;

import patterns.design.designpatterns.task_planner.controller.TaskController;
import patterns.design.designpatterns.task_planner.model.TaskModel;
import patterns.design.designpatterns.task_planner.view.TaskPlannerSwingView;

import javax.swing.*;

public class TaskPlannerMain {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TaskModel model = new TaskModel();
            TaskPlannerSwingView view = new TaskPlannerSwingView();
            TaskController controller = new TaskController(model, view);

            model.addObserver(view);
            view.setController(controller);
            controller.createAndShowTaskPlannerSwingView();
        });
    }
}

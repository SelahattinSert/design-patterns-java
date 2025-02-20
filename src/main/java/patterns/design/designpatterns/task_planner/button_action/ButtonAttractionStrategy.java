package patterns.design.designpatterns.task_planner.button_action;

import patterns.design.designpatterns.task_planner.entity.Task;

public interface ButtonAttractionStrategy {
    void pressButton(Task task);
}

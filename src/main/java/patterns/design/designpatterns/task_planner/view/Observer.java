package patterns.design.designpatterns.task_planner.view;


import patterns.design.designpatterns.task_planner.entity.Task;

import java.util.List;

public interface Observer {
    void update(List<Task> tasks);
}
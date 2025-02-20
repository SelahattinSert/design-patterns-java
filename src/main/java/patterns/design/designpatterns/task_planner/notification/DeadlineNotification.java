package patterns.design.designpatterns.task_planner.notification;



import patterns.design.designpatterns.task_planner.entity.Task;

import java.util.List;

public class DeadlineNotification extends MessageDecorator {

    private final Notification decorator;
    private final List<Task> tasks;

    public DeadlineNotification(Notification decorator, List<Task> tasks) {
        this.decorator = decorator;
        this.tasks = tasks;
    }

    @Override
    public String getNotification() {

        StringBuilder sb = new StringBuilder();
        sb.append(decorator.getNotification());
        for (Task task : tasks) {
            if (java.time.LocalDate.now().plusDays(1).toString().equals(task.getDeadline())) {
                sb.append("\n").append(task.getTaskName()).append(" is due tomorrow");
            }
        }
        return sb.toString();
    }
}

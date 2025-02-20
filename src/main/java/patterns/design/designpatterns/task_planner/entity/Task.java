package patterns.design.designpatterns.task_planner.entity;

public class Task {

    private int id;
    private String taskName;
    private String description;
    private String category;
    private String deadline;

    public Task(int id, String taskName, String description, String category, String deadline) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.category = category;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
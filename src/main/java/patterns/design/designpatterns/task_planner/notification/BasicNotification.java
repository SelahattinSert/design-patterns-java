package patterns.design.designpatterns.task_planner.notification;

public class BasicNotification extends Notification {

    private final String day;
    private final String date;

    public BasicNotification(String day, String date) {
        this.day = day;
        this.date = date;
    }

    @Override
    public String getNotification() {
        return "Day: " + day+", Date: " + date;
    }
}

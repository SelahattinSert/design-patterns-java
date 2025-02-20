package patterns.design.designpatterns.task_planner.notification;

import java.time.LocalDate;

public class BirthdayNotification extends MessageDecorator {

    private final Notification notification;
    private final LocalDate birthdate;

    public BirthdayNotification(Notification notification, LocalDate birthdate) {
        this.notification=notification;
        this.birthdate = birthdate;
    }

    @Override
    public String getNotification() {
        LocalDate today=LocalDate.now();
        if(today.getDayOfMonth()==birthdate.getDayOfMonth() && today.getMonth()==birthdate.getMonth()){
            return notification.getNotification()+ " Happy Birthday";
        }
        return notification.getNotification();
    }
}
package patterns.design.designpatterns.observer;

public class Teacher implements Observer{

    private String name;
    private Library library;
    private Course course;

    public Teacher(Library library, Course course) {
        this.library = library;
        this.course = course;
        library.registerObserver(this);
        course.registerObserver(this);
    }

    public Teacher(String name){
        this.name = name;
    }

    @Override
    public void update(String sourceName, String messageType, String message) {
        System.out.println("Teacher " + name + " received from " + sourceName + " - " + messageType + ": " + message);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", library=" + library +
                ", course=" + course +
                '}';
    }
}

package patterns.design.designpatterns.observer;

public class Student implements Observer{

    private String name;
    private Library library;
    private Course course;

    public Student(Library library, Course course) {
        this.library = library;
        this.course = course;
        library.registerObserver(this);
        course.registerObserver(this);
    }

    public Student(String name){
        this.name = name;
    }

    @Override
    public void update(String sourceName, String messageType, String message) {
        System.out.println("Student " + name + " received from " + sourceName + " - " + messageType + ": " + message);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", library=" + library +
                ", course=" + course +
                '}';
    }
}

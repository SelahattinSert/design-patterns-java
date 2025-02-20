package patterns.design.designpatterns.observer;

public class Demo {

    public static void main(String[] args) {

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Teacher mrSmith = new Teacher("Mr. Smith");
        Teacher msJones = new Teacher("Ms. Jones");

        Course cs101 = new Course("CS101");
        Library mainLibrary = new Library("TaskPlannerMain Library");

        System.out.println("=== Course Registration ===");
        cs101.registerObserver(alice);
        cs101.registerObserver(bob);
        cs101.registerObserver(mrSmith);

        System.out.println("\n=== Library Registration ===");
        mainLibrary.registerObserver(alice);
        mainLibrary.registerObserver(msJones);

        System.out.println("\n=== Course Updates ===");
        cs101.postAssignment("Complete Observer Pattern Exercise");
        cs101.postGradeUpdate("Midterm Grades Posted");

        System.out.println("\n=== Library Updates ===");
        mainLibrary.addNewBook("Design Patterns Book");

        cs101.removeObserver(bob);
        mainLibrary.removeObserver(alice);

        System.out.println("\n=== Final Updates ===");
        cs101.postAssignment("Final Project Assignment");
        mainLibrary.addNewBook("Clean Code Book");
        mainLibrary.updateHours("07.00-22.00");
    }
}

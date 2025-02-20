package patterns.design.designpatterns.mvc;

public class Main {

    public static void main(String[] args) {

        RegistrationView view = new RegistrationView();
        Student model = new Student();
        new RegistrationController(view, model);
    }
}

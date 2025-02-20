package patterns.design.designpatterns.mvc;

import javax.swing.*;
import java.awt.*;

public class RegistrationView {
    private JFrame frame;
    private JTextField studentIdField, firstNameField, lastNameField, emailField, phoneField, dobField;
    private JComboBox<String> genderDropdown, courseDropdown, semesterDropdown;
    private JTextArea addressArea;
    private JButton submitButton, resetButton;

    public RegistrationView() {
        frame = new JFrame("Student Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new GridLayout(12, 2));

        frame.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        frame.add(studentIdField);

        frame.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        frame.add(firstNameField);

        frame.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        frame.add(lastNameField);

        frame.add(new JLabel("Email:"));
        emailField = new JTextField();
        frame.add(emailField);

        frame.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        frame.add(phoneField);

        frame.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
        dobField = new JTextField();
        frame.add(dobField);

        frame.add(new JLabel("Gender:"));
        genderDropdown = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        frame.add(genderDropdown);

        frame.add(new JLabel("Address:"));
        addressArea = new JTextArea();
        frame.add(addressArea);

        frame.add(new JLabel("Course:"));
        courseDropdown = new JComboBox<>(new String[]{"Computer Science", "Engineering", "Business", "Arts"});
        frame.add(courseDropdown);

        frame.add(new JLabel("Semester:"));
        semesterDropdown = new JComboBox<>(new String[]{"First", "Second", "Third"});
        frame.add(semesterDropdown);

        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");
        frame.add(submitButton);
        frame.add(resetButton);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public String getStudentId() {
        return studentIdField.getText();
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPhone() {
        return phoneField.getText();
    }

    public String getDateOfBirth() {
        return dobField.getText();
    }

    public String getGender() {
        return (String) genderDropdown.getSelectedItem();
    }

    public String getAddress() {
        return addressArea.getText();
    }

    public String getCourse() {
        return (String) courseDropdown.getSelectedItem();
    }

    public String getSemester() {
        return (String) semesterDropdown.getSelectedItem();
    }

    public void resetForm() {
        studentIdField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        dobField.setText("");
        genderDropdown.setSelectedIndex(0);
        addressArea.setText("");
        courseDropdown.setSelectedIndex(0);
        semesterDropdown.setSelectedIndex(0);
    }
}

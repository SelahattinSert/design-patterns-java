package patterns.design.designpatterns.mvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationController {

    private RegistrationView view;
    private Student model;

    public RegistrationController(RegistrationView view, Student model) {
        this.view = view;
        this.model = model;

        this.view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        this.view.getResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.resetForm();
            }
        });
    }

    private void handleSubmit() {
        model.setStudentId(view.getStudentId());
        model.setFirstName(view.getFirstName());
        model.setLastName(view.getLastName());
        model.setEmail(view.getEmail());
        model.setPhone(view.getPhone());
        model.setDateOfBirth(view.getDateOfBirth());
        model.setGender(view.getGender());
        model.setAddress(view.getAddress());
        model.setCourse(view.getCourse());
        model.setSemester(view.getSemester());

        String sql = "INSERT INTO students (student_id, first_name, last_name, email, phone, date_of_birth, gender, address, course, semester) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, model.getStudentId());
            pstmt.setString(2, model.getFirstName());
            pstmt.setString(3, model.getLastName());
            pstmt.setString(4, model.getEmail());
            pstmt.setString(5, model.getPhone());
            pstmt.setString(6, model.getDateOfBirth());
            pstmt.setString(7, model.getGender());
            pstmt.setString(8, model.getAddress());
            pstmt.setString(9, model.getCourse());
            pstmt.setString(10, model.getSemester());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(view.getFrame(), "Student registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view.getFrame(), "Error registering student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


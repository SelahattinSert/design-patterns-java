package patterns.design.designpatterns.task_planner.button_action;

import patterns.design.designpatterns.task_planner.db.DatabaseManager;
import patterns.design.designpatterns.task_planner.entity.Task;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStrategy implements ButtonAttractionStrategy {

    DatabaseManager database = new DatabaseManager();

    @Override
    public void pressButton(Task task){
        String query = "INSERT INTO tasks (name, description, category, deadline) VALUES (?, ?, ?, ?)";
        try (Connection conn = database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, task.getTaskName());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getCategory());
            pstmt.setString(4, task.getDeadline());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package patterns.design.designpatterns.task_planner.button_action;

import patterns.design.designpatterns.task_planner.db.DatabaseManager;
import patterns.design.designpatterns.task_planner.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStrategy implements ButtonAttractionStrategy {

    DatabaseManager database=new DatabaseManager();

    @Override
    public void pressButton(Task task){
        String query = "UPDATE tasks SET name = ?, description = ?, category = ?, deadline = ? WHERE id = ?";
        try (Connection conn = database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, task.getTaskName());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getCategory());
            pstmt.setString(4, task.getDeadline());
            pstmt.setInt(5, task.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

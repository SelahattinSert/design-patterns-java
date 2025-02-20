package patterns.design.designpatterns.task_planner.button_action;

import patterns.design.designpatterns.task_planner.db.DatabaseManager;
import patterns.design.designpatterns.task_planner.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStrategy implements ButtonAttractionStrategy {

    DatabaseManager database=new DatabaseManager();

    @Override
    public void pressButton(Task task){
        int taskId=task.getId();
        String query = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = database.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

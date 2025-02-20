package patterns.design.designpatterns.task_planner.view;



import patterns.design.designpatterns.task_planner.controller.TaskController;
import patterns.design.designpatterns.task_planner.entity.Task;
import patterns.design.designpatterns.task_planner.notification.BasicNotification;
import patterns.design.designpatterns.task_planner.notification.BirthdayNotification;
import patterns.design.designpatterns.task_planner.notification.DeadlineNotification;
import patterns.design.designpatterns.task_planner.notification.Notification;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskPlannerSwingView implements Observer {

    LocalDate birthday  = LocalDate.of(2025, 1, 12);
    Notification notification;
    TaskController taskController;
    private JTable taskTable;
    private JTextArea notificationsTextArea;
    private JTextField birthdayMessageTextField;
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    String currentDate3 = currentDate.format(formatter);
    LocalDate currentDate1 = LocalDate.now();
    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE");
    String currentDay = currentDate1.format(formatter1);

    public void setController(TaskController taskController) {
        this.taskController =  taskController;
    }

    public void createAndShowGUI() {

        birthdayMessageTextField = new JTextField();
        notificationsTextArea = new JTextArea();

        JFrame frame = new JFrame("Task Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);

        taskTable = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Task Name");
        tableModel.addColumn("Description");
        tableModel.addColumn("Category");
        tableModel.addColumn("Deadline");

        List<Task> tasks = taskController.getTasks();
        for (Task task : tasks) {
            tableModel.addRow(new Object[]{task.getTaskName(), task.getDescription(), task.getCategory(), task.getDeadline()});
        }

        taskTable.setModel(tableModel);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane tableScrollPane = new JScrollPane(taskTable);
        tableScrollPane.setBounds(230, 264, 302, 200);
        frame.add(tableScrollPane);

        JTextField dayTextField = new JTextField();
        dayTextField.setBounds(38, 68, 193, 32);
        dayTextField.setEnabled(false);
        frame.add(dayTextField);
        LocalDate currentDate1 = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("EEEE");
        String currentDay = currentDate1.format(formatter1);
        dayTextField.setText(currentDay);

        JTextField dateTextField = new JTextField();
        dateTextField.setBounds(282, 68, 200, 32);
        dateTextField.setEnabled(false);
        frame.add(dateTextField);

        dateTextField.setText(currentDate3);

        birthdayMessageTextField.setBounds(39, 168, 446, 32);
        birthdayMessageTextField.setEnabled(false);
        frame.add(birthdayMessageTextField);
        notification = new BasicNotification(currentDay, currentDate3);
        notification = new BirthdayNotification(notification,birthday);
        birthdayMessageTextField.setText(notification.getNotification());

        notificationsTextArea.setBounds(20, 264, 203, 200);
        notificationsTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        notificationsTextArea.setEditable(false);
        frame.add(notificationsTextArea);
        notification = new DeadlineNotification(notification, tasks);
        notificationsTextArea.setText(notification.getNotification());

        ImageIcon addIcon = new ImageIcon("src\\main\\java\\patterns\\design\\designpatterns\\final_project\\icons\\Add.png");
        JButton addButton = new JButton(addIcon);
        addButton.setBounds(209, 481, 80, 45);
        frame.add(addButton);

        addButton.addActionListener(e -> openTaskDialog(frame, "Add Task", null, tableModel, -1));

        ImageIcon deleteIcon = new ImageIcon("src\\main\\java\\patterns\\design\\designpatterns\\final_project\\icons\\Delete.png");
        JButton deleteButton = new JButton(deleteIcon);
        deleteButton.setBounds(308, 481, 80, 45);
        frame.add(deleteButton);

        deleteButton.addActionListener(e -> {
            int selectedRow = taskTable.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                taskController.deleteTask(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to delete", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        ImageIcon updateIcon = new ImageIcon("src\\main\\java\\patterns\\design\\designpatterns\\final_project\\icons\\Update.jpg");
        JButton updateButton = new JButton(updateIcon);
        updateButton.setBounds(407, 481, 80, 45);
        frame.add(updateButton);

        updateButton.addActionListener(e -> {
            int selectedRow = taskTable.getSelectedRow();
            if (selectedRow != -1) {
                String[] taskDetails = new String[4];
                for (int i = 0; i < 4; i++) {
                    taskDetails[i] = (String) tableModel.getValueAt(selectedRow, i);
                }
                openTaskDialog(frame, "Update Task", taskDetails, tableModel, selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to update", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        JLabel dayLabel = new JLabel("Day");
        dayLabel.setBounds(134, 40, 100, 20);
        frame.add(dayLabel);

        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(370, 40, 100, 20);
        frame.add(dateLabel);

        JLabel birthdayMessageLabel = new JLabel("Birthday Celebration Message");
        birthdayMessageLabel.setBounds(175, 147, 200, 20);
        frame.add(birthdayMessageLabel);

        JLabel notificationsLabel = new JLabel("Notifications");
        notificationsLabel.setBounds(75, 245, 100, 20);
        frame.add(notificationsLabel);

        JLabel taskListLabel = new JLabel("Task List");
        taskListLabel.setBounds(328, 245, 100, 20);
        frame.add(taskListLabel);

        frame.setVisible(true);
    }

    private void openTaskDialog(JFrame parentFrame, String title, String[] taskDetails, DefaultTableModel tableModel, int rowIndex) {

        JDialog dialog = new JDialog(parentFrame, title, true);
        dialog.setSize(400, 300);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(parentFrame);

        JLabel taskNameLabel = new JLabel("Task Name:");
        taskNameLabel.setBounds(17, 30, 100, 25);
        dialog.add(taskNameLabel);

        JTextField taskNameField = new JTextField();
        taskNameField.setBounds(150, 30, 200, 25);
        dialog.add(taskNameField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(17, 70, 100, 25);
        dialog.add(descriptionLabel);

        JTextField descriptionField = new JTextField();
        descriptionField.setBounds(150, 70, 200, 25);
        dialog.add(descriptionField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(17, 110, 100, 25);
        dialog.add(categoryLabel);

        JTextField categoryField = new JTextField();
        categoryField.setBounds(150, 110, 200, 25);
        dialog.add(categoryField);

        JLabel deadlineLabel = new JLabel("Deadline (YYYY-MM-DD):");
        deadlineLabel.setBounds(17, 150, 200, 25);
        dialog.add(deadlineLabel);

        JTextField deadlineField = new JTextField();
        deadlineField.setBounds(170, 150, 180, 25);
        dialog.add(deadlineField);

        if (taskDetails != null) {
            taskNameField.setText(taskDetails[0]);
            descriptionField.setText(taskDetails[1]);
            categoryField.setText(taskDetails[2]);
            deadlineField.setText(taskDetails[3]);
        }

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(150, 200, 80, 25);
        dialog.add(saveButton);

        saveButton.addActionListener(e -> {
            String taskName = taskNameField.getText();
            String description = descriptionField.getText();
            String category = categoryField.getText();
            String deadline = deadlineField.getText();

            if (taskName.isEmpty() || description.isEmpty() || category.isEmpty() || deadline.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "All fields must be filled out", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (title.equals("Add Task")) {
                tableModel.addRow(new Object[]{taskName, description, category, deadline});
                taskController.addTask(taskName, description, category, deadline);
            } else if (title.equals("Update Task") && rowIndex != -1) {
                tableModel.setValueAt(taskName, rowIndex, 0);
                tableModel.setValueAt(description, rowIndex, 1);
                tableModel.setValueAt(category, rowIndex, 2);
                tableModel.setValueAt(deadline, rowIndex, 3);
                taskController.updateTask(rowIndex, taskName, description, category, deadline);
            }
            dialog.dispose();
        });

        dialog.setVisible(true);
    }

    @Override
    public void update(List<Task> tasks) {

        DefaultTableModel tableModel = (DefaultTableModel) taskTable.getModel();
        tableModel.setRowCount(0);
        for (Task task : tasks) {
            tableModel.addRow(new Object[]{task.getTaskName(), task.getDescription(), task.getCategory(), task.getDeadline()});
        }

        updateNotifications(tasks);
        updateBirthdayMessage();
    }

    private void updateBirthdayMessage() {
        notification = new BasicNotification(currentDay, currentDate3);
        notification = new BirthdayNotification(notification,birthday);
        birthdayMessageTextField.setText(notification.getNotification());
    }


    private void updateNotifications(List<Task> tasks) {
        notification = new BasicNotification(currentDay, currentDate3);
        notification = new DeadlineNotification(notification, tasks);
        notificationsTextArea.setText(notification.getNotification());
    }
}
package Views;

import javax.swing.*;
import java.awt.*;

public class SearchPatientView extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private JButton viewPatientButton;
    private JButton assignPatientButton;
    private JButton backButton;
    private JButton logoutButton;

    public SearchPatientView() {
        super("Search Patient"); // Set title
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Set initial size larger to accommodate components
        setLocationRelativeTo(null); // Center on screen
        setVisible(true); // It's often better to set visibility outside the constructor
    }

    private void initComponents() {
        panel1 = new JPanel(new GridLayout(0, 1, 10, 10)); // GridLayout with spacing

        // Initialize buttons
        viewPatientButton = new JButton("View Patient");
        assignPatientButton = new JButton("Assign Patient");
        backButton = new JButton("Back");
        logoutButton = new JButton("Logout");

        // Table setup
        String[] columns = {"Column 1", "Column 2"};
        Object[][] data = {{"Data 1", "Data 2"}, {"Data 3", "Data 4"}};
        table1 = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setPreferredSize(new Dimension(380, 150)); // Set preferred size for scroll pane

        // Adding components to the panel
        panel1.add(scrollPane); // Add the scroll pane containing the table
        panel1.add(viewPatientButton);
        panel1.add(assignPatientButton);
        panel1.add(backButton);
        panel1.add(logoutButton);

        // Add panel to frame
        add(panel1, BorderLayout.CENTER); // Add panel to the center of the frame layout
    }

    // Getters for controller to access the buttons
    public JButton getViewPatientButton() {
        return viewPatientButton;
    }

    public JButton getAssignPatientButton() {
        return assignPatientButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public JFrame getFrame() {
        return this;
    }
}
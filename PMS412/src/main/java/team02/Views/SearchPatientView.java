package team02.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import team02.Models.Patient;

public class SearchPatientView extends JFrame {
    private JTable table;
    private JPanel panel;
    private JButton viewPatientButton;
    private JButton assignPatientButton;
    private JButton backButton;
    private JButton logoutButton;
    private JTextField searchField;
    private JButton searchButton;
    private ArrayList<Patient> patients;

    public SearchPatientView(ArrayList<Patient> patients) {
        super("Search Patient");
        this.patients = patients;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Initialize buttons and search field
        viewPatientButton = new JButton("View Patient");
        assignPatientButton = new JButton("Assign Patient");
        backButton = new JButton("Back");
        logoutButton = new JButton("Logout");
        searchField = new JTextField(20);
        searchButton = new JButton("Search");

        // Panel for search bar and buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);

        // Table setup
        String[] columns = {"Name", "Email", "Date of Birth"};
        Object[][] data = new Object[patients.size()][3];
        for (int i = 0; i < patients.size(); i++) {
            data[i][0] = patients.get(i).getName();
            data[i][1] = patients.get(i).getEmail();
            data[i][2] = patients.get(i).getBirthDate();
        }
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(580, 200)); // Adjusted for new frame size

        // Bottom panel for buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(viewPatientButton);
        bottomPanel.add(assignPatientButton);
        bottomPanel.add(backButton);
        bottomPanel.add(logoutButton);

        // Adding components to the main panel
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        add(panel);
    }

    // Getters for controllers to access components
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

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
    public JTable getTable(){
        return table;
    }
    public ArrayList<Patient> getPatients(){
        return patients;
    }   
}

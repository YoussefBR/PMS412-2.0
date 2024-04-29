package team02.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import team02.Models.Patient;
import team02.Models.Doctor;
import team02.Models.dbIntegration;

public class SearchPatientView extends JFrame {
    private JTable table;
    private JPanel panel;
    private JButton viewPatientButton;
    private JButton assignPatientButton;
    private JButton backButton;
    private JTextField searchField;
    private JButton searchButton;
    private JDialog assignDoctor;
    private JButton selectDoctorButton;
    private JList<String> doctorList;

    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private String role;

    public SearchPatientView(ArrayList<Patient> patients, String role) {
        super("Search Patient");
        this.patients = patients;
        this.role = role;
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
        searchField = new JTextField(20);
        searchButton = new JButton("Search");

        // Initialize doctor assignment dialog
        initDoctorAssignmentDialog();

        // Panel for search bar and buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);

        // Table setup
        String[] columns = { "Name", "Email", "Date of Birth" };
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
        if (role.equals("admin"))
            bottomPanel.add(assignPatientButton);
        bottomPanel.add(backButton);

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

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTable getTable() {
        return table;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public String getRole() {
        return role;
    }

    public JButton getSelectDoctorButton() {
        return selectDoctorButton;
    }

    public JList<String> getDoctorList() {
        return doctorList;
    }

    private void initDoctorAssignmentDialog() {
        assignDoctor = new JDialog(this, "Assign Doctor", true);
        assignDoctor.setLayout(new BorderLayout());
        assignDoctor.setSize(300, 200);
        assignDoctor.setLocationRelativeTo(this);

        DefaultListModel<String> model = new DefaultListModel<>();
        doctors = dbIntegration.getInstance().getDoctors();
        doctors.forEach(doctor -> model
                .addElement(doctor.getName() + " - " + doctor.getDepartment() + ", " + doctor.getSpecialty()));

        doctorList = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(doctorList);
        assignDoctor.add(scrollPane, BorderLayout.CENTER);

        selectDoctorButton = new JButton("Assign");
        assignDoctor.add(selectDoctorButton, BorderLayout.SOUTH);

        assignDoctor.setVisible(false);
    }

    public void showDoctorAssignmentDialog() {
        assignDoctor.setVisible(true);
    }

    public void disposeDoctorAssignment() {
        assignDoctor.dispose();
    }
}

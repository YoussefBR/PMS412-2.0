package team02.Views;

import javax.swing.*;

import team02.Models.dbIntegration;

import java.awt.*;
import java.awt.event.ActionListener;

public class CaregiverHomeScreen extends JFrame {

    private JButton createPatientButton;
    private JButton searchPatientButton;
    private JButton myPatientsButton;
    private JButton logoutButton;
    private String role;
    private int id;

    public CaregiverHomeScreen(int id) {

        super("Home Screen");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        dbIntegration db = dbIntegration.getInstance();
        this.id = id;
        role = db.getRole(id);

        createPatientButton = new JButton("Create Patient");
        searchPatientButton = new JButton("Search Patient");
        myPatientsButton = new JButton("My Patients");
        logoutButton = new JButton("Logout");

        JPanel panel = new JPanel(new GridBagLayout()); // Set the layout to GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // This line instructs the layout manager that components are the
                                                      // last in their row (centered).
        gbc.anchor = GridBagConstraints.CENTER; // This anchors all components to the center.

        panel.add(createPatientButton, gbc);
        panel.add(searchPatientButton, gbc);
        if (role.equals("doctor")) {
            panel.add(myPatientsButton, gbc);
        }
        panel.add(logoutButton, gbc);

        add(panel);

        setVisible(true);
    }

    public void addCreatePatientButtonListener(ActionListener listener) {
        createPatientButton.addActionListener(listener);
    }

    public void addSearchPatientButtonListener(ActionListener listener) {
        searchPatientButton.addActionListener(listener);
    }

    public void addLogoutButtonListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }

    public void addMyPatientsButtonListener(ActionListener listener) {
        myPatientsButton.addActionListener(listener);
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}

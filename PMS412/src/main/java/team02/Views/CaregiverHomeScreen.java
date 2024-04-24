package team02.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CaregiverHomeScreen extends JFrame {

    private JButton createPatientButton;
    private JButton searchPatientButton;
    private JButton logoutButton;

    public CaregiverHomeScreen() {
        super("Home Screen");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createPatientButton = new JButton("Create Patient");
        searchPatientButton = new JButton("Search Patient");
        logoutButton = new JButton("Logout");

        JPanel panel = new JPanel(new GridBagLayout()); // Set the layout to GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // This line instructs the layout manager that components are the last in their row (centered).
        gbc.anchor = GridBagConstraints.CENTER; // This anchors all components to the center.

        panel.add(createPatientButton, gbc);
        panel.add(searchPatientButton, gbc);
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
}


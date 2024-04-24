package team02.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PatientHomeScreen extends JFrame {

    private JButton myAccountButton;
    private JButton logoutButton;
    private int patientID;

    public PatientHomeScreen(int patientID) {
        super("Home Screen");
        this.patientID = patientID;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        myAccountButton = new JButton("My Account");
        logoutButton = new JButton("Logout");

        JPanel panel = new JPanel(new GridBagLayout()); // Using GridBagLayout for flexible positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Components are the last in their row (centered)
        gbc.anchor = GridBagConstraints.CENTER; // Anchor components to the center

        panel.add(myAccountButton, gbc); // Add the "My Account" button with constraints
        panel.add(logoutButton, gbc);

        add(panel); // Add panel to the frame

        setVisible(true); // Make the frame visible
    }

    public void addMyAccountButtonListener(ActionListener listener) {
        myAccountButton.addActionListener(listener);
    }

    public void addLogoutButtonListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }
    
    public int getPatientID() {
        return patientID;
    }
}

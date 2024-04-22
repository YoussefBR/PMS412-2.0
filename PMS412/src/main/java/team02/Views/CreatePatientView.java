package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreatePatientView extends JFrame {
    private JPanel panel1;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phonenumberField;
    private JTextField birthDateField;
    private JTextField sexField;
    private JTextField weightField;
    private JTextField heightField;
    private JButton backToHomescreenButton;

    private JButton saveButton;
    private JLabel firstAndLastNameLabel;
    private JLabel emailLabel;
    private JLabel phoneNumberLabel;
    private JLabel birthDateLabel;
    private JLabel sexLabel;
    private JLabel weightIbLabel;
    private JLabel heightInLabel;


    public CreatePatientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600); // Set initial size
        setTitle("Caregiver Information"); // Set title for the frame
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel(new GridLayout(0, 2, 10, 10)); // Set layout for the panel

        // Initialize text fields and buttons
        nameField = new JTextField();
        emailField = new JTextField();
        phonenumberField = new JTextField();
        birthDateField = new JTextField();
        sexField = new JTextField();
        weightField = new JTextField();
        heightField = new JTextField();
        backToHomescreenButton = new JButton("Back to Home Screen");
        saveButton = new JButton("Save");

        // Add components to the panel
        panel1.add(new JLabel("Name:"));
        panel1.add(nameField);
        panel1.add(new JLabel("Email:"));
        panel1.add(emailField);
        panel1.add(new JLabel("Phone Number:"));
        panel1.add(phonenumberField);
        panel1.add(new JLabel("Birth Date:"));
        panel1.add(birthDateField);
        panel1.add(new JLabel("Sex:"));
        panel1.add(sexField);
        panel1.add(new JLabel("Weight:"));
        panel1.add(weightField);
        panel1.add(new JLabel("Height:"));
        panel1.add(heightField);
        panel1.add(backToHomescreenButton);
        panel1.add(saveButton);

        // Add the panel to the frame
        add(panel1);
        pack(); // Pack the contents of the window and display it to its required size
        setLocationRelativeTo(null); // Center the window
        setVisible(true); // Make the frame visible
    }

    public void addBackButtonListener(ActionListener listener) {
        backToHomescreenButton.addActionListener(listener);
    }
}
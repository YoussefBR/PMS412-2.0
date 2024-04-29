package team02.Views;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.text.NumberFormat;
import java.text.ParseException;

import java.awt.*;
import java.awt.event.ActionListener;

public class CreatePatientView extends JFrame {

    private JPanel panel;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField birthdayField;
    private JTextField sexField;
    private JTextField weightField;
    private JTextField heightField;
    private JButton backToHomescreenButton;
    private JButton saveButton;

    public CreatePatientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Caregiver Information"); // Set title for the frame
        initComponents();
    }

    private void initComponents() {

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.LINE_START;

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Initialize text fields and buttons
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        birthdayField = createFormattedDateField();
        sexField = new JTextField();
        weightField = createFormattedNumberField(10);
        heightField = createFormattedNumberField(10);
        backToHomescreenButton = new JButton("Back");
        saveButton = new JButton("Save");

        bottomPanel.add(saveButton);
        bottomPanel.add(backToHomescreenButton);

        // Add components to the panel
        panel.add(new JLabel("Name:"), gbc);
        nameField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Email:"), gbc);
        emailField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Phone Number:"), gbc);
        phoneField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(phoneField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Birthday:"), gbc);
        birthdayField = createFormattedDateField();
        gbc.gridx = 1;
        panel.add(birthdayField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Sex:"), gbc);
        sexField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(sexField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Height (in):"), gbc);
        heightField = createFormattedNumberField(10);
        gbc.gridx = 1;
        panel.add(heightField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Weight (lbs):"), gbc);
        weightField = createFormattedNumberField(10);
        gbc.gridx = 1;
        panel.add(weightField, gbc);

        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack(); // Pack the contents of the window and display it to its required size
        setLocationRelativeTo(null); // Center the window
        setVisible(true); // Make the frame visible
    }

    public void addBackButtonListener(ActionListener listener) {
        backToHomescreenButton.addActionListener(listener);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JTextField getBirthdayField() {
        return birthdayField;
    }

    public JTextField getSexField() {
        return sexField;
    }

    public JTextField getWeightField() {
        return weightField;
    }

    public JTextField getHeightField() {
        return heightField;
    }

    private JFormattedTextField createFormattedDateField() {
        try {
            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
            dateFormatter.setPlaceholderCharacter('_');
            JFormattedTextField dateField = new JFormattedTextField(dateFormatter);
            dateField.setColumns(10); // Set the size similar to other fields
            return dateField;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JFormattedTextField createFormattedNumberField(int columns) {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        JFormattedTextField numberField = new JFormattedTextField(formatter);
        numberField.setColumns(columns); // Set fixed size
        return numberField;
    }
}
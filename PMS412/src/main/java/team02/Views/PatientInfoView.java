package team02.Views;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import team02.Models.Patient;

import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;

public class PatientInfoView extends JFrame {
    private JTextField nameField, emailField, phoneField;
    private JFormattedTextField birthdayField;
    private JTextField sexField;
    private JFormattedTextField heightField, weightField;
    private JButton saveButton;
    private JButton backButton;
    private JTabbedPane tabbedPane;
    private Patient patient;
    private boolean isEmployee;

    public PatientInfoView(boolean isEmployee, Patient patient) {
        // Setup the main window
        setTitle("Patient Information");
        this.isEmployee = isEmployee;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);  // Removes the window borders and title bar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        this.patient = patient;

        tabbedPane = new JTabbedPane();
        JPanel contactPanel = setupContactPanel(isEmployee);
        JPanel personalPanel = setupPersonalPanel(isEmployee);

        tabbedPane.addTab("Contact Info", contactPanel);
        tabbedPane.addTab("Personal Info", personalPanel);
        add(tabbedPane, BorderLayout.CENTER);

        saveButton = new JButton("Save");
        backButton = new JButton("Back to Home Screen");

        add(saveButton, BorderLayout.SOUTH);
        add(backButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    private JPanel setupContactPanel(boolean isEmployee) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.LINE_START;

        panel.add(new JLabel("Name:"), gbc);
        nameField = new JTextField(patient.getName(), 10);
        nameField.setEditable(true);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Email:"), gbc);
        emailField = new JTextField(patient.getEmail(), 10);
        emailField.setEditable(true);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Phone Number:"), gbc);
        phoneField = new JTextField(patient.getPhoneNumber(), 10);
        gbc.gridx = 1;
        panel.add(phoneField, gbc);

        return panel;
    }

    private JPanel setupPersonalPanel(boolean isEmployee) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.gridx = 0;
        panel.add(new JLabel("Birthday:"), gbc);
        birthdayField = createFormattedDateField(patient.getBirthDate().toString(), isEmployee);
        gbc.gridx = 1;
        panel.add(birthdayField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Sex:"), gbc);
        sexField = new JTextField(patient.getSex(), 10);
        sexField.setEditable(isEmployee);
        gbc.gridx = 1;
        panel.add(sexField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Height (cm):"), gbc);
        heightField = createFormattedNumberField(patient.getheightInInches(), isEmployee, 10);
        gbc.gridx = 1;
        panel.add(heightField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Weight (kg):"), gbc);
        String num2 = "" + patient.getWeightInPounds();
        weightField = createFormattedNumberField(patient.getWeightInPounds(), isEmployee, 10);
        gbc.gridx = 1;
        panel.add(weightField, gbc);

        return panel;
    }

    private JFormattedTextField createFormattedDateField(String defaultDate, boolean isEditable) {
        try {
            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
            dateFormatter.setPlaceholderCharacter('_');
            JFormattedTextField dateField = new JFormattedTextField(dateFormatter);
            dateField.setValue(defaultDate);
            dateField.setEditable(isEditable);
            dateField.setColumns(10); // Set the size similar to other fields
            return dateField;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JFormattedTextField createFormattedNumberField(double defaultNum, boolean isEditable, int columns) {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Double.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Double.MAX_VALUE);
        JFormattedTextField numberField = new JFormattedTextField(formatter);
        numberField.setValue(defaultNum);
        numberField.setEditable(isEditable);
        numberField.setColumns(columns); // Set fixed size
        return numberField;
    }

    // Getter methods for the controller to use
    public JTextField getNameField() { return nameField; }
    public JTextField getEmailField() { return emailField; }
    public JTextField getPhoneField() { return phoneField; }
    public JFormattedTextField getBirthdayField() { return birthdayField; }
    public JTextField getSexField() { return sexField; }
    public JFormattedTextField getHeightField() { return heightField; }
    public JFormattedTextField getWeightField() { return weightField; }
    public JButton getSaveButton() { return saveButton; }
    public JButton getBackButton() { return backButton; }
    public Patient getPatient(){ return patient; }
    public boolean getIsEmployee(){ return isEmployee; }
}
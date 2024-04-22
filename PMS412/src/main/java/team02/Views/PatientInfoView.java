package team02.Views;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;

public class PatientInfoView extends JFrame {
    private JTextField nameField, emailField, phoneField;
    private JFormattedTextField birthdayField;
    private JTextField sexField;
    private JFormattedTextField heightField, weightField;
    private JButton saveButton;
    private JTabbedPane tabbedPane;

    public PatientInfoView(boolean isEmployee) {
        // Setup the main window
        setTitle("Patient Information");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);  // Removes the window borders and title bar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the tabbed pane
        tabbedPane = new JTabbedPane();

        // Contact Info Panel using GridBagLayout
        JPanel contactPanel = setupContactPanel(isEmployee);

        // Personal Info Panel using GridBagLayout
        JPanel personalPanel = setupPersonalPanel(isEmployee);

        // Add the tabbed pane to the main window
        tabbedPane.addTab("Contact Info", contactPanel);
        tabbedPane.addTab("Personal Info", personalPanel);
        add(tabbedPane, BorderLayout.CENTER);

        // Save Button
        saveButton = new JButton("Save");
        add(saveButton, BorderLayout.SOUTH);

        // Pack and set visible
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
        nameField = new JTextField(10);
        nameField.setEditable(isEmployee);
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

        return panel;
    }

    private JPanel setupPersonalPanel(boolean isEmployee) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.gridx = 0;
        panel.add(new JLabel("Birthday:"), gbc);
        birthdayField = createFormattedDateField(isEmployee);
        gbc.gridx = 1;
        panel.add(birthdayField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Sex:"), gbc);
        sexField = new JTextField(10);
        sexField.setEditable(isEmployee);
        gbc.gridx = 1;
        panel.add(sexField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Height (cm):"), gbc);
        heightField = createFormattedNumberField(isEmployee, 10);
        gbc.gridx = 1;
        panel.add(heightField, gbc);

        gbc.gridx = 0;
        panel.add(new JLabel("Weight (kg):"), gbc);
        weightField = createFormattedNumberField(isEmployee, 10);
        gbc.gridx = 1;
        panel.add(weightField, gbc);

        return panel;
    }

    private JFormattedTextField createFormattedDateField(boolean isEditable) {
        try {
            MaskFormatter dateFormatter = new MaskFormatter("####-##-##");
            dateFormatter.setPlaceholderCharacter('_');
            JFormattedTextField dateField = new JFormattedTextField(dateFormatter);
            dateField.setEditable(isEditable);
            dateField.setColumns(10); // Set the size similar to other fields
            return dateField;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JFormattedTextField createFormattedNumberField(boolean isEditable, int columns) {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        JFormattedTextField numberField = new JFormattedTextField(formatter);
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
}

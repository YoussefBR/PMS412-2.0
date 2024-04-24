package team02.Views;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.text.NumberFormat;
import java.text.ParseException;

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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Caregiver Information"); // Set title for the frame
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel(new GridLayout(0, 2, 10, 10)); // Set layout for the panel

        // Initialize text fields and buttons
        nameField = new JTextField();
        emailField = new JTextField();
        phonenumberField = new JTextField();
        birthDateField = createFormattedDateField();
        sexField = new JTextField();
        weightField = createFormattedNumberField(10);
        heightField = createFormattedNumberField(10);
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

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getPhoneNumberField() {
        return phonenumberField;
    }

    public JTextField getBirthDateField() {
        return birthDateField;
    }

    public JTextField getSexField(){
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
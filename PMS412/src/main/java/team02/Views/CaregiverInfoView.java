package PMS412.src.main.java.team02.Views;

import javax.swing.*;

public class CaregiverInfoView extends JFrame{
    private JLabel userIDLabel;
    private JLabel emailLabel;
    private JTextField phoneNumberField;

    private JTextField departmentField;


    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    private JButton backButton;
    private JButton saveButton;


    public JLabel getUserIDLabel() {
        return userIDLabel;
    }

    public void setUserIDLabel(JLabel userIDLabel) {
        this.userIDLabel = userIDLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public void setPhoneNumberField(JTextField phoneNumberField) {
        this.phoneNumberField = phoneNumberField;
    }



    public JTextField getDepartmentField() {
        return departmentField;
    }

    public void setDepartmentField(JTextField departmentField) {
        this.departmentField = departmentField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }
}
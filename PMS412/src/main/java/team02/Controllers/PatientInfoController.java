package team02.Controllers;

import javax.swing.*;
import java.sql.Date;

import team02.Models.dbIntegration;
import team02.Views.PatientInfoView;
import team02.Models.Patient;

public class PatientInfoController {
    private PatientInfoView view;

    public PatientInfoController(PatientInfoView view) {
        this.view = view;
        this.view.getSaveButton().addActionListener(e -> saveData());
        this.view.getBackButton().addActionListener(e -> goBack());
    }

    private void saveData() {
        // Example of saving data
        System.out.println("Saving Data:");
        String name = view.getNameField().getText();
        String email = view.getEmailField().getText();
        String phone = view.getPhoneField().getText();
        String birthday = view.getBirthdayField().getText();
        String sex = view.getSexField().getText();
        double height = Double.parseDouble(view.getHeightField().getText());
        double weight = Double.parseDouble(view.getWeightField().getText());

        // System.out.println("Name: " + name);
        // System.out.println("Email: " + email);
        // System.out.println("Phone: " + phone);
        // System.out.println("Birthday: " + birthday);
        // System.out.println("Sex: " + sex);
        // System.out.println("Height: " + height);
        // System.out.println("Weight: " + weight);

        // Save data to database
        Patient patient = view.getPatient();
        patient.setName(name);
        patient.setEmail(email);
        patient.setBirthDate(Date.valueOf(birthday).toLocalDate());
        patient.setSex(sex);
        patient.setWeightInPounds(weight);
        patient.setheightInInches(height);

        dbIntegration db = dbIntegration.getInstance();
        System.out.println(view.getIsEmployee());
        boolean successful = (!view.getIsEmployee()) ? db.updatePatient(patient.getUserID(), name, email, phone)
                : db.updatePatient(patient.getUserID(), name, email, phone, Date.valueOf(birthday), sex, weight,
                        height);

        String message = successful ? "Data saved successfully!" : "Error: Data not saved!";

        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void goBack() {
        if (view.getIsEmployee()) {
            view.dispose();
        }
        view.dispose();
    }
}

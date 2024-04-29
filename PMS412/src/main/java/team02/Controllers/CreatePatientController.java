package team02.Controllers;

import team02.Models.dbIntegration;
import team02.Views.CreatePatientView;
import javax.swing.*;
import java.sql.Date;

public class CreatePatientController {
    private CreatePatientView view;

    public CreatePatientController(CreatePatientView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        // Add action listeners to the view's buttons
        view.addBackButtonListener(e -> onBack());
        view.addSaveButtonListener(e -> onSave());
    }

    private void onBack() {
        // Handle logic to go back to the home screen, possibly hiding this view or
        // showing another
        view.dispose();
    }

    private void onSave() {
        // Get data from view
        String name = view.getNameField().getText();
        String email = view.getEmailField().getText();
        String phoneNumber = view.getPhoneField().getText();
        String birthDate = view.getBirthdayField().getText();
        String sex = view.getSexField().getText();
        double weight = Double.parseDouble(view.getWeightField().getText());
        double height = Double.parseDouble(view.getHeightField().getText());

        // Save data to database
        dbIntegration db = dbIntegration.getInstance();
        System.out.println(birthDate); // Debugging (should be in the format "yyyy-mm-dd"
        Date date = Date.valueOf(birthDate);
        System.out.println(date);
        db.addPatient(name, email, phoneNumber, date, sex, weight, height);

        // For now, let's just show a dialog box as a placeholder
        JOptionPane.showMessageDialog(view, "Patient information saved successfully!");
    }
}
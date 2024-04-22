package team02.Controllers;

import javax.swing.*;
import team02.Views.PatientInfoView;

public class PatientInfoController {
    private PatientInfoView view;

    public PatientInfoController(PatientInfoView view) {
        this.view = view;
        this.view.getSaveButton().addActionListener(e -> saveData());
    }

    private void saveData() {
        // Example of saving data
        System.out.println("Saving Data:");
        System.out.println("Name: " + view.getNameField().getText());
        System.out.println("Email: " + view.getEmailField().getText());
        System.out.println("Phone: " + view.getPhoneField().getText());
        System.out.println("Birthday: " + view.getBirthdayField().getText());
        System.out.println("Sex: " + view.getSexField().getText());
        System.out.println("Height: " + view.getHeightField().getText());
        System.out.println("Weight: " + view.getWeightField().getText());

        // Show confirmation dialog
        
    }
}

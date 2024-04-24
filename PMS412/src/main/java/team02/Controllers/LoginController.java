package team02.Controllers;

import javax.swing.*;

import team02.Models.Authenticator;
import team02.Models.Caregiver;
import team02.Models.dbIntegration;
import team02.Views.CaregiverHomeScreen;
import team02.Views.CaregiverInfoView;
import team02.Views.LoginView;
import team02.Views.PatientHomeScreen;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
        this.view.getLoginButton().addActionListener(e -> authenticate());
    }

    private void authenticate() {
        String username = view.getUsernameField().getText();
        String password = new String(view.getPasswordField().getPassword());

        // Check credentials (this is just a simple example)
        Authenticator auth = Authenticator.getInstance();
        if (auth.Authenticate(username, password)) {
            dbIntegration db = dbIntegration.getInstance();
            boolean isPatient = db.isPatient(username);
            int id = isPatient ? db.getPatientID(username) : db.getEmployeeID(username);

            if(isPatient){
                // Go to patient home screen
                SwingUtilities.invokeLater(() -> {
                    PatientHomeScreen patientHomeScreen = new PatientHomeScreen(id);
                    new PatientHSController(patientHomeScreen);
                });
            } else {
                // Go to employee home screen
                SwingUtilities.invokeLater(() -> {
                    CaregiverHomeScreen caregiverHomeScreen = new CaregiverHomeScreen();
                    new CaregiverHSController(caregiverHomeScreen);
                });
        
            }
        } else {
            JOptionPane.showMessageDialog(view, "Invalid username or password.");
        }
    }
}


package team02.Controllers;

import team02.Models.dbIntegration;
import team02.Views.CaregiverHomeScreen;
import team02.Views.PatientHomeScreen;
import team02.Views.PatientInfoView;
import team02.Models.Patient;

import javax.swing.*;

public class PatientHSController {
    private PatientHomeScreen view;

    public PatientHSController(PatientHomeScreen view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.addMyAccountButtonListener(e -> onMyAccount());
        view.addLogoutButtonListener(e -> onLogout());
    }

    private void onMyAccount() {
        // Redirect to Patient Account Page
        dbIntegration db = dbIntegration.getInstance();
        Patient patient = db.getPatient(view.getPatientID());
        SwingUtilities.invokeLater(() -> {
            PatientInfoView patientInfoView = new PatientInfoView(false, patient);
            new PatientInfoController(patientInfoView);
        });
    }

    private void onLogout(){
        view.dispose();
    }
}

package team02.Controllers;

import team02.Models.dbIntegration;
import team02.Views.CaregiverHomeScreen;
import team02.Views.SearchPatientView;
import team02.Views.CreatePatientView;
import team02.Models.Patient;
import javax.swing.*;
import java.util.ArrayList;

public class CaregiverHSController {
    private CaregiverHomeScreen view;

    public CaregiverHSController(CaregiverHomeScreen view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.addCreatePatientButtonListener(e -> onCreatePatient());
        view.addSearchPatientButtonListener(e -> onSearchPatient());
        view.addLogoutButtonListener(e -> onLogout());
        view.addMyPatientsButtonListener(e -> onMyPatients());
    }

    private void onCreatePatient() {
        // Redirect to Create Patient Page
        SwingUtilities.invokeLater(() -> {
            CreatePatientView createPatientView = new CreatePatientView();
            new CreatePatientController(createPatientView);
        });

    }

    private void onSearchPatient() {
        // Redirect to Search Patient Page
        dbIntegration db = dbIntegration.getInstance();
        ArrayList<Patient> patients = db.getPatients();
        SwingUtilities.invokeLater(() -> {
            SearchPatientView searchPatientView = new SearchPatientView(patients, view.getRole());
            new SearchPatientController(searchPatientView);
        });
    }

    private void onMyPatients() {
        // Fill search patient screen with doctor's specific patients
        dbIntegration db = dbIntegration.getInstance();
        ArrayList<Patient> patients = db.getPatientsByDoctor(view.getId());
        SwingUtilities.invokeLater(() -> {
            SearchPatientView searchPatientView = new SearchPatientView(patients, view.getRole());
            new SearchPatientController(searchPatientView);
        });
    }

    private void onLogout() {
        view.dispose();
    }
}

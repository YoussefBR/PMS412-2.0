package team02.Controllers;

import team02.Views.CaregiverHomeScreen;
import team02.Views.CreatePatientView;
import javax.swing.*;

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
        
    }

    private void onLogout(){
        view.dispose();
    }
}

package team02;

import java.sql.*;
import team02.Models.dbIntegration;

import javax.swing.SwingUtilities;

import team02.Views.PatientInfoView;
import team02.Controllers.*;


public class Main {

    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> {
            PatientInfoView patientInfoView = new PatientInfoView(true);
            new PatientInfoController(patientInfoView);
        });

    }
}

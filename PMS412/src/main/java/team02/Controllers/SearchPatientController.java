package team02.Controllers;

import team02.Views.SearchPatientView;
import team02.Views.PatientInfoView;
import team02.Models.Patient;
import team02.Models.dbIntegration;
import team02.Models.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SearchPatientController {

    private SearchPatientView view;

    public SearchPatientController(SearchPatientView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        // Add action listeners to buttons
        view.getSearchButton().addActionListener(e -> performSearch());
        view.getViewPatientButton().addActionListener(e -> viewPatientDetails());
        view.getAssignPatientButton().addActionListener(e -> assignPatient());
        view.getBackButton().addActionListener(e -> goBack());
        view.getSelectDoctorButton().addActionListener(e -> assignDoctor());
    }

    private void performSearch() {
        String searchText = view.getSearchField().getText();
        // Perform search based on searchText
        // Example: Filter/search in the table's model
        System.out.println("Search for: " + searchText);
        // Here you would typically interact with a model or database to get the search
        // results
        // For now, let's just simulate a search
        simulateSearch(searchText);
    }

    private void simulateSearch(String searchText) {
        // Assuming a DefaultTableModel and setting the model based on search results
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0); // Clear previous results
        model.addRow(new Object[] { "3", "Alice Johnson", "32", "Healthy" }); // Simulated result
    }

    private void viewPatientDetails() {
        // Implementation for viewing selected patient details
        int row = view.getTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Please select a patient to view details.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ArrayList<Patient> patients = view.getPatients();
        Patient selectedPatient = patients.get(row);
        boolean isModifiable = assignedToDoctor(selectedPatient);
        SwingUtilities.invokeLater(() -> {
            PatientInfoView patientInfoView = new PatientInfoView(isModifiable, selectedPatient);
            new PatientInfoController(patientInfoView);
        });
    }

    private void assignPatient() {
        if (view.getRole().equals("admin")) {
            int row = view.getTable().getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(view, "Please select a patient to view details.", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            view.showDoctorAssignmentDialog();
        } else {
            JOptionPane.showMessageDialog(view, String.format("%ss cannot assign patients.", view.getRole()),
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void goBack() {
        view.dispose();
    }

    private void assignDoctor() {
        // Get selected doctor
        int selectedIndex = view.getDoctorList().getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(view, "Please select a doctor to assign.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Doctor selectedDoctor = view.getDoctors().get(selectedIndex);

        // Get selected patient
        int row = view.getTable().getSelectedRow();
        assert (row != -1);
        Patient selectedPatient = view.getPatients().get(row);

        // Assign patient to doctor
        dbIntegration.getInstance().assignPatient(selectedPatient.getUserID(), selectedDoctor.getUserID());

        view.disposeDoctorAssignment();
    }

    private boolean assignedToDoctor(Patient patient) {
        String role = view.getRole();
        if (role.equals("doctor")) {
            return dbIntegration.getInstance().isPatientAssignedToDoctor(patient.getUserID(), view.getId());
        }
        return false;
    }
}

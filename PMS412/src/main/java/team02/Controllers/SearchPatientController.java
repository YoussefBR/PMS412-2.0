package team02.Controllers;

import team02.Views.SearchPatientView;
import team02.Views.PatientInfoView;
import team02.Models.Patient;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPatientController {
    private SearchPatientView view;

    public SearchPatientController(SearchPatientView view) {
        this.view = view;
        initView();
        initController();
    }

    private void initView() {
        // Initial setup or data loading operations if needed
    }

    private void initController() {
        // Add action listeners to buttons
        view.getSearchButton().addActionListener(e -> performSearch());
        view.getViewPatientButton().addActionListener(e -> viewPatientDetails());
        view.getAssignPatientButton().addActionListener(e -> assignPatient());
        view.getBackButton().addActionListener(e -> goBack());
        view.getLogoutButton().addActionListener(e -> logout());
    }

    private void performSearch() {
        String searchText = view.getSearchField().getText();
        // Perform search based on searchText
        // Example: Filter/search in the table's model
        System.out.println("Search for: " + searchText);
        // Here you would typically interact with a model or database to get the search results
        // For now, let's just simulate a search
        simulateSearch(searchText);
    }

    private void simulateSearch(String searchText) {
        // Assuming a DefaultTableModel and setting the model based on search results
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0); // Clear previous results
        model.addRow(new Object[]{"3", "Alice Johnson", "32", "Healthy"}); // Simulated result
    }

    private void viewPatientDetails() {
        System.out.println("Viewing patient details.");
        // Implementation for viewing selected patient details
        int row = view.getTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Please select a patient to view details.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        ArrayList<Patient> patients = view.getPatients();
        Patient selectedPatient = patients.get(row);
        SwingUtilities.invokeLater(() -> {
            PatientInfoView patientInfoView = new PatientInfoView(true, selectedPatient);
            new PatientInfoController(patientInfoView);
        });
    }

    private void assignPatient() {
        System.out.println("Assigning patient.");
        // Implementation for assigning the selected patient
    }

    private void goBack() {
        System.out.println("Going back to previous view.");
        view.dispose();
    }

    private void logout() {
        System.out.println("Logging out.");
        // Implementation for logging out
    }

}

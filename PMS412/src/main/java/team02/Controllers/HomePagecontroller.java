// package PMS412.src.main.java.team02.Controllers;

// import javax.swing.*;

// import PMS412.src.main.java.team02.Views.CaregiverInfoView;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class HomePageController {
//     private PMS412.src.main.java.team02.Views.HomePage view;
//     private CaregiverInfoView caregiverInfoView;

//     public HomePageController(PMS412.src.main.java.team02.Views.HomePage view) {this.view = view;
//         this.caregiverInfoView = new CaregiverInfoView(); // Instantiate the CaregiverInfoView

//         // Attach action listeners to buttons
//         view.viewMedicalInformationButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 viewMedicalInformationButtonClicked();
//             }
//         });

//         view.logoutButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 logoutButtonClicked();
//             }
//         });

//         view.updateMedicalInformationButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 updateMedicalInformationButtonClicked();
//             }
//         });

//         view.quitButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 quitButtonClicked();
//             }
//         });
//     }

//     // Method to handle view medical information button click event
//     public void viewMedicalInformationButtonClicked() {
//         // Show the CaregiverInfoView when the button is clicked
//         caregiverInfoView.setVisible(true);
//     }

//     // Method to handle logout button click event
//     public void logoutButtonClicked() {
//         // Add logic to handle logout
//         JOptionPane.showMessageDialog(view.getPanel1(), "Logout Button Clicked!");
//     }

//     // Method to handle update medical information button click event
//     public void updateMedicalInformationButtonClicked() {
//         // Add logic to handle updating medical information
//         JOptionPane.showMessageDialog(view.getPanel1(), "Update Medical Information Button Clicked!");
//     }

//     // Method to handle quit button click event
//     public void quitButtonClicked() {
//         // Add logic to handle quitting the application
//         int choice = JOptionPane.showConfirmDialog(view.getPanel1(), "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
//         if (choice == JOptionPane.YES_OPTION) {
//             System.exit(0);
//         }
//     }
// }

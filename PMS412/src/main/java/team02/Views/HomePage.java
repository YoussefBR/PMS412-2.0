// package PMS412.src.main.java.team02.Views;

// import Controllers.HomePageController;

// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class HomePage {
//     private JPanel panel1;
//     public JButton viewMedicalInformationButton;

//     public JButton logoutButton;

//     public JButton updateMedicalInformationButton;
//     public JButton quitButton;

//     public HomePage() {
//         HomePageController controller = new HomePageController(this);
//         // Attach action listeners to buttons
//         viewMedicalInformationButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 controller.viewMedicalInformationButtonClicked();
//             }
//         });


//         logoutButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 controller.logoutButtonClicked();
//             }
//         });


//         quitButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 controller.quitButtonClicked();
//             }
//         });
//     }

//     // Getter for panel1
//     public JPanel getPanel1() {
//         return panel1;
//     }
// }

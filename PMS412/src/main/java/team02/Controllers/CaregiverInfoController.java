// package PMS412.src.main.java.team02.Controllers;

// import Models.Caregiver;
// import PMS412.src.main.java.team02.Views.CaregiverInfoView;

// import javax.swing.*;
// import javax.swing.text.View;

// public class CaregiverInfoController {

//     private Caregiver caregiverModel;
//     private CaregiverInfoView view;

//     public CaregiverInfoController(Caregiver m, CaregiverInfoView v){
//         this.caregiverModel = m;
//         this.view = v;

//         //Setting initial values in the labels
//         view.getUserIDLabel().setText(String.valueOf(caregiverModel.getUserID()));
//         view.getEmailLabel().setText(caregiverModel.getEmail());

//         view.getPhoneNumberField().setText(caregiverModel.getPhoneNumber());
//         view.getDepartmentField().setText(caregiverModel.getDepartment());

//         //action for save button

//         view.getSaveButton().addActionListener(e -> {
//             if(view.getPhoneNumberField().getText().isEmpty() || view.getDepartmentField().getText().isEmpty()){
//                 JOptionPane.showMessageDialog(view, "Text field cannot be empty!");
//             }
//             caregiverModel.setDepartment(view.getDepartmentField().getText());
//             caregiverModel.setDepartment(view.getPhoneNumberField().getText());
//         });

//         //action for back button
//         view.getBackButton().addActionListener(e -> {
//             view.dispose();
//             // wire up to home page when it is completed
//         });

//     }

// }

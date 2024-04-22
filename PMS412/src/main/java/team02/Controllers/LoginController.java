package team02.Controllers;

import javax.swing.*;

import team02.Models.Authenticator;
import team02.Models.dbIntegration;
import team02.Views.LoginView;

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
            if(isPatient){
                // Go to patient home screen
            } else {
                // Go to employee home screen
            }
        } else {
            JOptionPane.showMessageDialog(view, "Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        // Run the login screen
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            new LoginController(loginView);
        });
    }
}


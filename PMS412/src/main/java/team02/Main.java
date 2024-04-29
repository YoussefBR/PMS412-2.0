package team02;

import javax.swing.SwingUtilities;

import team02.Views.LoginView;
import team02.Controllers.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            new LoginController(loginView);
        });

    }
}

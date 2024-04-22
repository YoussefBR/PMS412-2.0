package Views;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JPanel panel1;
    private JTextField UserIDfield;
    private JTextField Passwordfield;
    private JLabel userIDLabel;
    private JLabel passwordLabel;
    private JButton loginButton;


    public Login() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        UserIDfield = new JTextField(20);
        Passwordfield = new JTextField(20);
        loginButton = new JButton("Login");

        JPanel panel = new JPanel();
        panel.add(new JLabel("User ID:"));
        panel.add(UserIDfield);
        panel.add(new JLabel("Password:"));
        panel.add(Passwordfield);
        panel.add(loginButton);

        add(panel);

        setVisible(true);
    }

    public JTextField getUserIDField() {
        return UserIDfield;
    }

    public JTextField getPasswordField() {
        return Passwordfield;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}

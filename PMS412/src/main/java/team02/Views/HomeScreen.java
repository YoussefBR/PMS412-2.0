package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame{
    private JButton createPatientButton;
    private JPanel panel1;
    private JButton searchPatientButton;

    public HomeScreen() {
        super("Home Screen");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createPatientButton = new JButton("Create Patient");
        searchPatientButton = new JButton("Search Patient");

        JPanel panel = new JPanel();
        panel.add(createPatientButton);
        panel.add(searchPatientButton);
        add(panel);

        setVisible(true);
    }

    public void addCreatePatientButtonListener(ActionListener listener) {
        createPatientButton.addActionListener(listener);
    }

    public void addSearchPatientButtonListener(ActionListener listener) {
        searchPatientButton.addActionListener(listener);
    }
}



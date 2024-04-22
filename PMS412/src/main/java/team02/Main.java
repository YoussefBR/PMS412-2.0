package team02;

import java.sql.*;

import team02.Models.dbIntegration;


public class Main {

    public static void main(String[] args) {

        dbIntegration db = dbIntegration.getInstance();
        db.checkLogin("test", "1234");
        int id = db.addPatient("fake_patient", "fake.patient@gmail.com", "1234567890", Date.valueOf("1990-01-01"), "M", 150.0, 72.0);
        System.out.println(id);

    }
}

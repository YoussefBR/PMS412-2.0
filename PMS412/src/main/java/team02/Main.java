package PMS412.src.main.java.team02;

import java.sql.*;

import PMS412.src.main.java.team02.Models.dbIntegration;


public class Main {

    public static void main(String[] args) {

        dbIntegration db = dbIntegration.getInstance();
        db.checkLogin("test", "1234");

    }
}

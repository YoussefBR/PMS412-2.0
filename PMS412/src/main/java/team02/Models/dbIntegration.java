package PMS412.src.main.java.team02.Models;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbIntegration {

    Connection connect = null;
    
    private static dbIntegration instance = new dbIntegration();

    private dbIntegration(){

        String url = "jdbc:postgresql://localhost/pms412";

        try {

            connect = DriverManager.getConnection(url,"script", "pass");
            System.out.println("Connection established");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static dbIntegration getInstance(){
        return instance;
    }

    public boolean checkLogin(String login, String password){
        // Statements allow to issue SQL queries to the database
        try{
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select * from logins where login = '%s'", login));
            if(resultSet.next()) {
                String pwd = resultSet.getString("password");
                if(pwd.equals(password)){
                    System.out.println("Login successful");
                    return true;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addLogin(String login, String password){
        try{
            Statement statement = connect.createStatement();
            statement.executeQuery(String.format("insert into logins (login, password) values (%s, %s)", login, password));
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int addPatient(String name, String email, String phoneNumber, Date birthDate, String sex, double weightInPounds, double heightInInches){
        try{
            String query = "insert into patients (name, email, phone_number, birth_date, sex, weight, height) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = connect.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phoneNumber);
            pstmt.setDate(4, birthDate);
            pstmt.setString(5, sex);
            pstmt.setDouble(6, weightInPounds);
            pstmt.setDouble(7, heightInInches);
            pstmt.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
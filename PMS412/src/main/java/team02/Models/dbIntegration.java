package team02.Models;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

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

            Statement statement = connect.createStatement();

            String query = String.format("insert into patients (name, email, phone_num, birthDate, sex, weight, height) values ('%s', '%s', '%s', DATE '%s', '%s', %f, %f);", name, email, phoneNumber, birthDate, sex, weightInPounds, heightInInches);
            statement.executeQuery(query);

        }catch(Exception e){
            //System.out.println("Error: " + e.getMessage());
        }

        return getPatientID(email);

    }

    public boolean updatePatient(int userID, String name, String email, String phoneNumber, Date birthDate, String sex, double weightInPounds, double heightInInches){
        try{
            Statement statement = connect.createStatement();
            String query = String.format("update patients set name = '%s', phone_num = '%s', birthDate = DATE '%s', sex = '%s', weight = %f, height = %f where patient_id = %d;", name, phoneNumber, birthDate, sex, weightInPounds, heightInInches, userID);
            statement.executeQuery(query);
            return true;
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public int getPatientID(String email){
        try{
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select patient_id from patients where email = '%s';", email));
            if(resultSet.next()) {
                return resultSet.getInt("patient_id");
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return -1;
    }

    public boolean isPatient(String login){
        try{
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select * from logins where login = '%s';", login));
            if(resultSet.next()) {
                return (resultSet.getInt("patient_id") == 0)? false: true;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
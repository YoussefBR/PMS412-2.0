package team02.Models;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public boolean addPatient(String name, String email, String phoneNumber, Date birthDate, String sex, double weightInPounds, double heightInInches){
        try{

            Statement statement = connect.createStatement();

            String query = String.format("insert into patients (name, email, phone_num, birthDate, sex, weight, height) values ('%s', '%s', '%s', DATE '%s', '%s', %f, %f);", name, email, phoneNumber, birthDate, sex, weightInPounds, heightInInches);
            statement.executeUpdate(query);
            return true;
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean updatePatient(int userID, String name, String email, String phoneNumber, Date birthDate, String sex, double weightInPounds, double heightInInches){
        try{
            Statement statement = connect.createStatement();
            String query = String.format("update patients set name = '%s', email = '%s', phone_num = '%s', birthDate = DATE '%s', sex = '%s', weight = %f, height = %f where patient_id = %d;", name, email, phoneNumber, birthDate, sex, weightInPounds, heightInInches, userID);
            statement.executeUpdate(query);
            return true;
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean updatePatient(int userID, String name, String email, String phoneNumber){
        try{
            Statement statement = connect.createStatement();
            String query = String.format("update patients set name = '%s', email = '%s', phone_num = '%s' where patient_id = %d;", name, email, phoneNumber, userID);
            statement.executeUpdate(query);
            return true;
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public int getPatientID(String login){
        try{
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select patient_id from logins where login = '%s';", login));
            if(resultSet.next()) {
                return resultSet.getInt("patient_id");
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return -1;
    }

    public int getEmployeeID(String login){
        try{
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select employee_id from logins where login = '%s';", login));
            if(resultSet.next()) {
                return resultSet.getInt("employee_id");
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

    public Patient getPatient(int patientID){
        try{
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select * from patients where patient_id = %d;", patientID));
            if(resultSet.next()) {
                Patient patient =  new Patient(patientID, resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("phone_num"), resultSet.getDate("birthDate").toLocalDate(), resultSet.getString("sex"), resultSet.getDouble("weight"), resultSet.getDouble("height"));
                return patient;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Patient> getPatients(){
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try{
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from patients;");
            while(resultSet.next()) {
                Patient patient =  new Patient(resultSet.getInt("patient_id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("phone_num"), resultSet.getDate("birthDate").toLocalDate(), resultSet.getString("sex"), resultSet.getDouble("weight"), resultSet.getDouble("height"));
                patients.add(patient);
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return patients;
    }
}
package PMS412.src.main.java.team02.Models;

public class Authenticator {

    private static Authenticator instance;

    private Authenticator(){}

    public static Authenticator getInstance() {
        if (instance == null) {
            // only create a new authenticator if one hasn't been created before
            instance = new Authenticator();
        }
        return instance;
    }

    /**
     * Looks up the employee login information and returns whether authentication was successful or not.
     * 
     * @param employee_id the employee's user login
     * @param password the employee's password
     * @return a boolean representing whether authentication passes
     */
    public boolean AuthenticateEmployee(String employee_id, String password){
        // Implementation details... 
        dbIntegration db = dbIntegration.getInstance();
        return db.checkLogin(employee_id, password);
    }
    
    /**
     * Looks up the patient login information and returns whether authentication was successful or not.
     * 
     * @param patient_id the patient's user login
     * @param dob the patient's date of birth
     * @param password the patient's password
     * @return a boolean representing whether authentication passes
     */
    public boolean AuthenticatePatient(String patient_id, String password){
        // Implementation details... 
        dbIntegration db = dbIntegration.getInstance();
        return db.checkLogin(patient_id, password); 
    }

    /**
     * Changes an employee password if authentication passes
     * 
     * @param employee_id the employee's user login
     * @param old_password the employee's old password
     * @param new_password the employee's new requested password
     * @return a boolean representing whether authentication passes
     */
    public Boolean changeEmployeePassword(String employee_id, String old_password, String new_password){
        // Implementation details... 
        return true;
    }

    /**
     * Changes the patient's password if authentication passes
     * 
     * @param patient_id the patient's user login
     * @param dob the patient's date of birth
     * @param old_password the patient's old password
     * @param new_password the patient's new requested password
     * @return a boolean representing whether authentication passes
     */
    public Boolean changePatientPassword(String patient_id, String old_password, String new_password){
        // Implementation details... 
        return true;
    }

    /**
     * Adds a new employee to the dictionary
     * 
     * @param employee_id the employee's user login
     * @param password the employee's password
     * @return a boolean representing whether authentication passes
     */
    public Boolean addNewEmployee(String employee_id, String password){
        // Implementation details... 
        dbIntegration db = dbIntegration.getInstance();
        return db.addLogin(employee_id, password);
    }

    /**
     * Adds a new patient to the dictionary
     * 
     * @param patient_id the patient's user login
     * @param dob the patient's date of birth
     * @param password the patient's password
     * @return a boolean representing whether authentication passes
     */
    public Boolean addNewPatient(String patient_id, String password){
        // Implementation details... 
        dbIntegration db = dbIntegration.getInstance();
        return db.addLogin(patient_id, password);
    }  

    /**
     * Checks if an employee exists in the dictionary
     * 
     * @param employee_id the employee's user login
     * @return a boolean representing whether the employee exists or not
     */
    public Boolean employeeExists(String employee_id){
        //Implementation details...
        return true;
    }

    /**
     * Checks if a patient exists or not
     * 
     * @param patient_id the patients user login
     * @return a boolean representing whether the patient exists or not
     */
    public Boolean patientExists(String patient_id){
        //Implementation details...
        return true;
    }
}

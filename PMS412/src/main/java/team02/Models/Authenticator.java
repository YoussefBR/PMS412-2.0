package team02.Models;

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
     * @param employeeId the employee's user login
     * @param password the employee's password
     * @return a boolean representing whether authentication passes
     */
    public boolean AuthenticateEmployee(String employeeId, String password){
        // Implementation details... 
        dbIntegration db = dbIntegration.getInstance();
        return db.checkLogin(employeeId, password);
    }
    
    /**
     * Looks up the patient login information and returns whether authentication was successful or not.
     * 
     * @param patientId the patient's user login
     * @param dob the patient's date of birth
     * @param password the patient's password
     * @return a boolean representing whether authentication passes
     */
    public boolean AuthenticatePatient(String patientId, String password){
        // Implementation details... 
        dbIntegration db = dbIntegration.getInstance();
        return db.checkLogin(patientId, password); 
    }

    /**
     * Changes an employee password if authentication passes
     * 
     * @param employeeId the employee's user login
     * @param oldPassword the employee's old password
     * @param newPassword the employee's new requested password
     * @return a boolean representing whether authentication passes
     */
    public Boolean changeEmployeePassword(String employeeId, String oldPassword, String newPassword){
        // Implementation details... 
        return true;
    }

    /**
     * Changes the patient's password if authentication passes
     * 
     * @param patientId the patient's user login
     * @param dob the patient's date of birth
     * @param oldPassword the patient's old password
     * @param newPassword the patient's new requested password
     * @return a boolean representing whether authentication passes
     */
    public Boolean changePatientPassword(String patientId, String oldPassword, String newPassword){
        // Implementation details... 
        return true;
    }

    /**
     * Adds a new employee to the dictionary
     * 
     * @param employeeId the employee's user login
     * @param password the employee's password
     * @return a boolean representing whether authentication passes
     */
    public Boolean addNewEmployee(String employeeId, String password){
        // Implementation details... 
        dbIntegration db = dbIntegration.getInstance();
        return db.addLogin(employeeId, password);
    }

    /**
     * Adds a new patient to the dictionary
     * 
     * @param patientId the patient's user login
     * @param dob the patient's date of birth
     * @param password the patient's password
     * @return a boolean representing whether authentication passes
     */
    public Boolean addNewPatient(String patientId, String password){
        // Implementation details... 
        dbIntegration db = dbIntegration.getInstance();
        return db.addLogin(patientId, password);
    }  

    /**
     * Checks if an employee exists in the dictionary
     * 
     * @param employeeId the employee's user login
     * @return a boolean representing whether the employee exists or not
     */
    public Boolean employeeExists(String employeeId){
        //Implementation details...
        return true;
    }

    /**
     * Checks if a patient exists or not
     * 
     * @param patientId the patients user login
     * @return a boolean representing whether the patient exists or not
     */
    public Boolean patientExists(String patientId){
        //Implementation details...
        return true;
    }
}

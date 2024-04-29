package team02.Models;

import java.util.HashMap;

public class UserManagement {

    static HashMap<String, Caregiver> Employees = new HashMap<>();
    static HashMap<String, Patient> Patients = new HashMap<>();

    /**
     * Adds an employee to the patients dictionary
     * 
     * @param user_id       user's login
     * @param employee_info the Caregiver object holding the initial employee
     *                      information
     * @return a boolean representing whether the employee was successfully added
     */
    public static Boolean addEmployee(String user_id, Caregiver employee_info) {
        if (Employees.containsKey(user_id)) {
            // Employee with this user_id already exists
            return false;
        } else {
            Employees.put(user_id, employee_info);

            return true;
        }
    }

    /**
     * Adds a patient to the patients dictionary
     * 
     * @param user_id      user's login
     * @param patient_info the Patient object holding the initial patient
     *                     information
     * @return a boolean representing whether the patient was successfully added
     */
    public static Boolean addPatient(String user_id, Patient patient_info) {
        if (Patients.containsKey(user_id)) {
            // Patient with this user_id already exists
            return false;
        } else {
            Patients.put(user_id, patient_info);
            return true;
        }
    }

    /**
     * Gets a patient object corresponding to the patient's user ID
     * 
     * @param user_id the user's user login
     * @return the Patient object representing the patient
     */
    public static Patient getPatient(String user_id) {
        return Patients.get(user_id);
    }

    /**
     * Gets a Caregiver object corresponding to the employee's user ID
     *
     * @param user_id the user's user login
     * @return the Caregiver object representing the patient
     */
    public static Caregiver getEmployee(String user_id) {
        return Employees.get(user_id);
    }

}

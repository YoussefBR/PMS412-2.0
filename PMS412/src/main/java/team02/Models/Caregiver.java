package team02.Models;

import java.util.List;

public class Caregiver extends User {
    
    private String department;
    private List<Patient> patients;

    public Caregiver(int userID, String name, String email, String phoneNumber, String department, List<Patient> patients) {
        super(userID, name, email, phoneNumber);
        this.department = department;
        this.patients = patients;
    }

    /**
     * Sets the department for the user.
     *
     * @param department The new department to be set for the user.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    /**
     * Assigns a patient to the caregiver, updating the caregiver's client list.
     *
     * @param patient The patient to be assigned to the caregiver.
     * @throws IllegalArgumentException If the patient is already assigned to the caregiver or if the patient is null.
     */

    public void assignPatient(Patient patient) {
        // Implementation details...
        patients.add(patient);
    }

    /**
     * Unassigns a patient from the caregiver, removing the patient from the caregiver's client list.
     *
     * @param patient The patient to be unassigned from the caregiver.
     * @throws IllegalArgumentException If the patient is not currently assigned to the caregiver or if the patient is null.
     */
    public void unassignPatient(Patient patient) {
        // Implementation details...
        patients.remove(patient);
    }

    /**
     * Adds a new health record for the specified patient to the patient's list of records.
     *
     * @param record The health record to be added to the patient's records.
     * @param patient The Patient object for whom the health record is being added.
     * @throws IllegalArgumentException If the specified record is already present in the patient's records, if the record is null, or if the patient is null.
     */
    public void addRecord(Record record, Patient patient) {
        // Implementation details...
        patient.addRecord(record);

    }

    /**
     * Retrieves the most recent health record for the patient.
     *
     * @return The latest health record of the patient.
     */
    public String getLatestRecord(Patient patient){
        return "latest record";
    }

    /**
     * Assigns a new medication to the specified patient, adding it to the list of prescribed medications.
     *
     * @param medication The Medication object representing the medication to be assigned.
     * @param patient The Patient object to whom the medication is being assigned.
     * @throws IllegalArgumentException If the specified medication is already assigned to the patient, if the medication is null, or if the patient is null.
     */
    public void assignMedication(Medication medication, Patient patient) {
        // Implementation details...
        patient.addMedication(medication);
    }

}

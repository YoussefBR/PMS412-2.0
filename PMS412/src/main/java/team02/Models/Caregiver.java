package team02.Models;

public class Caregiver extends User {

    private String role;

    public Caregiver(int userID, String name, String email, String phoneNumber, String role) {
        super(userID, name, email, phoneNumber);
        this.role = role;
    }

    /**
     * Retrieves the role of the caregiver.
     * 
     * @return The role of the caregiver.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the caregiver.
     * 
     * @param role: The new role of the caregiver.
     */
    public void setRole(String role) {
        this.role = role;
    }

    // /**
    // * Adds a new health record for the specified patient to the patient's list of
    // records.
    // *
    // * @param record The health record to be added to the patient's records.
    // * @param patient The Patient object for whom the health record is being
    // added.
    // * @throws IllegalArgumentException If the specified record is already present
    // in the patient's records, if the record is null, or if the patient is null.
    // */
    // public void addRecord(Record record, Patient patient) {
    // // Implementation details...
    // patient.addRecord(record);

    // }

    // /**
    // * Retrieves the most recent health record for the patient.
    // *
    // * @return The latest health record of the patient.
    // */
    // public String getLatestRecord(Patient patient){
    // return "latest record";
    // }

    // /**
    // * Assigns a new medication to the specified patient, adding it to the list of
    // prescribed medications.
    // *
    // * @param medication The Medication object representing the medication to be
    // assigned.
    // * @param patient The Patient object to whom the medication is being assigned.
    // * @throws IllegalArgumentException If the specified medication is already
    // assigned to the patient, if the medication is null, or if the patient is
    // null.
    // */
    // public void assignMedication(Medication medication, Patient patient) {
    // // Implementation details...
    // patient.addMedication(medication);
    // }

}

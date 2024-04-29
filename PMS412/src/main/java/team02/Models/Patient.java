package team02.Models;

import java.time.LocalDate;
import java.sql.Date;

public class Patient extends User {

    private LocalDate birthDate;
    private String sex;
    private double weightInPounds;
    private double heightInInches;

    // private ArrayList<Record> records;
    // private ArrayList<Medication> medications;

    public Patient(int userID, String name, String email, String phoneNumber, LocalDate birthDate, String sex,
            double weightInPounds, double heightInInches) {
        super(userID, name, email, phoneNumber);
        this.birthDate = birthDate;
        this.sex = sex;
        this.weightInPounds = weightInPounds;
        this.heightInInches = heightInInches;

        // // ID's automatically assigned by DB
        // dbIntegration db = dbIntegration.getInstance();
        // Date sqlDate = Date.valueOf(birthDate);
        // int patient_id = db.addPatient(name, email, phoneNumber, sqlDate, sex,
        // weightInPounds, heightInInches);
        // setUserID(patient_id);
    }

    /**
     * Retrieves the birth date of the person.
     *
     * @return The birth date of the person as a Date object.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the person.
     *
     * @param birthDate The new birth date to be set for the person.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        Date sqlDate = Date.valueOf(birthDate);
        dbIntegration db = dbIntegration.getInstance();
        db.updatePatient(getUserID(), getName(), getEmail(), getPhoneNumber(), sqlDate, sex, weightInPounds,
                heightInInches);
    }

    /**
     * Retrieves the sex of the person.
     *
     * @return The sex of the person as a String.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the sex of the person.
     *
     * @param sex The new sex to be set for the person.
     */
    public void setSex(String sex) {
        this.sex = sex;
        Date sqlDate = Date.valueOf(birthDate);
        dbIntegration db = dbIntegration.getInstance();
        db.updatePatient(getUserID(), getName(), getEmail(), getPhoneNumber(), sqlDate, sex, weightInPounds,
                heightInInches);
    }

    /**
     * Retrieves the weight of the person in pounds.
     *
     * @return The weight of the person in pounds as a double.
     */
    public double getWeightInPounds() {
        return weightInPounds;
    }

    /**
     * Sets the weight of the person in pounds.
     *
     * @param weightInPounds The new weight to be set for the person in pounds.
     */
    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
        Date sqlDate = Date.valueOf(birthDate);
        dbIntegration db = dbIntegration.getInstance();
        db.updatePatient(getUserID(), getName(), getEmail(), getPhoneNumber(), sqlDate, sex, weightInPounds,
                heightInInches);
    }

    /**
     * Retrieves the height of the person in feet.
     *
     * @return The height of the person in feet as a double.
     */
    public double getheightInInches() {
        return heightInInches;
    }

    /**
     * Sets the height of the person in feet.
     *
     * @param heightInInches The new height to be set for the person in feet.
     */
    public void setheightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
        Date sqlDate = Date.valueOf(birthDate);
        dbIntegration db = dbIntegration.getInstance();
        db.updatePatient(getUserID(), getName(), getEmail(), getPhoneNumber(), sqlDate, sex, weightInPounds,
                heightInInches);
    }

    // /**
    // * Retrieves a list of health records associated with the person.
    // *
    // * @return A List of health records for the person.
    // */

    // public List<Record> getRecords() {
    // return records;
    // }

    // /**
    // * Retrieves a list of medications associated with the patient.
    // *
    // * @return A List of Medication objects representing the medications
    // prescribed to the patient.
    // */
    // public List<Medication> getMedications() {
    // return medications;
    // }

    // /**
    // * Adds a new health record to the patient's list of records.
    // *
    // * @param record The health record to be added to the patient's records.
    // * @return a boolean representing whether the medication was successfully
    // added
    // */

    // public Boolean addRecord(Record record) {
    // // Implementation details...
    // records.add(record);
    // return true;
    // }

    // /**
    // * Adds a new medication to the patient's list of medications.
    // *
    // * @param medication The medication to be added to the patient's list of
    // medications.
    // * @return a boolean representing whether the medication was successfully
    // added
    // */

    // public Boolean addMedication(Medication medication) {
    // // Implementation details...
    // medications.add(medication);
    // return true;
    // }

}

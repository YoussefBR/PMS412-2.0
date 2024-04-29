package team02.Models;

import java.util.List;

public class Doctor extends Caregiver {

    private String specialty;
    private String department;
    private List<Patient> patients;

    public Doctor(int userID, String name, String email, String phoneNumber, String role, String specialty,
            String department) {
        super(userID, name, email, phoneNumber, role);
        assert (role.equals("doctor")); // Doctors must have the role of "doctor"
        this.department = department;
        this.specialty = specialty;
    }

    public Doctor(int userID, String name, String email, String phoneNumber, String role, String specialty,
            String department, List<Patient> patients) {
        super(userID, name, email, phoneNumber, role);
        assert (role.equals("doctor")); // Doctors must have the role of "doctor"
        this.department = department;
        this.specialty = specialty;
        this.patients = patients;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getDepartment() {
        return department;
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
     * @throws IllegalArgumentException If the patient is already assigned to the
     *                                  caregiver or if the patient is null.
     */

    public void assignPatient(Patient patient) {
        // Implementation details...
        patients.add(patient);
    }

    /**
     * Unassigns a patient from the caregiver, removing the patient from the
     * caregiver's client list.
     *
     * @param patient The patient to be unassigned from the caregiver.
     * @throws IllegalArgumentException If the patient is not currently assigned to
     *                                  the caregiver or if the patient is null.
     */
    public void unassignPatient(Patient patient) {
        // Implementation details...
        patients.remove(patient);
    }
}

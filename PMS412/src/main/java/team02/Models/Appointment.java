package team02.Models;

import java.time.LocalDateTime;

public class Appointment {
    private int appointmentId;
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime dateTime;

    public Appointment(int appointmentId, Doctor doctor, Patient patient, LocalDateTime dateTime) {
        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
    }

    // Getters and setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

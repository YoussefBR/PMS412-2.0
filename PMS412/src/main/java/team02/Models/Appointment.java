package Model;

import java.time.LocalDateTime;

public class Appointment {
    private int appointmentId;
    private int doctorId;
    private int patientId;
    private LocalDateTime dateTime;

    public Appointment(int appointmentId, int doctorId, int patientId, LocalDateTime dateTime) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.dateTime = dateTime;
    }

    // Getters and setters
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}


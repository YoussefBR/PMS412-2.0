package Controllers;

import team02.Models.Appointment;
import team02.Models.Doctor;
import team02.Models.Patient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentController {
    private List<Appointment> appointments;

    public AppointmentController() {
        this.appointments = new ArrayList<>();
    }

    private boolean isTimeValid(LocalDateTime dateTime) {
        return !dateTime.isBefore(LocalDateTime.now());
    }

    public void scheduleAppointment(int appointmentId, Doctor doctor, Patient patient, LocalDateTime dateTime) throws Exception {
        if (!isTimeValid(dateTime)) {
            throw new IllegalArgumentException("Appointment time must be in the future.");
        }
        Appointment newAppointment = new Appointment(appointmentId, doctor, patient, dateTime);
        appointments.add(newAppointment);
        doctor.assignPatient(patient);  // Assuming the assignment is part of scheduling an appointment
    }

    public void rescheduleAppointment(int appointmentId, LocalDateTime newDateTime) throws Exception {
        if (!isTimeValid(newDateTime)) {
            throw new IllegalArgumentException("Rescheduled time must be in the future.");
        }
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                appointment.setDateTime(newDateTime);
                break;
            }
        }
    }

    public void cancelAppointment(int appointmentId) {
        appointments.removeIf(appointment -> appointment.getAppointmentId() == appointmentId);
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }
}

package Controllers;

import Model.Appointment;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppointmentController {
    private ArrayList<Appointment> appointments;

    public AppointmentController() {
        this.appointments = new ArrayList<>();
    }

    public void scheduleAppointment(int appointmentId, int doctorId, int patientId, LocalDateTime dateTime) throws Exception {
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment time must be in the future.");
        }
        Appointment newAppointment = new Appointment(appointmentId, doctorId, patientId, dateTime);
        appointments.add(newAppointment);
    }

    public void rescheduleAppointment(int appointmentId, LocalDateTime newDateTime) throws Exception {
        if (newDateTime.isBefore(LocalDateTime.now())) {
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

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}

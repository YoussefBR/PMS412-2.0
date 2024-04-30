package team02;

import team02.Controllers.AppointmentController;
import team02.Models.Appointment;
import team02.Models.Doctor;
import team02.Models.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentControllerTest {

    private AppointmentController appointmentController;
    @Mock private Doctor doctor;
    @Mock private Patient patient;
    private LocalDateTime futureDate;
    private LocalDateTime pastDate;

    @BeforeEach
    void setUp() {
        // Initialize mocks and test instance
        MockitoAnnotations.openMocks(this);
        appointmentController = new AppointmentController();
        futureDate = LocalDateTime.now().plusDays(1); // A future date for valid scheduling.
        pastDate = LocalDateTime.now().minusDays(1); // A past date to test invalid scheduling.
    }

    @Test
    void testScheduleAppointment() throws Exception {
        appointmentController.scheduleAppointment(1, doctor, patient, futureDate);
        List<Appointment> appointments = appointmentController.getAppointments();
        assertEquals(1, appointments.size());
        assertEquals(futureDate, appointments.get(0).getDateTime());
    }

    @Test
    void testScheduleAppointmentWithPastDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentController.scheduleAppointment(1, doctor, patient, pastDate);
        });
        assertEquals("Appointment time must be in the future.", exception.getMessage());
    }

    @Test
    void testRescheduleAppointment() throws Exception {
        appointmentController.scheduleAppointment(1, doctor, patient, futureDate);
        LocalDateTime newFutureDate = futureDate.plusDays(1);
        appointmentController.rescheduleAppointment(1, newFutureDate);
        List<Appointment> appointments = appointmentController.getAppointments();
        assertEquals(newFutureDate, appointments.get(0).getDateTime());
    }

    @Test
    void testCancelAppointment() throws Exception {
        appointmentController.scheduleAppointment(1, doctor, patient, futureDate);
        appointmentController.cancelAppointment(1);
        List<Appointment> appointments = appointmentController.getAppointments();
        assertTrue(appointments.isEmpty());
    }
}

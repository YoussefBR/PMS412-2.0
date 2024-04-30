package team02;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import team02.Models.Appointment;
import team02.Models.Doctor;
import team02.Models.Patient;

import static org.mockito.MockitoAnnotations.openMocks;

class AppointmentTest {

    @Mock
    private Doctor doctor;

    @Mock
    private Patient patient;

    @Test
    void setUp() {
        openMocks(this);
    }

    @Test
    void testAppointmentDetails() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 4, 1, 14, 0);
        Appointment appointment = new Appointment(1, doctor, patient, dateTime);

        assertEquals(1, appointment.getAppointmentId());
        assertSame(doctor, appointment.getDoctor());
        assertSame(patient, appointment.getPatient());
        assertEquals(dateTime, appointment.g
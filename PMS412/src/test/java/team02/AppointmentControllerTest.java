package team02;

import team02.Controllers.AppointmentController;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentControllerTest {
    @Test
    public void testScheduleAppointment() throws Exception {
        AppointmentController controller = new AppointmentController();
        LocalDateTime appointmentTime = LocalDateTime.now().plusMinutes(10); // Ensure the appointment is in the future
        controller.scheduleAppointment(1, 101, 201, appointmentTime);
        assertFalse("List of appointments should not be empty", controller.getAppointments().isEmpty());
    }

    @Test
    public void testRescheduleAppointment() throws Exception {
        AppointmentController controller = new AppointmentController();
        LocalDateTime initialTime = LocalDateTime.now().plusDays(1);
        LocalDateTime newDateTime = initialTime.plusDays(1); // Ensure the rescheduled time is valid
        controller.scheduleAppointment(2, 102, 202, initialTime);
        controller.rescheduleAppointment(2, newDateTime);
        assertEquals("The rescheduled time should match the new date/time", newDateTime, controller.getAppointments().get(0).getDateTime());
    }

    @Test
    public void testCancelAppointment() throws Exception {
        AppointmentController controller = new AppointmentController();
        LocalDateTime appointmentTime = LocalDateTime.now().plusDays(1); // Ensure the appointment is in the future
        controller.scheduleAppointment(3, 103, 203, appointmentTime);
        controller.cancelAppointment(3);
        assertTrue("List of appointments should be empty after cancellation", controller.getAppointments().isEmpty());
    }
}

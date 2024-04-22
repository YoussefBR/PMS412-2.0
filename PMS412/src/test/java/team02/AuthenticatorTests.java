// package PMS412.src.test.java.team02;

// import Models.Authenticator;

// import java.util.GregorianCalendar;

// public class AuthenticatorTests {
//     public void test_add(){
//         // must run this test first, tests both adding and the exists function
//         String employee_id = "00000001";
//         assert Authenticator.employeeExists(employee_id) == false;
//         Authenticator.addNewEmployee(employee_id, "password");
//         assert Authenticator.employeeExists(employee_id) == true;

//         String patient_id = "000000000";
//         assert Authenticator.patientExists(patient_id) == false;
//         Authenticator.addNewPatient(patient_id, new GregorianCalendar(2002, 12, 01), "password");
//         assert Authenticator.patientExists(patient_id) == true;
//     }

//     public void test_change_pass(){
//         // depends on previous test being run first, tests both changing password and authentication functions.
//         String employee_id = "00000001";
//         String patient_id = "000000000";

//         assert Authenticator.AuthenticatorEmployee(employee_id, "password") == true;
//         assert Authenticator.AuthenticatorPatient(patient_id, new GregorianCalendar(2002, 12, 01), "password") == true;

//         Authenticator.changeEmployeePassword(employee_id, "password", "new_password");
//         Authenticator.changePatientPassword(patient_id, new GregorianCalendar(2002, 12, 01), "password", "new_password");

//         assert Authenticator.AuthenticatorEmployee(employee_id, "password") == false;
//         assert Authenticator.AuthenticatorPatient(patient_id, new GregorianCalendar(2002, 12, 01), "password") == false; 
//     }
// }

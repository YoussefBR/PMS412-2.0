// package PMS412.src.test.java.team02;

// import Models.Caregiver;
// import Models.Patient;
// import Models.Record;
// import Models.Medication;
// import java.util.ArrayList;

// public class UserManagementTest {

//     public static void testUserManagement() {
//         ArrayList<Record> patientRecords = new ArrayList<>();
//         ArrayList<Medication> patientMedications = new ArrayList<>();
//         ArrayList<Patient> caregiverPatients = new ArrayList<>();

//         // Creating sample patient and caregiver objects
//         Patient patient = new Patient(001, "johnsmith@gmail.com", "8144444444", "2000-01-01", "M", 160, 6, patientRecords, patientMedications);
//         Caregiver caregiver = new Caregiver(101, "janedoe@gmail.com", "9122122212", "General Medicine", caregiverPatients);

//         // Test Case 1: Assigning and Unassigning Patient
//         System.out.println("Test Case 1: Assigning and Unassigning Patient");
//         caregiver.assignPatient(patient);
//         if (caregiverPatients.contains(patient)) {
//             System.out.println("Test Passed: Patient assigned successfully");
//         } else {
//             System.out.println("Test Failed: Patient assignment failed");
//         }

//         caregiver.unassignPatient(patient);
//         if (!caregiverPatients.contains(patient)) {
//             System.out.println("Test Passed: Patient unassigned successfully");
//         } else {
//             System.out.println("Test Failed: Patient unassignment failed");
//         }

//         // Test Case 2: Adding Record
//         System.out.println("\nTest Case 2: Adding Record");
//         caregiver.assignPatient(patient);
//         Record record = new Record("Geisinger", "2024-02-28", "General Checkup",
//                 "Vitals normal, health is overall good, except for a small cold. Prescribing Mucinex for runny nose.");

//         caregiver.addRecord(record, patient);
//         if (patientRecords.contains(record)) {
//             System.out.println("Test Passed: Record added successfully");
//         } else {
//             System.out.println("Test Failed: Record addition failed");
//         }

//         // Test Case 3: Getting Latest Record
//         System.out.println("\nTest Case 3: Getting Latest Record");
//         String latestRecord = caregiver.getLatestRecord(patient);
//         if (latestRecord != null) {
//             System.out.println("Test Passed: Latest record retrieved successfully");
//         } else {
//             System.out.println("Test Failed: Latest record retrieval failed");
//         }
//     }
// }

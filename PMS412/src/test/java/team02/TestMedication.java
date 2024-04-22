// package PMS412.src.test.java.team02;

// import java.util.ArrayList;
// import java.util.List;
// import Models.*;

// public class TestMedication {

//     public void testMedication() {
//         // Create a list of patients
//         List<Patient> patients = new ArrayList<>();

//         // Create a Caregiver object for prescribing
//         Caregiver prescribingDoctor = new Caregiver(101, "Dr. Smith", "General Medicine", "janedoe@gmail.com", patients);

//         // Create a Medication object
//         Medication medication = new Medication("Aspirin", 100, "Twice a day",
//                 "2024-03-01", "2024-04-01", prescribingDoctor,
//                 "Take with water", false, true, "N/A");

//         // Test getter methods
//         System.out.println("Name: " + medication.getName());
//         System.out.println("Dosage: " + medication.getDosage());
//         System.out.println("Frequency: " + medication.getFrequency());
//         System.out.println("Prescription Date: " + medication.getPrescriptionDate());
//         System.out.println("Expiration Date: " + medication.getExpirationDate());
//         System.out.println("Prescribing Doctor: " + medication.getPrescribingDoctor());
//         System.out.println("Instructions: " + medication.getInstructions());
//         System.out.println("Is Over The Counter: " + medication.isOverTheCounter());
//         System.out.println("Is Generic: " + medication.isGeneric());
//         System.out.println("Notes: " + medication.getNotes());

//         // Test setter methods
//         medication.setName("Tylenol");
//         medication.setDosage(200);
//         medication.setFrequency("Three times a day");
//         medication.setPrescriptionDate("2024-03-15");
//         medication.setExpirationDate("2024-05-01");
//         medication.setPrescribingDoctor(new Caregiver(102, "Dr. Johnson", "Internal Medicine", "johndoe@gmail.com", patients));
//         medication.setInstructions("Take after meals");

//         // Display updated medication information
//         System.out.println("\nUpdated Medication Information:");
//         System.out.println("Name: " + medication.getName());
//         System.out.println("Dosage: " + medication.getDosage());
//         System.out.println("Frequency: " + medication.getFrequency());
//         System.out.println("Prescription Date: " + medication.getPrescriptionDate());
//         System.out.println("Expiration Date: " + medication.getExpirationDate());
//         System.out.println("Prescribing Doctor: " + medication.getPrescribingDoctor());
//         System.out.println("Instructions: " + medication.getInstructions());
//         System.out.println("Is Over The Counter: " + medication.isOverTheCounter());
//         System.out.println("Is Generic: " + medication.isGeneric());
//         System.out.println("Notes: " + medication.getNotes());

//         // Test additional medication interaction methods
//         // Assuming you have implemented these methods in the Medication class
//         medication.takeMedication();
//         medication.refillMedication();
//         medication.checkExpiration();
//     }
// }

// package PMS412.src.test.java.team02;

// import java.util.ArrayList;

// public class caregiverinfotest {
//     public static void main(String[] args) {

//         ArrayList<Record> patient1records = new ArrayList<>();
//         ArrayList<Models.Medication> patient1meds = new ArrayList<>();

//         ArrayList<Models.Patient> caregiver1Patients = new ArrayList<>();

//         Models.Caregiver caregiver1 = new Models.Caregiver(101, "janedoe@gmail.com", "9122122212", "General Medicine", caregiver1Patients);
        
//         Models.Patient patient1 = new Models.Patient(001, "johnsmith@gmail.com", "8144444444", "2000-01-01", "M", 160, 6, patient1records, patient1meds);

//         PMS412.src.main.java.team02.Views.CaregiverInfoView view = new PMS412.src.main.java.team02.Views.CaregiverInfoView();
//         Controllers.CaregiverInfoController controller = new Controllers.CaregiverInfoController(caregiver1, view);
//         view.setVisible(true);

//     }

//     public void test_something(){
//         ArrayList<Record> patient1records = new ArrayList<>();
//         ArrayList<Medication> patient1meds = new ArrayList<>();

//         ArrayList<Patient> caregiver1Patients = new ArrayList<>();
//         Patient patient1 = new Patient(001, "johnsmith@gmail.com", "8144444444", "2000-01-01", "M", 160, 6, patient1records, patient1meds);

//         Caregiver caregiver1 = new Caregiver(101, "janedoe@gmail.com", "9122122212", "General Medicine", caregiver1Patients);
//         //authenticate

//         caregiver1.assignPatient(patient1);
//         System.out.println("Caregiver 1's patient list: " + caregiver1Patients);

//         caregiver1.unassignPatient(patient1);
//         System.out.println("Caregiver 1's patient list: " + caregiver1Patients);

//         caregiver1.assignPatient(patient1);

//         Record record1 = new Record("Geisinger", "2024-02-28", "General Checkup",
//                 "Vitals normal, health is overall good, except for a small cold. Prescribing Mucinex for runny nose.");

//         caregiver1.addRecord(record1, patient1);
//         System.out.println(patient1.getRecords());

//         caregiver1.getLatestRecord(patient1);

//         Medication med1 = new Medication("Mucinex", 10, "Twice a day", "2024-02-28",
//                 "2024-03-07", caregiver1, "Take once before breakfast and once before bed",
//                 true, true, "N/A");

//         caregiver1.assignMedication(med1, patient1);
//         System.out.println(patient1meds);
//     }
// }

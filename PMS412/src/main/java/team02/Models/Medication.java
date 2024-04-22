package team02.Models;

public class Medication {
    private String name;
    private double dosage;
    private String frequency;
    private String prescriptionDate;
    private String expirationDate;
    private Caregiver prescribingDoctor;
    private String instructions;
    private boolean isOverTheCounter;
    private boolean isGeneric;
    private String notes;

    public Medication(String name, double dosage, String frequency, String prescriptionDate, String expirationDate,
                      Caregiver prescribingDoctor, String instructions, boolean isOverTheCounter,
                      boolean isGeneric, String notes) {
        this.name = name;
        this.dosage = dosage;
        this.frequency = frequency;
        this.prescriptionDate = prescriptionDate;
        this.expirationDate = expirationDate;
        this.prescribingDoctor = prescribingDoctor;
        this.instructions = instructions;
        this.isOverTheCounter = isOverTheCounter;
        this.isGeneric = isGeneric;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Caregiver getPrescribingDoctor() {
        return prescribingDoctor;
    }

    public void setPrescribingDoctor(Caregiver prescribingDoctor) {
        this.prescribingDoctor = prescribingDoctor;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isOverTheCounter() {
        return isOverTheCounter;
    }

    public void setOverTheCounter(boolean overTheCounter) {
        isOverTheCounter = overTheCounter;
    }

    public boolean isGeneric() {
        return isGeneric;
    }

    public void setGeneric(boolean generic) {
        isGeneric = generic;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Stub method for medication interaction
    public void takeMedication() {
        System.out.println("Taking medication: " + name);
        // Placeholder logic for taking medication
    }

    // Stub method for medication interaction
    public void refillMedication() {
        System.out.println("Refilling medication: " + name);
        // Placeholder logic for refilling medication
    }

    // Stub method for medication interaction
    public void checkExpiration() {
        System.out.println("Checking expiration for medication: " + name);
        // Placeholder logic for checking medication expiration
    }
}

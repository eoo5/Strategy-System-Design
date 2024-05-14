// EncryptionStrategy interface
interface EncryptionStrategy {
    String encryptData(String data);
}

// AESEncryptionStrategy class
class AESEncryptionStrategy implements EncryptionStrategy {
    @Override
    public String encryptData(String data) {
        // Mock implementation for AES encryption
        return "AES Encrypted" + data;
    }
}

// DESEncryptionStrategy class
class DESEncryptionStrategy implements EncryptionStrategy {
    @Override
    public String encryptData(String data) {
        // Mock implementation for DES encryption
        return "[DES Encrypted] " + data;
    }
}

// BlowFishEncryptionStrategy class
class BlowFishEncryptionStrategy implements EncryptionStrategy {
    @Override
    public String encryptData(String data) {
        // Mock implementation for BlowFish encryption
        return "[BlowFish Encrypted] " + data;
    }
}

// DataEntryContext class
class DataEntryContext {
    private EncryptionStrategy encryptionStrategy;

    public void setEncryptionStrategy(EncryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }

    public String encryptData(String data) {
        if (encryptionStrategy == null) {
            throw new IllegalStateException("Encryption strategy is not set.");
        }
        return encryptionStrategy.encryptData(data);
    }
}

// Main class to showcase the pattern
public class Strategy {
    public static void main(String[] args) {
        // Create context
        DataEntryContext context = new DataEntryContext();

        // Set encryption strategy for patient data
        context.setEncryptionStrategy(new AESEncryptionStrategy());
        String patientData = context.encryptData("Patient data...");
        System.out.println("Encrypted patient data: " + patientData);

        // Set encryption strategy for physician notes
        context.setEncryptionStrategy(new DESEncryptionStrategy());
        String physicianNotes = context.encryptData("Physician notes...");
        System.out.println("Encrypted physician notes: " + physicianNotes);

        // Set encryption strategy for appointment schedule
        context.setEncryptionStrategy(new BlowFishEncryptionStrategy());
        String appointmentSchedule = context.encryptData("Appointment schedule...");
        System.out.println("Encrypted appointment schedule: " + appointmentSchedule);
    }
}

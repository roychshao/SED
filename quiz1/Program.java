public class Program {
    private Database database;
    private Device device;
    private NursesStation nursesStation;
    private int factorPtr;

    public Program(Database db, Device d, NursesStation ns) {
        database = db;
        device = d;
        nursesStation = ns;
        factorPtr = 0;
    }

    public Database getDatabase() {
        return database;
    }

    public Device getDevice() {
        return device;
    }

    public void readFactor(int milisecond) {
        Patient p = device.getPatient();
        int frequency = p.getFrequency();
        if (milisecond % frequency == 0) {
            float factor = device.measure(factorPtr);
            factorPtr++;
            database.store(device, milisecond, factor);
            // WARN: in statement, safeRange should be the attribute of a patient, but we
            // have to make it be the attribute of a device can we fulfill the requirement
            // spec.
            if (factor < device.getSafeLowerbound() || factor > device.getSafeUpperbound() || factor == -1.0) {
                nursesStation.display(milisecond, device, factor);
            }
        }
    }
}

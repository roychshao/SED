import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Device {
    private String name;
    private String sensorKind;
    private Patient patient;
    private String factorDataFileName;
    private float safeLowerbound;
    private float safeUpperbound;

    private List<Float> factors = new ArrayList<>();

    public Device(String n, String sk, Patient p, String f, float slb, float sub) {
        name = n;
        sensorKind = sk;
        patient = p;
        factorDataFileName = f;
        safeLowerbound = slb;
        safeUpperbound = sub;
        readFactors();
    }

    public String getSensorKind() {
        return sensorKind;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getName() {
        return name;
    }

    public float getSafeLowerbound() {
        return safeLowerbound;
    }

    public float getSafeUpperbound() {
        return safeUpperbound;
    }

    public float measure(int factorPtr) {
        return factorPtr >= factors.size() ? (float) -1.0 : factors.get(factorPtr);
    }

    public void readFactors() {
        File factorFile = new File(factorDataFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(factorFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                factors.add(Float.parseFloat(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Read error");
        }
    }

}

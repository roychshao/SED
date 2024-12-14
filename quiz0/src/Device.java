import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

class Device {
    private String category;
    private String name;
    private String factorDataFileName;
    private float safeRangeLowerBound;
    private float safeRangeUpperBound;
    private List<Float> factors = new ArrayList<>();
    private int factorPtr = 0;
    private List<String> database = new ArrayList<>();

    public Device(String category, String name, String f, float l, float u) {
        this.category = category;
        this.name = name;
        this.factorDataFileName = f;
        this.safeRangeLowerBound = l;
        this.safeRangeUpperBound = u;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getFactorDataFileName() {
        return factorDataFileName;
    }

    public float getSafeRangeLowerBound() {
        return safeRangeLowerBound;
    }

    public float getSafeRangeUpperBound() {
        return safeRangeUpperBound;
    }

    public float readFactor(float milisecond) {
        if (factors.size() == 0) {
            readFactors();
            float factor = factors.get(factorPtr);
            String dataItem = "[" + (int) milisecond + "] " + String.valueOf(factor);
            addDatabase(dataItem);
            factorPtr++;
            if (factor < 0) {
                return -1;
            } else if (factor >= safeRangeLowerBound && factor <= safeRangeUpperBound) {
                return 0;
            } else {
                return factor;
            }
        }

        if (factorPtr >= factors.size()) {
            String dataItem = "[" + (int) milisecond + "] " + String.valueOf(-1.0);
            addDatabase(dataItem);
            return -1;
        }

        float factor = factors.get(factorPtr);
        String dataItem = "[" + (int) milisecond + "] " + String.valueOf(factor);
        addDatabase(dataItem);
        factorPtr++;
        if (factor < 0) {
            return -1;
        } else if (factor >= safeRangeLowerBound && factor <= safeRangeUpperBound) {
            return 0;
        } else {
            return factor;
        }
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

    public void addDatabase(String s) {
        database.add(s);
    }

    public List<String> getDatabase() {
        return database;
    }
}

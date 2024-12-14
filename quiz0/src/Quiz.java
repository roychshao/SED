import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;

class Quiz {

    public static void main(String[] args) {
        try {
            // read data
            File fakeDataFile = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

            String line = reader.readLine();
            float monitorPeriod = Float.parseFloat(line);

            Patient patient = null;
            List<Patient> patients = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] arrOfStr = line.split(" ");
                if (arrOfStr[0].equals("patient") && arrOfStr.length == 3) {
                    String name = arrOfStr[1];
                    float period = 0;
                    try {
                        period = Float.parseFloat(arrOfStr[2]);
                        patient = new Patient(name, period);
                        patients.add(patient);
                    } catch (NumberFormatException e) {
                        System.out.println("Input Error");
                    }
                } else if ((arrOfStr[0].equals("BloodPressureSensor") || arrOfStr[0].equals("PulseSensor")
                        || arrOfStr[0].equals("TemperatureSensor")) && arrOfStr.length == 5) {
                    String category = arrOfStr[0];
                    String deviceName = arrOfStr[1];
                    String factorDataFileName = arrOfStr[2];

                    // check if the factorDataFileName is valid
                    try {
                        File factorDataFile = new File("../Testcase/" + factorDataFileName);
                        BufferedReader tempReader = new BufferedReader(new FileReader(factorDataFile));
                        tempReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Input Error");
                        continue;
                    }

                    // check if the string number is parsible
                    float lowerbound = 0;
                    try {
                        lowerbound = Float.parseFloat(arrOfStr[3]);
                    } catch (NumberFormatException e) {
                        System.out.println("Input Error");
                        continue;
                    }
                    float upperbound = 0;
                    try {
                        upperbound = Float.parseFloat(arrOfStr[4]);
                    } catch (NumberFormatException e) {
                        System.out.println("Input Error");
                        continue;
                    }

                    Device device = new Device(category, deviceName, "../Testcase/" + factorDataFileName, lowerbound,
                            upperbound);
                    patient.addDevice(device);
                } else {
                    System.out.println("Input Error");
                }
            }

            reader.close();

            // start monitoring
            monitoring(patients, monitorPeriod);

            // print database
            for (Patient p : patients) {
                System.out.println("patient " + p.getName());
                for (Device d : p.getDevices()) {
                    System.out.println(d.getCategory() + " " + d.getName());
                    for (String s : d.getDatabase()) {
                        System.out.println(s);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input Error");
        } catch (IOException e) {
            System.out.println("Input Error");
        } catch (NumberFormatException e) {
            System.out.println("Input Error");
        }
    }

    public static void monitoring(List<Patient> patients, float monitorPeriod) {
        for (float milisecond = 0; milisecond <= monitorPeriod; ++milisecond) {
            for (Patient p : patients) {
                if (milisecond % p.getPeriod() == 0) {
                    for (Device d : p.getDevices()) {
                        float factor = d.readFactor(milisecond);
                        if (factor == -1.0) {
                            System.out.printf("[%.0f] %s fails%n", milisecond, d.getName());
                        } else if (factor != -1.0 && factor != 0.0) {
                            System.out.printf("[%.0f] %s is in danger! ", milisecond, p.getName());
                            System.out.printf("Cause: %s %.1f%n", d.getName(), (float) factor);
                        }
                    }
                }
            }
        }
    }
}

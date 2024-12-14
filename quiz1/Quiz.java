import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Quiz {

    public static void main(String[] args) {
        try {
            File fakeDataFile = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
            String line = reader.readLine();
            float monitorPeriod = Float.parseFloat(line);
            Database db = new Database();
            NursesStation ns = new NursesStation();

            Patient patient = null;
            List<Patient> patients = new ArrayList<>();
            List<Device> devices = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] arrOfStr = line.split(" ");
                if (arrOfStr[0].equals("patient") && arrOfStr.length == 3) {
                    String name = arrOfStr[1];
                    int frequency = 0;
                    try {
                        frequency = Integer.parseInt(arrOfStr[2]);
                        patient = new Patient(name, frequency, 0, 0);
                        patients.add(patient);
                    } catch (NumberFormatException e) {
                        System.out.println("Input Error");
                        continue;
                    }
                } else if ((arrOfStr[0].equals("BloodPressureSensor") || arrOfStr[0].equals("PulseSensor")
                        || arrOfStr[0].equals("TemperatureSensor")) && arrOfStr.length == 5) {
                    String sensorKind = arrOfStr[0];
                    String deviceName = arrOfStr[1];
                    String factorDataFileName = arrOfStr[2];

                    float lowerbound = 0;
                    try {
                        lowerbound = Float.parseFloat(arrOfStr[3]);
                        float upperbound = 0;
                        try {
                            upperbound = Float.parseFloat(arrOfStr[4]);
                            patient.setSafeLowerbound(lowerbound);
                            patient.setSafeUpperbound(upperbound);
                            Device device = new Device(deviceName, sensorKind, patient, factorDataFileName, lowerbound,
                                    upperbound);
                            devices.add(device);
                            patient.addDevice(device);
                        } catch (NumberFormatException e) {
                            System.out.println("Input Error");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input Error");
                        continue;
                    }
                } else {
                    System.out.println("Input Error");
                }
            }
            reader.close();

            List<Program> programs = new ArrayList<>();
            for (int i = 0; i < devices.size(); i++) {
                Program program = new Program(db, devices.get(i), ns);
                programs.add(program);
            }

            for (int i = 0; i <= monitorPeriod; ++i) {
                for (Program p : programs) {
                    p.readFactor(i);
                }
            }

            db.showData(patients);

        } catch (FileNotFoundException e) {
            System.out.println("Input Error");
        } catch (IOException e) {
            System.out.println("Input Error");
        } catch (NumberFormatException e) {
            System.out.println("Input Error");
        }
    }
}

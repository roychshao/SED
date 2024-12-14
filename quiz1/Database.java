import java.util.*;

public class Database {
    private HashMap<String, List<String>> data;

    public Database() {
        data = new HashMap<>();
    }

    public void store(Device d, int m, float f) {
        String key = d.getName();
        String newData = "[" + m + "] " + f;

        if (data.containsKey(key)) {
            data.get(key).add(newData);
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(d.getSensorKind() + " " + key);
            newList.add(newData);
            data.put(key, newList);
        }
    }

    public void showData(List<Patient> patients) {
        for (Patient p : patients) {
            System.out.println("patient " + p.getName());
            for (Device device : p.getDevices()) {
                String key = device.getName();
                if (data.containsKey(key)) {
                    for (String value : data.get(key)) {
                        System.out.println(value);
                    }
                }
            }
        }
    }
}

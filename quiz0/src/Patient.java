import java.util.*;

class Patient {
    private String name;
    private float period;
    private List<Device> devices = new ArrayList<>();

    public Patient(String name, float period) {
        this.name = name;
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public float getPeriod() {
        return period;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public List<Device> getDevices() {
        return devices;
    }
}

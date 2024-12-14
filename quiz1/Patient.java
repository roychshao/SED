import java.util.*;

public class Patient {
    private String name;
    private int frequency;
    private float safeLowerbound;
    private float safeUpperbound;
    // WARN: If Patient class doesn't hold the references of Device class, then the
    // print database requirement can not be met.
    private List<Device> devices;

    public Patient(String n, int f, float sfb, float sub) {
        name = n;
        frequency = f;
        safeLowerbound = sfb;
        safeUpperbound = sub;
        devices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public float getSafeLowerbound() {
        return safeLowerbound;
    }

    public float getSafeUpperbound() {
        return safeUpperbound;
    }

    public void setSafeLowerbound(float sfb) {
        safeLowerbound = sfb;
    }

    public void setSafeUpperbound(float sub) {
        safeUpperbound = sub;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device d) {
        devices.add(d);
    }
}

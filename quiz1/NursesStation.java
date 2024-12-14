public class NursesStation {

    public NursesStation() {
    };

    public void display(int milisecond, Device d, float f) {
        if (f == -1.0) {
            System.out.println("[" + milisecond + "] " + d.getName() + " fails");
        } else {
            System.out.println("[" + milisecond + "] " + d.getPatient().getName() + " is in danger! Cause: "
                    + d.getName() + " " + f);
        }
    }
}

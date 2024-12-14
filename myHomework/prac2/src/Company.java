import java.util.HashMap;

public class Company {
    private String name;
    private String address;
    private String phoneNumber;
    private Product primaryProduct;
    private List<Person> employees;
    private HashMap<String, Department> departments;

    public Company(String n, String a, String p, Product pp, List<Person> e, HashMap<String, Department> d) {
        name = n;
        address = a;
        phoneNumber = p;
        primaryProduct = pp;
        employees = e;
        departments = d;
    }

    public String getName() {
        return name;
    }

    public String address() {
        return address;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public HashMap<String, Department> getDepartments() {
        return departments;
    }
}

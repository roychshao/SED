public class Person {
    private String name;
    private String address;
    private String SSN;
    private List<Company> companies;

    public Person(String n, String a, String s, List<Company> c) {
        this.name = n;
        this.address = a;
        this.SSN = s;
        this.companies = c;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSSN() {
        return SSN;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}

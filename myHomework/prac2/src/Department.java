public class Department {
    private String name;
    private Manager manager;
    private List<Product> products;

    public Department(String n, Manager m, List<Product> p) {
        name = n;
        manager = m;
        products = p;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Product> getProducts() {
        return products;
    }
}

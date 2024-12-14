public class Product {
    private String name;
    private int cost;
    private int weight;

    public Product(String n, int c, int w) {
        name = n;
        cost = c;
        weight = w;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }
}

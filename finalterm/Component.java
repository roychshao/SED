public class Component {

  protected String type;
  protected String name;
  protected double power;
  protected double cost;

  public Component(String type, String name, double power, double cost) {
    this.type = type;
    this.name = name;
    this.power = power;
    this.cost = cost;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public double getPower() {
    return power;
  }

  public double getCost() {
    return cost;
  }

  public void print() {
    // do nothing
  }
}

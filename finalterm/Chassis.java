import java.util.*;

public class Chassis extends Component {

  private List<Component> components;

  public Chassis(String type, String name, double power, double cost) {
    super(type, name, power, cost);
    this.components = new ArrayList<>();
  }

  public List<Component> getComponents() {
    return components;
  }

  public void addComponent(Component c) {
    components.add(c);
  }

  public ChassisIterator getIterator() {
    return new ChassisIterator(this); 
  }

  public double getSumPower() {
    double sum = power;
    for (Component c : components) {
      sum += c.getPower();
    }
    return sum;
  }

  public double getSumCost() {
    double sum = cost;
    for (Component c : components) {
      sum += c.getCost();
    }
    return sum;
  }

  public void print() {
    System.out.println(name + " (" + power + ", " + cost + ")");
    ChassisIterator it = getIterator();
    while (it.hasNext()) {
      Component c = it.next();
      System.out.println(name + ":" + c.getName() + " (" + c.getPower() + ", " + c.getCost() + ")");
    }
  }
}

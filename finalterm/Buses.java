public class Buses extends Component {

  public Buses(String type, String name, double power, double cost) {
    super(type, name, power, cost);
  }

  public void print() {
    System.out.println(name + " (" + power + ", " + cost + ")");
  }
}

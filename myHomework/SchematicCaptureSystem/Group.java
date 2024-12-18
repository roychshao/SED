import java.util.*;

public class Group extends BasicComponent {

  private List<BasicComponent> components;


  public Group() {
    super("Group");
    components = new ArrayList<>();
  }

  public List<BasicComponent> getComponents() {
    return components;
  }

  public void addComponent(BasicComponent b) {
    components.add(b);
  }

  public void print() {
    System.out.print("Group:{");
    for (BasicComponent b : components) {
      b.print();
    }
    System.out.print("} ");
  }
}

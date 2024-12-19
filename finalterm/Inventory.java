import java.util.*;

public class Inventory {

  private List<Component> components;

  public Inventory() {
    this.components = new ArrayList<>();
  }

  public List<Component> getComponents() {
    return components;
  }

  public void addComponent(Component c) {
    components.add(c);
  }

  public boolean hasChassis(String name) {
    for (Component c : components) {
      if (c.getType().equals("chassis")) {
        if (c.getName().equals(name)) {
          return true;
        }
      }
    }
    return false;
  }

  public Chassis getChassis(String name) {
    for (Component c : components) {
      if (c.getName().equals(name)) {
        if (c.getType().equals("chassis")) {
          Chassis targetChassis = (Chassis) c;
          return targetChassis;
        }
      }
    }
    return null;
  }

  public Component getChassisComponent(String name, String componentName) {
    Chassis chassis = getChassis(name);
    if (chassis != null) {
      AbstractIterator it = chassis.getIterator();
      while (it.hasNext()) {
        Component c = it.next();
        if (c.getName().equals(componentName)) {
          return c;
        }
      }
    }
    return null;
  }
}

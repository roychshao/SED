import java.util.*;

public class Composition {
  private ComposeAlgorithm strategy;
  private List<Component> components = new ArrayList<Component>();

  public ComposeAlgorithm getStrategy() {
    return strategy;
  }

  public void setStrategy(ComposeAlgorithm strategy) {
    this.strategy = strategy;
  }

  public List<Component> getComponents() {
    return components;
  }

  public void setComponents(List<Component> components) {
    this.components = components;
  }

  public void compose() {
    this.strategy.compose(this.components);
  }

  public void changeSize(String componentID, int newSize) {
    for (Component component : components) {
      if (component.getComponentID().equals(componentID)) {
        component.setNaturalSize(newSize);
      }
    }
  }
}

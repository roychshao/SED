import java.util.List;

public class SimpleComposition implements ComposeAlgorithm {
  public void compose(List<Component> components) {
    for (Component c : components) {
      System.out.printf("[%d]%s\n", c.getNaturalSize(), c.getContent());
    }
  }
}

import java.util.List;

public class ArrayComposition implements ComposeAlgorithm {
  public void compose(List<Component> components) {
    for (int i = 0; i < components.size(); ++i) {
      if (i % 3 == 0 && i != 0) System.out.printf("\n");
      if (i == components.size() - 1) {
        System.out.printf(
            "[%d]%s\n", components.get(i).getNaturalSize(), components.get(i).getContent());
      } else {
        System.out.printf(
            "[%d]%s ", components.get(i).getNaturalSize(), components.get(i).getContent());
      }
    }
  }
}

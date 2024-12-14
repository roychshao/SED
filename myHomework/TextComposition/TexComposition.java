import java.util.List;

public class TexComposition implements ComposeAlgorithm {
  public void compose(List<Component> components) {
    for (Component c : components) {
      if (c.getContent().equals("<ParagraphEnd>")) {
        System.out.printf("[%d]%s\n", c.getNaturalSize(), c.getContent());
      } else System.out.printf("[%d]%s ", c.getNaturalSize(), c.getContent());
    }
  }
}

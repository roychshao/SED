public class PMWidgetFactory {

  public Window createWindow(String name) {
    return new PMWindow(name);
  }

  public Scrollbar createScrollbar(String name) {
    return new PMScrollbar(name);
  }

  public Button createButton(String name) {
    return new PMButton(name);
  }
}

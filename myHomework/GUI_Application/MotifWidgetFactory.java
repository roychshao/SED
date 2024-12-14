public class MotifWidgetFactory {

  public Window createWindow(String name) {
    return new MotifWindow(name);
  }

  public Scrollbar createScrollbar(String name) {
    return new MotifScrollbar(name);
  }

  public Button createButton(String name) {
    return new MotifButton(name);
  }
}

public interface WidgetFactory {
  
  public Window createWindow(String name);

  public Scrollbar createScrollbar(String name);

  public Button createButton(String name);
}

public abstract class Window {

  private String name;
  private String style;

  public Window(String name, String style) {
    this.name = name;
    this.style = style;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }
}

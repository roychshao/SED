public class Window {

  private WindowImpl impl;

  public Window(WindowImpl impl) {
    this.impl = impl;
  }

  public void drawText() {
    impl.drawText();
  }

  public void drawRect() {
    impl.drawRect();
  }
}

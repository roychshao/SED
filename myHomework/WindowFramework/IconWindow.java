public class IconWindow extends Window {

  public IconWindow(WindowImpl impl) {
    super(impl);
  }

  public void drawBorder() {
    drawRect();
    drawText();
  }
}

public class FanHandler extends Handler {

  public FanHandler() {}

  public FanHandler(Handler successor) {
    super(successor);
  }

  public void handleMail(Email e) {
    if (isResponse(e)) {
      System.out.println("Forward to CEO.");
    } else {
      super.handleMail(e);
    }
  }

  public boolean isResponse(Email e) {
    return e.getType().equals("FAN");
  }
}

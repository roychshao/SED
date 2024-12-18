public class SpamHandler extends Handler {

  public SpamHandler(Handler successor) {
    super(successor);
  }

  public void handleMail(Email e) {
    if (isResponse(e)) {
      System.out.println("Put mail to the spam box.");
    } else {
      super.handleMail(e);
    }
  }

  public boolean isResponse(Email e) {
    return e.getType().equals("SPAM");
  }
}

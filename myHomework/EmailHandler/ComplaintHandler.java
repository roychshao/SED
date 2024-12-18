public class ComplaintHandler extends Handler {

  public ComplaintHandler(Handler successor) {
    super(successor);
  }

  public void handleMail(Email e) {
    if (isResponse(e)) {
      System.out.println("Forward to legal department.");
    } else {
      super.handleMail(e);
    }
  }

  public boolean isResponse(Email e) {
    return e.getType().equals("COMPLAINT");
  }
}

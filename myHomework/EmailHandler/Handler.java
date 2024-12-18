public abstract class Handler {

  private Handler successor;

  public Handler() {}

  public Handler(Handler successor) {
    this.successor = successor;
  }

  public void handleMail(Email e) {
    if (successor != null) {
      successor.handleMail(e);
    }
  }

  public boolean isResponse(Email e) {
    return true;
  }
}

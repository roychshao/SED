public class Silent implements QuackBehavior {
  public void quack(Duck duck) {
    duck.setQuackBehavior(new Silent());
  }

  public String getQuack() {
    return "slient";
  }
}

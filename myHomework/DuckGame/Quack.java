public class Quack implements QuackBehavior {
  public void quack(Duck duck) {
    duck.setQuackBehavior(new Quack());
  }

  public String getQuack() {
    return "quack";
  }
}

public class Squeak implements QuackBehavior {
  public void quack(Duck duck) {
    duck.setQuackBehavior(new Squeak());
  }

  public String getQuack() {
    return "squeak";
  }
}

public class NoFly implements FlyBehavior {
  public void fly(Duck duck) {
    System.out.println("[Behavior Invalid] " + duck.getType() + " can not fly.");
  }
}

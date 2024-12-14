public class RedheadDuck extends Duck {

  public RedheadDuck(String type, FlyBehavior fb) {
    this.type = type;
    this.flyBehavior = fb;
    this.quackBehavior = new Silent();
    this.flying = false;
  }

  public void display() {
    if (flying) {
      System.out.printf("%s : fly / %s\n", type, quackBehavior.getQuack());
    } else {
      System.out.printf("%s : swim / %s\n", type, quackBehavior.getQuack());
    }
  }
}

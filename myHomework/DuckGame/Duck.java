public abstract class Duck {

  protected String type;
  protected boolean flying;
  protected FlyBehavior flyBehavior;
  protected QuackBehavior quackBehavior;

  public void Swim() {
    setFlying(false);
  }

  public void setFlying(boolean f) {
    this.flying = f;
  }

  public void display() {
  };

  public void setFlyBehavior(FlyBehavior fb) {
    this.flyBehavior = fb;
  }

  public void setQuackBehavior(QuackBehavior qb) {
    this.quackBehavior = qb;
  }

  public String getType() {
    return type;
  }

  public boolean getFlying() {
    return flying;
  }

  public FlyBehavior getFlyBehavior() {
    return flyBehavior;
  }

  public QuackBehavior getQuaBehavior() {
    return quackBehavior;
  }
}

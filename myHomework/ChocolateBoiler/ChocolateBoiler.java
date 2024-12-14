public class ChocolateBoiler {

  private boolean empty = true;
  private boolean boiled;
  private static ChocolateBoiler instance;

  private ChocolateBoiler() {};

  public static ChocolateBoiler getInstance() {
    if (instance == null) {
      synchronized (ChocolateBoiler.class) {
        if (instance == null) {
          instance = new ChocolateBoiler();
        }
      }
    }
    return instance;
  }

  public void boil() {
    if (!empty && !boiled) {
      System.out.println("Boil chocolate");
      boiled = true;
    }
  }

  public void fill() {
    if (empty) {
      System.out.println("Fill chocolate");
      empty = false;
    }
  }

  public void drain() {
    if (!empty && boiled) {
      System.out.println("Drain the boiled chocolate");
      boiled = false;
      empty = true;
    }
  }
}

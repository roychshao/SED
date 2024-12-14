import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      String line;
      List<Duck> ducks = new ArrayList<Duck>();
      while ((line = reader.readLine()) != null) {
        String[] arrOfStr = line.split(" ");
        String command = arrOfStr[0];
        if (command.equals("Duck")) {
          String duckType = arrOfStr[1];
          String canFly = arrOfStr[2];
          if (duckType.equals("MallardDuck")) {
            if (canFly.equals("true")) {
              Duck duck = new MallardDuck(duckType, new SimpleFly());
              ducks.add(duck);
            } else {
              Duck duck = new MallardDuck(duckType, new NoFly());
              ducks.add(duck);
            }
          } else if (duckType.equals("RedheadDuck")) {
            if (canFly.equals("true")) {
              Duck duck = new RedheadDuck(duckType, new SimpleFly());
              ducks.add(duck);
            } else {
              Duck duck = new RedheadDuck(duckType, new NoFly());
              ducks.add(duck);
            }
          } else if (duckType.equals("RubberDuck")) {
            if (canFly.equals("true")) {
              Duck duck = new RubberDuck(duckType, new SimpleFly());
              ducks.add(duck);
            } else {
              Duck duck = new RubberDuck(duckType, new NoFly());
              ducks.add(duck);
            }
          } else if (duckType.equals("DecoyDuck")) {
            if (canFly.equals("true")) {
              Duck duck = new DecoyDuck(duckType, new SimpleFly());
              ducks.add(duck);
            } else {
              Duck duck = new DecoyDuck(duckType, new NoFly());
              ducks.add(duck);
            }
          }
        } else if (command.equals("DynamicBehave")) {
          String duckType = arrOfStr[1];
          String action = arrOfStr[2];
          for (Duck d : ducks) {
            if (d.getType().equals(duckType)) {
              if (action.equals("swim")) {
                d.setFlying(false);
              } else if (action.equals("fly")){
                d.getFlyBehavior().fly(d);
              }
            }
          }
        } else if (command.equals("StaticBehave")) {
          String duckType = arrOfStr[1];
          String action = arrOfStr[2];
          for (Duck d : ducks) {
            if (d.getType().equals(duckType)) {
              if (action.equals("quack")) {
                d.setQuackBehavior(new Quack());
              } else if (action.equals("silent")) {
                d.setQuackBehavior(new Silent());
              } else if (action.equals("squeak")) {
                d.setQuackBehavior(new Squeak());
              }
            }
          }
        } else if (command.equals("Display")) {
          for (Duck d : ducks) {
            d.display();
          }
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

import java.io.*;


public class Quiz {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      String line;
      Inventory inventory = new Inventory();
      while ((line = reader.readLine()) != null) {
        String[] arrOfString = line.split(" ");
        String command = arrOfString[0];
        if (command.equals("create")) {
          String name = arrOfString[1];
          double power = Double.parseDouble(arrOfString[2]);
          double cost = Double.parseDouble(arrOfString[3]);
          inventory.addComponent(new Chassis("chassis", name, power, cost));
        } else if (command.equals("add")) {
          String type = arrOfString[1];
          String componentName = arrOfString[2];
          double power = Double.parseDouble(arrOfString[3]);
          double cost = Double.parseDouble(arrOfString[4]);
          String targetName = arrOfString[5];
          if (type.equals("bus")) {
            Buses bus = new Buses("bus", componentName, power, cost);
            inventory.addComponent(bus);
            Chassis chassis = inventory.getChassis(targetName);
            chassis.addComponent(bus);
          } else if (type.equals("floppy")) {
            Floppies floppy = new Floppies("floppy", componentName, power, cost);
            inventory.addComponent(floppy);
            Chassis chassis = inventory.getChassis(targetName);
            chassis.addComponent(floppy);
          } else { 
            throw new Exception();
          }
        } else if (command.equals("get")) {
          String name = arrOfString[1];
          int index = Integer.parseInt(arrOfString[2]);
          Chassis chassis = inventory.getChassis(name);
          if (chassis == null) {
            System.out.println(name + " does not support command get");
          } else {
            if (index < chassis.getComponents().size()) {
              String componentName = chassis.getComponents().get(index).getName();
              System.out.println(name + ":" + componentName);
            } else {
              System.out.println("Index " + index + " out of bound of " + name);
            }
          }
        } else if (command.equals("print")) {
          String name = arrOfString[1];
          for (Component c : inventory.getComponents()) {
            if (c.getName().equals(name)) {
              c.print();
            }
          }
        } else if (command.equals("sumOfPowerConsumption")) {
          String name = arrOfString[1];
          Chassis chassis = inventory.getChassis(name);
          if (chassis == null) {
            System.out.println(name + " does not support command sumOfPowerConsumption");
          } else {
            System.out.println(chassis.getSumPower());
          }
        } else if (command.equals("sumOfAdditionCost")) {
          String name = arrOfString[1];
          Chassis chassis = inventory.getChassis(name);
          if (chassis == null) {
            System.out.println(name + " does not support command sumOfAdditionCost");
          } else {
            System.out.println(chassis.getSumCost());
          }
        } else {
          throw new Exception();
        }
      }

      reader.close();
    } catch (Exception e) {
      System.out.println("input error");
    }
  }
}

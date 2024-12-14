import java.io.*;

public class Main {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      ChocolateBoiler chocolateBoilder = ChocolateBoiler.getInstance();
      String line;
      while ((line = reader.readLine()) != null) {
        String[] arrOfString = line.split(" ");
        String command = arrOfString[0];
        if (command.equals("Fill")) {
          chocolateBoilder.fill();
        } else if (command.equals("Boil")) {
          chocolateBoilder.boil();
        } else if (command.equals("Drain")) {
          chocolateBoilder.drain();
        } else {
          System.out.println("Error");
        }
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

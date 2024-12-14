import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
      String line;

      Composition composition = new Composition();
      while ((line = reader.readLine()) != null) {
        String[] arrOfStr = line.split(" ");

        if (arrOfStr[0].equals("Text")) {
          String componentID = arrOfStr[1];
          int naturalSize = Integer.parseInt(arrOfStr[2]);
          int shrinkability = Integer.parseInt(arrOfStr[3]);
          int stretchability = Integer.parseInt(arrOfStr[4]);
          String content = arrOfStr[5];
          Text newText = new Text(componentID, naturalSize, shrinkability, stretchability, content);
          composition.getComponents().add(newText);
        } else if (arrOfStr[0].equals("GraphicalElement")) {
          String componentID = arrOfStr[1];
          int naturalSize = Integer.parseInt(arrOfStr[2]);
          int shrinkability = Integer.parseInt(arrOfStr[3]);
          int stretchability = Integer.parseInt(arrOfStr[4]);
          String content = arrOfStr[5];
          Graphical newGraphical =
              new Graphical(componentID, naturalSize, shrinkability, stretchability, content);
          composition.getComponents().add(newGraphical);
        } else if (arrOfStr[0].equals("ChangeSize")) {
          String componentID = arrOfStr[1];
          int newSize = Integer.parseInt(arrOfStr[2]);
          composition.changeSize(componentID, newSize);
        } else if (arrOfStr[0].equals("Require")) {
          String strategy = arrOfStr[1];
          switch (strategy) {
            case "SimpleComposition":
              composition.setStrategy(new SimpleComposition());
              break;
            case "TexComposition":
              composition.setStrategy(new TexComposition());
              break;
            case "ArrayComposition":
              composition.setStrategy(new ArrayComposition());
              break;
          }
          composition.compose();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

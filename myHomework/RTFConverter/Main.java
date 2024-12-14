import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      TextConverter converter = null;
      String line;
      while ((line = reader.readLine()) != null) {
        String[] arrOfStrings = line.split(" ");
        String command = arrOfStrings[0];
        String RTFContent = reader.readLine();
        if (command.equals("TeX")) {
          converter = new TeXConverter();
          System.out.println(converter.getConvertedTextFormat(RTFContent).getContent());
        } else if (command.equals("TextWidget")) {
          converter = new TextWidgetConverter();
          System.out.println(converter.getConvertedTextFormat(RTFContent).getContent());
        }
      }

      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

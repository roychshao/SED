import java.io.*;

public class Main {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      String line;
      Window currentWindow = null;
      while ((line = reader.readLine()) != null) {
        String[] arrOfString = line.split(" ");
        String command = arrOfString[0];
        if (command.equals("window")) {
          String subtype = arrOfString[1];
          String impltype = arrOfString[2];
          if (subtype.equals("IconWindow")) {
            if (impltype.equals("XWindow")) {
              currentWindow = new IconWindow(new XWindowImpl());
            } else if (impltype.equals("PMWindow")) {
              currentWindow = new IconWindow(new PMWindowImpl());
            }
          } else if (subtype.equals("TransientWindow")) {
            if (impltype.equals("XWindow")) {
              currentWindow = new TransientWindow(new XWindowImpl());
            } else if (impltype.equals("PMWindow")) {
              currentWindow = new TransientWindow(new PMWindowImpl());
            }
          }
        } else if (command.equals("drawBorder")) {
          currentWindow.drawText();
          currentWindow.drawRect();
        } else if (command.equals("drawCloseBox")) {
          currentWindow.drawRect();
        }
      }

      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

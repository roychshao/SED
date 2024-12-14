import java.io.*;
import java.util.*;

class Main {
  
  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      String line;
      List<Window> windows = new ArrayList<>();
      List<Scrollbar> scrollbars = new ArrayList<>();
      List<Button> buttons = new ArrayList<>();
      MotifWidgetFactory motifFactory = new MotifWidgetFactory();
      PMWidgetFactory pmFactory = new PMWidgetFactory();
      while((line = reader.readLine()) != null) {
        String[] arrOfStrings = line.split(" ");
        String command = arrOfStrings[0];
        if (command.equals("Window")) {
          String widgetName = arrOfStrings[1];
          windows.add(motifFactory.createWindow(widgetName));
        } else if (command.equals("ScrollBar")) {
          String widgetName = arrOfStrings[1];
          scrollbars.add(motifFactory.createScrollbar(widgetName));
        } else if (command.equals("Button")) {
          String widgetName = arrOfStrings[1];
          buttons.add(motifFactory.createButton(widgetName));
        } else if (command.equals("Motif")) {
          for (int i = 0; i < windows.size(); ++i) {
            windows.set(i, motifFactory.createWindow(windows.get(i).getName()));
          }
          for (int i = 0; i < scrollbars.size(); ++i) {
            scrollbars.set(i, motifFactory.createScrollbar(scrollbars.get(i).getName()));
          }
          for (int i = 0; i < buttons.size(); ++i) {
            buttons.set(i, motifFactory.createButton(buttons.get(i).getName()));
          }
        } else if (command.equals("PM")) {
          for (int i = 0; i < windows.size(); ++i) {
            windows.set(i, pmFactory.createWindow(windows.get(i).getName()));
          }
          for (int i = 0; i < scrollbars.size(); ++i) {
            scrollbars.set(i, pmFactory.createScrollbar(scrollbars.get(i).getName()));
          }
          for (int i = 0; i < buttons.size(); ++i) {
            buttons.set(i, pmFactory.createButton(buttons.get(i).getName()));
          }
        } else if (command.equals("Present")) {
          for (Window w : windows) {
            System.out.println(w.getStyle() + "Window " + w.getName());
          }
          for (Scrollbar s : scrollbars) {
            System.out.println(s.getStyle() + "ScrollBar " + s.getName());
          }
          for (Button b : buttons) {
            System.out.println(b.getStyle() + "Button " + b.getName());
          }
        }
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      String line;
      List<BasicComponent> componentList = new ArrayList<>();
      Stack<Group> groupStk = new Stack<>();
      while((line = reader.readLine()) != null) {
        line = line.trim();
        if (line.matches("<.*/>")) {
          // must be basic components
          line = line.replace("<", "");
          line = line.replace("/>", "");
          if (line.equals("Text")) {
            if (groupStk.size() != 0) {
              groupStk.peek().addComponent(new Text());
            } else {
              componentList.add(new Text());
            }
          } else if (line.equals("Line")) {
            if (groupStk.size() != 0) {
              groupStk.peek().addComponent(new Line());
            } else {
              componentList.add(new Line());
            }
          } else if (line.equals("Rectangle")) {
            if (groupStk.size() != 0) {
              groupStk.peek().addComponent(new Rectangle());
            } else {
              componentList.add(new Rectangle());
            }
          } else if (line.equals("Group")) {
            if (groupStk.size() != 0) {
              groupStk.peek().addComponent(new Group());
            } else {
              componentList.add(new Group());
            }
          }
        } else if (line.matches("</G.*>")) {
          // must be </Group>
          groupStk.pop();
        } else if (line.matches("<G.*>")) {
          // must be <Group>
          Group newGroup = new Group();
          if (groupStk.size() != 0) {
            groupStk.peek().addComponent(newGroup);
          } else {
            componentList.add(newGroup);
          }
          groupStk.push(newGroup);
        }
      }

      for (BasicComponent b : componentList) {
        b.print();
        System.out.print("\n");
      } 
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      /*
       * declare globle variables
       */
      HashMap<String, AbstractList> lists = new HashMap<>();
      String line;
      while ((line = reader.readLine()) != null) {
        String[] arrOfString = line.split(" ");
        String command = arrOfString[0];
        if (command.equals("Create")) {
          String name = arrOfString[1];
          String structure = arrOfString[2];
          if (lists.get(name) != null) {
            throw new Exception("The list with same name is already exists");
          }
          if (structure.equals("List")) {
            lists.put(name, new SimpleList());
          } else if (structure.equals("SkipList")) {
            lists.put(name, new SkipList());
          }
        } else if (command.equals("Add")) {
          String name = arrOfString[1];
          String content = arrOfString[2];
          AbstractList list = lists.get(name);
          list.add(content);
        } else if (command.equals("Length")) {
          String name = arrOfString[1];
          AbstractList list = lists.get(name);
          if (list instanceof SkipList) {
            System.out.println("SkipList can not access length");
          } else {
            SimpleList simpleList = (SimpleList) list;
            System.out.println(simpleList.length); 
          }
        } else if (command.equals("Size")) {
          String name = arrOfString[1];
          AbstractList list = lists.get(name);
          int size = list.size();
          if (size != -1) {
            System.out.println(size);
          }
        } else if (command.equals("Get")) {
          String name = arrOfString[1];
          int index = Integer.valueOf(arrOfString[2]);
          AbstractList list = lists.get(name);
          String result = list.get(index);
          if (result != null) {
            System.out.println(result);
          }
        } else if (command.equals("GetNode")) {
          String name = arrOfString[1];
          int index = Integer.valueOf(arrOfString[2]);
          AbstractList list = lists.get(name);
          list.getNode(index);
        } else if (command.equals("PrintOutList")) {
          String name = arrOfString[1];
          AbstractList list = lists.get(name);
          list.traverse();
        }
      }
      reader.close();
    } catch (Exception e) {
      e.getMessage();
    }
  }
}

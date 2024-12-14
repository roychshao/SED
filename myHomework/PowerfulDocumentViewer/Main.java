import java.io.*;
import java.util.*;

public class Main {
  
  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));
      String line;

      List<Document> documents = new ArrayList<>();
      while ((line = reader.readLine()) != null) {
        String[] arrOfStr = line.split(" ");
        if (arrOfStr[0].equals("Draw")) {
          DrawingDocument newDocument = new DrawingDocument("DrawingDocument");
          documents.add(newDocument);
        } else if (arrOfStr[0].equals("Text")) {
          TextDocument newDocument = new TextDocument("TextDocument");
          documents.add(newDocument);
        } else if (arrOfStr[0].equals("Present")) {
          for (Document d : documents) {
            d.present();
          }
        } else {
          System.out.println("Input Error.");
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

import java.io.*;

public class Main {
  
  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      String line;
      while ((line = reader.readLine()) != null) {
        String[] arrOfString = line.split(" ");
        Email email = new Email(arrOfString[0]);
        Handler handler = new SpamHandler(new ComplaintHandler(new FanHandler()));
        handler.handleMail(email);
      }

      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

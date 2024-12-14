import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      String line;
      SpreadSheetApplication ssa = new SpreadSheetApplication();
      while ((line = reader.readLine()) != null) {
        String[] arrOfStr = line.split(" ");
        String command = arrOfStr[0];
        if (command.equals("data")) {
          String item = arrOfStr[1];
          int value = Integer.parseInt(arrOfStr[2]);
          ssa.addDict(new Data(item, value));
        } else if (command.equals("addChart")) {
          String chartType = arrOfStr[1];
          if (chartType.equals("Spreadsheet")) {
            ssa.addChart(new SpreadSheet(ssa));
          } else if (chartType.equals("BarChart")) {
            ssa.addChart(new BarChart(ssa));
          } else if (chartType.equals("PieChart")) {
            ssa.addChart(new PieChart(ssa));
          }
        } else if (command.equals("change")) {
          String chartType = arrOfStr[1];
          String item = arrOfStr[2];
          int value = Integer.parseInt(arrOfStr[3]);
          ssa.change(chartType, item, value);
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

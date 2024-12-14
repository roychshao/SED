import java.util.*;
import java.math.*;

public class PieChart extends DisplayChart {

  public PieChart(SpreadSheetApplication ssa) {
    super(ssa);
  }

  public void depictInfo(List<Data> dict) {

    int sum = 0;
    for (Data d : dict) {
      sum += d.getValue();
    }

    for (Data d : dict) {
      double percentage = ((double) d.getValue() / sum) * 1000 / 10.0;
      System.out.printf("%s %.1f", d.getItem(), percentage);
      System.out.print("%\n");
    }
  }
}

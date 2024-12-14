import java.util.*;

public class BarChart extends DisplayChart {

  public BarChart(SpreadSheetApplication ssa) {
    super(ssa);
  }

  public void depictInfo(List<Data> dict) {
    for (Data d : dict) {
      for (int i = 0; i < d.getValue(); ++i) {
        System.out.printf("=");
      }
      System.out.println(" " + d.getItem());
    }
  }
}

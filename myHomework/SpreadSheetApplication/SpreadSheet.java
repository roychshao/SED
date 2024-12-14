import java.util.*;

public class SpreadSheet extends DisplayChart {

  public SpreadSheet(SpreadSheetApplication ssa) {
    super(ssa);
  }

  public void depictInfo(List<Data> dict) {
    for (Data d : dict) {
      System.out.println(d.getItem() + " " + d.getValue());
    }
  }
}

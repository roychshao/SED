import java.util.*;

public abstract class DisplayChart {

  protected SpreadSheetApplication ssa;

  public DisplayChart(SpreadSheetApplication ssa) {
    this.ssa = ssa;
  }

  public void depictInfo(List<Data> dict) {
  };

  public void update(Data data) {

    boolean find = false;

    for (Data d : ssa.getDict()) {
      if (d.getItem().equals(data.getItem())) {
        find = true;
        d.setValue(data.getValue());
        break;
      }
    }

    if (!find) {
      ssa.addDict(data);
    }

    ssa.refreshAll();
  };
}

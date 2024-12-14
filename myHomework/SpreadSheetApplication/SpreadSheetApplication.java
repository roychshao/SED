import java.util.*;

public class SpreadSheetApplication {

  private List<Data> dict;
  private List<DisplayChart> charts;

  public SpreadSheetApplication() {
    dict = new ArrayList<Data>();
    charts = new ArrayList<DisplayChart>();
  }

  public List<Data> getDict() {
    return dict;
  }

  public void addDict(Data data) {
    dict.add(data);
  }

  public List<DisplayChart> getCharts() {
    return charts;
  }

  public void addChart(DisplayChart chart) {
    charts.add(chart);
  }

  public void change(String chartType, String item, int value) {

    System.out.println(chartType + " change " + item + " " + value + ".");

    Data data = new Data(item, value);

    if (chartType.equals("Spreadsheet")) {
      for (DisplayChart d : charts) {
        if (d instanceof SpreadSheet) {
          d.update(data);
        }
      }
    }

    if (chartType.equals("BarChart")) {
      for (DisplayChart d : charts) {
        if (d instanceof BarChart) {
          d.update(data);
        }
      }
    }

    if (chartType.equals("PieChart")) {
      for (DisplayChart d : charts) {
        if (d instanceof PieChart) {
          d.update(data);
        }
      }
    }
  }

  public void refreshAll() {
    for (DisplayChart c : charts) {
      c.depictInfo(dict);
    }
  }
}

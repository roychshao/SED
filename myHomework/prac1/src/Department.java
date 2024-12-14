import java.util.Random;

public class Department {

    private String departmentName;
    private MonthlyReport monthlyReport;
    private YTDChart ytdChart;
    private Data data;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.monthlyReport = new MonthlyReport("Monthly Report of " + departmentName);
        this.ytdChart = new YTDChart("YTD Chart of " + departmentName);
        this.data = new Data(departmentName, new Random().nextInt(9999) + 1);
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public MonthlyReport getMonthlyReport() {
        return this.monthlyReport;
    }

    public YTDChart getYTDChart() {
        return this.ytdChart;
    }

    public Data getData() {
        return this.data;
    }

    public void refresh() {
        this.data = new Data(this.departmentName, new Random().nextInt(9999) + 1);
    }
}

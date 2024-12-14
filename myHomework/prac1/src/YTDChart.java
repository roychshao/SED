public class YTDChart extends Report {

    public YTDChart(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public void display(Data data) {
        System.out.println("Displaying YTD chart: " + this.reportName + " department");
        System.out.println("--------------------------");
        System.out.println("Department: " + data.getDepartmentName());
        System.out.println("Revenue: " + data.getRevenue() + " (hundreds of millions)");
    }
}

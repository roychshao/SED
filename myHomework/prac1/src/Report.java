import java.util.Date;

public abstract class Report {
    protected String reportName;

    public Report() {
    };

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void display(Data data) {
    }
}

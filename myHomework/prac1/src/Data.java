public class Data {
    private String departmentName;
    private Integer revenue;

    public Data(String departmentName, Integer revenue) {
        this.departmentName = departmentName;
        this.revenue = revenue;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }
}

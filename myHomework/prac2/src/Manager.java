public class Manager extends Person {
    private List<Project> projectsManaged;
    private Department departmentManaged;

    public Manager(String n, String a, String s, List<Company> c, List<Project> p, Department d) {
        super(n, a, s, c);
        projectsManaged = p;
        departmentManaged = d;
    }

    public List<Project> getProjectsManaged() {
        return projectsManaged;
    }

    public Department getDepartmentManaged() {
        return departmentManaged;
    }
}

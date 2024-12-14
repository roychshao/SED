import java.util.ArrayList;

public class Worker extends Person {
    private List<Project> projectsWorkOn;

    public Worker(String n, String a, String s, List<Company> c, List<Project> p) {
        super(n, a, s, c);
        projectsWorkOn = p;
    }

    public List<Project> getProjectsWorkOn() {
        return projectsWorkOn;
    }
}

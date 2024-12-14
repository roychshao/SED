public class Project {
    private String name;
    private int budget;
    private int internalPriority;
    private List<Worker> workers;
    private Manager manager;

    public Project(String n, int b, int i, List<Worker> w, Manager m) {
        name = n;
        budget = b;
        internalPriority = i;
        workers = w;
        manager = m;
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }

    public int getInternalPriority() {
        return internalPriority;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public Manager getManager() {
        return manager;
    }
}

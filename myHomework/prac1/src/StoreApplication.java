import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class StoreApplication {

    public static void main(String[] args) {

        /* Initialize departments */
        List<Department> departments;
        departments = new ArrayList<Department>();
        departments.add(new Department("Human Resources (HR)"));
        departments.add(new Department("Finance"));
        departments.add(new Department("Marketing"));
        departments.add(new Department("Sales"));
        departments.add(new Department("Information Technology (IT)"));
        departments.add(new Department("Research and Development (R&D)"));
        departments.add(new Department("Customer Service"));
        departments.add(new Department("Operations"));
        departments.add(new Department("Legal"));
        departments.add(new Department("Procurement"));

        /* CLI interface */
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select a department, press <CTRL-C> to end: ");
            System.out.println("--------------------");
            for (int i = 0; i < 10; ++i) {
                System.out.println(String.valueOf(i + 1) + ". " + departments.get(i).getDepartmentName());
            }
            try {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break; // Exit the loop if Enter is pressed without any input
                }
                System.out.println();
                int departmentOrder = Integer.parseInt(input);
                Department selectedDepartment = departments.get(departmentOrder - 1);
                selectedDepartment.refresh();
                MonthlyReport monthlyReport = selectedDepartment.getMonthlyReport();
                YTDChart ytdChart = selectedDepartment.getYTDChart();
                monthlyReport.display(selectedDepartment.getData());
                ytdChart.display(selectedDepartment.getData());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please select again.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid department number, please select again.");
            }
            System.out.println("--------------------");
            System.out.println();
        }
        scanner.close();
    }
}

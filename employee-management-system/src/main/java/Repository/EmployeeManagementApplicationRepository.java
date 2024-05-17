package Repository;

import Entity.Employee;

import java.util.List;

public class EmployeeManagementApplicationRepository {
    private static List<Employee> employees;
    public static void createStartupEnvironment(){
        EmployeeManagementApplicationRepository.createEmployees();

    }

    public static void createEmployees(){
        // The plan is to create an employee tree of a small start up
        // Start creating managers first
        Employee ceo = new Employee(1, "Sanjay", 29, "ceo", "management");
        Employee cto = new Employee(2, "Thellai", 30, "cto", "management");
        Employee cfo = new Employee(3, "Sharan", 33, "cfo", "management");
        Employee developmentManager = new Employee(3, "Sharan", 33, "cfo", "management");
        Employee testingManager = new Employee(3, "Sharan", 33, "cfo", "management");
        Employee cloudManager = new Employee(3, "Sharan", 33, "cfo", "management");
        Employee salesManagaer = new Employee(3, "Sharan", 33, "cfo", "management");
    }
}

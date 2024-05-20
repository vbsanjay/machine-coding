package Repository;

import Entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementApplicationRepository {
    private static List<Employee> employees = new ArrayList<>();
    public static void createStartupEnvironment(){
        EmployeeManagementApplicationRepository.createEmployees();
    }

    public static void createEmployees(){
        // The plan is to create an employee tree of a small start-up
        // Creating higher officials
        Employee ceo = new Employee(1, "Sanjay", 27, "CEO", "MANAGEMENT", null);
        Employee cto = new Employee(2, "Thellai", 30, "CTO", "MANAGEMENT", ceo);
        Employee cfo = new Employee(3, "Prem", 33, "CMO", "MANAGEMENT", ceo);
        employees.add(ceo);
        employees.add(cto);
        employees.add(cfo);
        // Creating managers
        Employee developmentManager = new Employee(3, "Srinivasan", 31, "DEVELOPMENT MANAGER", "DEVELOPMENT", cto);
        Employee testingManager = new Employee(4, "Joshua", 30, "TESTING MANAGER", "TESTING", cto);
        Employee cloudManager = new Employee(5, "Ginu", 36, "CLOUD MANAGER", "CLOUD", cto);
        Employee salesManager = new Employee(6, "Jerin", 43, "SALES MANAGER", "SALES", cfo);
        employees.add(developmentManager);
        employees.add(testingManager);
        employees.add(cloudManager);
        employees.add(salesManager);
        // Creating other employees
        Employee juniorDev = new Employee(7, "Deepak", 27, "JUNIOR SDE", "DEVELOPMENT", developmentManager);
        Employee seniorDev = new Employee(8, "Antony", 29, "SENIOR SDE", "DEVELOPMENT", developmentManager);
        Employee juniorTester = new Employee(9, "Varghees", 21, "JUNIOR TESTER", "TESTING", testingManager);
        Employee seniorTester = new Employee(10, "Preethi", 24, "SENIOR TESTER", "TESTING", testingManager);
        Employee juniorDevOps = new Employee(11, "Madhu", 22, "JUNIOR DEVOPS", "CLOUD", cloudManager);
        Employee seniorDevOps = new Employee(12, "Nishitha", 27, "SENIOR DEVOPS", "CLOUD", cloudManager);
        Employee juniorSalesRep = new Employee(13, "Mukesh", 29, "JUNIOR BDA", "SALES", salesManager);
        Employee seniorSalesRep = new Employee(14, "Dhinakaran", 43, "SENIOR BDA", "SALES", salesManager);
        employees.add(juniorDev);
        employees.add(seniorDev);
        employees.add(juniorTester);
        employees.add(seniorTester);
        employees.add(juniorDevOps);
        employees.add(seniorDevOps);
        employees.add(juniorSalesRep);
        employees.add(seniorSalesRep);
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(List<Employee> employees) {
        EmployeeManagementApplicationRepository.employees = employees;
    }
}

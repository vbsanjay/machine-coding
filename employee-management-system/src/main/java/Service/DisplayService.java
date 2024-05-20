package Service;

import Entity.Employee;

import java.util.List;

public class DisplayService {
    public static void displayAllEmployeeDetailInTable(List<Employee> employees){
        if(employees.isEmpty()) System.out.println("❌ Sorry no data found!");
        System.out.printf("%-5s| %-20s| %-5s| %-20s| %-20s| %-20s|%n", "Id" , "Name", "Age", "Designation", "Department", "ReportingTo");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for(Employee employee: employees){
            System.out.println(employee);
        }
    }
}

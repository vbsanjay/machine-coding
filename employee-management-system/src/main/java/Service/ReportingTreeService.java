package Service;

import Entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class ReportingTreeService {
    //3. Print reporting tree of given employee
    public static void printReportingTreeOfEmployee(List<Employee> employees){
        int empId = UserInputOutputService.fetchEmployeeIdForReportingTreeFromUser();
        //find the employee with this id
        Employee currentEmp = findEmployeeWithId(employees, empId);
        if (currentEmp == null) System.out.println("No such employee");
        else printReportingTree(currentEmp);
    }

    public static Employee findEmployeeWithId(List<Employee> employees, int givenEmpId){
        for(Employee employee: employees){
            if(employee.getEmployeeId() == givenEmpId){
                return employee;
            }
        }
        return null;
    }

    public static void printReportingTree(Employee employee){
        List<Employee> reportingTree = new ArrayList<>();
        // this logic is like traversing the linked list
        Employee tempEmp = employee;
        while(tempEmp != null){
            reportingTree.add(tempEmp);
            tempEmp = tempEmp.getReportingTo();
        }
        DisplayService.displayAllEmployeeDetailInTable(reportingTree);
    }
}

package Entity;

import java.util.List;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    public EmployeeManagementSystem(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

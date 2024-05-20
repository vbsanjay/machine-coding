package Entity;

public class Employee {
    private int employeeId;
    private String empName;
    private int age;
    private String designation;
    private String department;
    private Employee reportingTo;

    public Employee(int employeeId, String empName, int age, String designation, String department, Employee reportingTo) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.age = age;
        this.designation = designation;
        this.department = department;
        this.reportingTo = reportingTo;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee getReportingTo() {
        return reportingTo;
    }

    public void setReportingTo(Employee reportingTo) {
        this.reportingTo = reportingTo;
    }

    @Override
    public String toString() {
        String temp_reportingTo =  (reportingTo != null)? reportingTo.getEmpName():"n/a";
        return String.format("%-5d| %-20s| %-5d| %-20s| %-20s| %-20s|", employeeId, empName, age, designation, department, temp_reportingTo);
    }
}

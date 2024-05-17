package Entity;

public class Employee {
    private int employeeId;
    private String EmpName;
    private int age;
    private String Designation;
    private String Department;
    private Employee ReportingTo;

    public Employee(int employeeId, String empName, int age, String designation, String department) {
        this.employeeId = employeeId;
        EmpName = empName;
        this.age = age;
        Designation = designation;
        Department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public Employee getReportingTo() {
        return ReportingTo;
    }

    public void setReportingTo(Employee reportingTo) {
        ReportingTo = reportingTo;
    }
}

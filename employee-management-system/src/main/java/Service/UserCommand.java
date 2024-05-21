package Service;

import Entity.EmployeeManagementSystem;

public class UserCommand {
    public static void userCommandProcessor(EmployeeManagementSystem employeeManagementSystem){
        boolean isAppRunning = true;
        while(isAppRunning) {
            int userChoice = UserInputOutputService.fetchChoiceFromUser();
            switch (userChoice) {
                case 1: {
                    DisplayService.displayAllEmployeeDetailInTable(employeeManagementSystem.getEmployees());
                    break;
                }
                case 2: {
                    SearchingService.searchAndDisplayDetails(employeeManagementSystem.getEmployees());
                    break;
                }
                case 3: {
                    ReportingTreeService.printReportingTreeOfEmployee(employeeManagementSystem.getEmployees());
                    break;
                }
                case 4: {
                    EmployeesReportingService.printEmployeesReporting(employeeManagementSystem.getEmployees());
                    break;
                }
                case 5: {
                    isAppRunning = false;
                    break;
                }
            }
        }
    }
}

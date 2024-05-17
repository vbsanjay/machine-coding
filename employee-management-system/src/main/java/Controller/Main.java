package Controller;

import Entity.Employee;

public class Main {
    public static void main(String[] args) {
        System.out.println("------ Welcome to Employee Management System ------");
        initializeApplicationSetup();
    }

    public static void initializeApplicationSetup(){
        EmployeeManagementApplicationRepository.createStartupEnvironment();
    }
}
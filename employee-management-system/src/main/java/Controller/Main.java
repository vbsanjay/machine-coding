package Controller;

import Entity.EmployeeManagementSystem;
import Repository.EmployeeManagementApplicationRepository;
import Service.UserCommand;

public class Main {
    public static void main(String[] args) {
        System.out.println("------ Welcome to Employee Management System ------");
        initializeApplicationSetup();
        startApplication();
    }

    public static void initializeApplicationSetup(){
        EmployeeManagementApplicationRepository.createStartupEnvironment();
    }

    public static void startApplication(){
        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem(EmployeeManagementApplicationRepository.getEmployees());
        UserCommand.userCommandProcessor(employeeManagementSystem);
    }
}
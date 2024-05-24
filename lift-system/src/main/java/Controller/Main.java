package Controller;

import Repository.LiftSystemRepository;
import Service.LiftService;

public class Main {
    public static void main(String[] args) {
        System.out.println("------ Welcome to Lift System ------");
        initializeApplication();
        startApplication();
    }

    public static void initializeApplication(){
        LiftSystemRepository.createStartupEnvironment();
    }
    public static void startApplication(){
        while(true){
            LiftService.operateLift();
        }
    }
}
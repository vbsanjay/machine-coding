package Controller;

import Repository.TollPaymentApplicationRepository;
import Service.UserCommandService;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------- Welcome to Toll payment application ---------");
        initializeStartUpEnvironment();
        startApplication();
    }
    public static void initializeStartUpEnvironment(){
        TollPaymentApplicationRepository.initializeTollPaymentApplication(6, 6);
    }
    public static void startApplication(){
        UserCommandService.userCommandProcessor();
    }
}
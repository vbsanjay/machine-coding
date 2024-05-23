package Controller;

import Repository.BalloonFillerRepository;
import Service.UserCommandService;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- 🎈 Welcome to the Balloon filler game 🎈 ----");
        initializeApplication();
        startApplication();
    }

    public static void initializeApplication(){
        BalloonFillerRepository.createStartupEnvironment();
    }

    public static void startApplication(){
        UserCommandService.userCommandProcessor();
    }
}
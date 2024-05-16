package Controller;

import Service.ApplicationSetupService;

public class Main {
    public static void main(String[] args) {
        System.out.println("------ 🧱 Welcome to brick breaker game ☄️ ------");
        initializeApplicationSetup();
        boolean isGameRunning = true;
        while(isGameRunning){
            startGame();
        }

    }
    public static void initializeApplicationSetup(){
        ApplicationSetupService.initializeBrickBreaker();
    }
    public static void startGame(){
        ApplicationSetupService.startBrickBreaker();
    }
}
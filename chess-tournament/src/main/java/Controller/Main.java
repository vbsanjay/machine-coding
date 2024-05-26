package Controller;

import Repository.ChessTournamentRepository;
import Service.TournamentService;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------- ♟ Welcome to chess tournament ♟ --------");
        initializeApplication();
        startApplication();
    }

    public static void initializeApplication(){
        ChessTournamentRepository.createStartupEnvironment();
    }

    public static void startApplication(){
        TournamentService.startTournament();
    }
}
package Repository;

import Entity.Player;
import Service.UserInputOutputService;

import java.util.ArrayList;
import java.util.List;

public class ChessTournamentRepository {
    static int numberOfPlayers;
    static List<Player> players;
    public static void createStartupEnvironment(){
        numberOfPlayers = UserInputOutputService.fetchNumberOfPlayerFromUser();
        players = new ArrayList<>();
        for(int i = 1; i <= numberOfPlayers; i++){
            players.add(new Player(i, 0));
        }
        System.out.println( numberOfPlayers + " number of players has been created.");
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static void setNumberOfPlayers(int numberOfPlayers) {
        ChessTournamentRepository.numberOfPlayers = numberOfPlayers;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(List<Player> players) {
        ChessTournamentRepository.players = players;
    }
}

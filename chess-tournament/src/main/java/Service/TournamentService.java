package Service;

import Entity.Player;
import Repository.ChessTournamentRepository;

import java.util.Collections;
import java.util.List;

public class TournamentService {
    public static void startTournament(){
        System.out.println("------- 💥 Tournament has began 💥 -------");
        matchMaker();
        announceWinner();
    }

    public static void matchMaker(){
        List<Player> players = ChessTournamentRepository.getPlayers();
        for(int i = 0; i < players.size(); i++){
            Player player1 = players.get(i);
            for(int j = i + 1; j < players.size(); j++){
                Player player2 = players.get(j);
                playAChessGame(player1, player2);
            }
        }
    }

    public static void playAChessGame(Player player1, Player player2){
        System.out.println();
        System.out.println(" ⌛️ Current Match Details ⌛️ ");
        System.out.println();
        System.out.printf("%-10s| %-8s| %-10s|%n", "Player", "Score", "Status");
        System.out.println("-------------------------️---------");
        int randomNumber = (int)Math.floor(Math.random() * 3) + 1;
        if(randomNumber == 1){
            player1.setScore(player1.getScore() + 2);
            System.out.printf("%-10d| %-8s| %-10s|%n", player1.getPlayerId(), player1.getScore(), "WON");
            System.out.printf("%-10d| %-8s| %-10s|%n", player2.getPlayerId(), player2.getScore(), "LOST");
        }
        else if(randomNumber == 2){
            player2.setScore(player2.getScore() + 2);
            System.out.printf("%-10d| %-8s| %-10s|%n", player1.getPlayerId(), player1.getScore(), "LOST");
            System.out.printf("%-10d| %-8s| %-10s|%n", player2.getPlayerId(), player2.getScore(), "WON");

        }
        else if(randomNumber == 3){
            player1.setScore(player1.getScore() + 1);
            player2.setScore(player2.getScore() + 1);
            System.out.printf("%-10d| %-8s| %-10s|%n", player1.getPlayerId(), player1.getScore(), "DRAW");
            System.out.printf("%-10d| %-8s| %-10s|%n", player2.getPlayerId(), player2.getScore(), "DRAW");
        }
        System.out.println();
    }

    public static void announceWinner(){
        System.out.println();
        System.out.println("------- 👑 Score Table 👑 -------");
        System.out.println();
        List<Player> players = ChessTournamentRepository.getPlayers();
        Collections.sort(players, (Player a, Player b) -> b.getScore() - a.getScore());
        System.out.printf("%-10s| %-10s| %-8s|%n", "Position", "Player Id", "Score");
        System.out.println("--------------------------------");
        for(int i = 1; i <= players.size(); i++){
            System.out.printf("%-10d| %-10d| %-8d|%n", i, players.get(i-1).getPlayerId(), players.get(i-1).getScore());
        }
    }


}

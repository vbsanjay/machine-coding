package service;

import model.Player;
import model.SnakeAndLadderGame;

import java.util.List;

public class SnakeAndLadderGameService {
    public static Player startGame(SnakeAndLadderGame snakeAndLadderGame){
        List<Player> currentPlayers = snakeAndLadderGame.getPlayers();
        boolean currentGameStatus  = true;
        while (currentGameStatus){
            // Choose the player who want to play
            int i = 0;
            int size = currentPlayers.size();
            while(i < size){
                Player playerToRoll = currentPlayers.get(i);
                PlayerService.movePlayer(playerToRoll, snakeAndLadderGame.getPlayerMap(), snakeAndLadderGame.getLaddersMap(), snakeAndLadderGame.getSnakesMap());
                if(PlayerService.checkWinner(playerToRoll, snakeAndLadderGame.getPlayerMap())){
                    return playerToRoll;
                }
                i = (i + 1) % size;
            }
        }
        return null;
    }



}

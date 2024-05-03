package service;

import model.Player;

import java.util.Map;

public class PlayerService {
    public static void movePlayer(Player playerToRoll, Map<Player, Integer> playerMap, Map<Integer,Integer> laddersMap, Map<Integer,Integer> snakesMap){
        int currentPosition = PlayerService.getCurrentPosition(playerToRoll, playerMap);
        int numberFromDice = DiceService.rollDice();
        int newPosition = PlayerService.updateValidPosition(currentPosition, numberFromDice);

        if(checkSnake(snakesMap, newPosition)){
            System.out.println("OOPS! " + playerToRoll.getName() + " have been bit by a snake \uD83D\uDC0D at new position: " + newPosition);
            System.out.println(playerToRoll.getName()  +"'s position position after bit by snake \uD83D\uDC0D: " + snakesMap.get(newPosition));
            playerMap.put(playerToRoll, snakesMap.get(newPosition));
        }
        else if(checkLadder(laddersMap, newPosition)){
            System.out.println("Whoorae! " + playerToRoll.getName() + " got a ladder \uD83E\uDE9C at new position: " + newPosition);
            System.out.println(playerToRoll.getName() + "'s position after climbing the ladder \uD83E\uDE9C: " + laddersMap.get(newPosition));
            playerMap.put(playerToRoll, laddersMap.get(newPosition));
        }
        else{
            System.out.println(playerToRoll.getName() + " moved from position: " + currentPosition + " to " + newPosition);
            playerMap.put(playerToRoll, newPosition);
        }
    }

    public static int getCurrentPosition(Player player, Map<Player, Integer> playerMap){
        if(playerMap.containsKey(player)){
            return playerMap.get(player);
        }
        return 0;
    }

    public static boolean checkSnake(Map<Integer,Integer> snakesMap, int newPosition){
        if(snakesMap.containsKey(newPosition)){
            return true;
        }
        return false;
    }

    public static boolean checkLadder(Map<Integer,Integer> laddersMap, int newPosition){
        if(laddersMap.containsKey(newPosition)){
            return true;
        }
        return false;
    }

    public static int updateValidPosition (int currentPosition, int numberFromDice){
        int newPosition = (currentPosition + numberFromDice <= 100)? currentPosition + numberFromDice: currentPosition;
        return newPosition;
    }

    public static boolean checkWinner(Player player, Map<Player,Integer> playerMap){
        int currentPosition = playerMap.get(player);
        if (currentPosition == 100) return true;
        return false;
    }
}

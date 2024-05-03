package service;

import model.Player;
import model.SnakeAndLadderGame;

import java.util.*;

public class InitialSetup {
    public static SnakeAndLadderGame getInputFromUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of snakes \uD83D\uDC0D : ");
        int noOfSnake = sc.nextInt();
        System.out.println("-------------------------------------------");

        System.out.print("Enter the number of Ladder \uD83E\uDE9C: ");
        int noOfLadders = sc.nextInt();
        System.out.println("-------------------------------------------");

        System.out.print("Enter the number of Players \uD83D\uDC66: ");
        int noOfPlayers = sc.nextInt();
        System.out.println("-------------------------------------------");

        Map<Integer, Integer> laddersMap = new HashMap<>();
        Map<Integer, Integer> snakesMap = new HashMap<>();
        List<Player> players = new ArrayList<>();

        for(int i = 1; i <= noOfSnake; i++){
            System.out.print("Enter the start point of the Snake " + i + ": ");
            int start = sc.nextInt();
            System.out.print("Enter the end point of the Snake " + i + ": ");
            int end = sc.nextInt();
            snakesMap.put(start, end);
            System.out.println("---Snake " + i + " ❗ Starts point: " + start + " \uD83D\uDEB7 End point: "+ end + "---");
        }

        for(int i = 1; i <= noOfLadders; i++){
            System.out.print("Enter the start point of the Ladder " + i + ": ");
            int start = sc.nextInt();
            System.out.print("Enter the end point of the Ladder " + i + ": ");
            int end = sc.nextInt();
            laddersMap.put(start, end);
            System.out.println("---Ladder " + i + " ✅ Starts point: " + start + " \uD83E\uDDD7 End point: "+ end + "---");
        }

        for(int i = 1; i <= noOfPlayers; i++){
            System.out.print("Enter the name of Player " + i + ": ");
            String name = sc.next();
            players.add(new Player(i, name));
        }

        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(noOfSnake, noOfLadders, noOfPlayers, laddersMap, snakesMap, players);

        return snakeAndLadderGame;
    }
}

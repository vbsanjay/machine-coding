import models.Bot;
import models.Human;
import models.Player;
import services.GameService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Tic-Tac-Toe Game");
        System.out.println("------------------------------------");
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("Enter the number of player: \n 1. One player \n 2. Two player");
            int noOfPlayers = sc.nextInt();
            Player p1;
            Player p2;
            if (noOfPlayers == 1) {
                System.out.println("You have chosen 1 player. So a bot will be playing with you!");
                System.out.print("Enter your name: ");
                String name = sc.next();
                System.out.println("Choose your character: X or O");
                char symbol = sc.next().toUpperCase().charAt(0);
                p1 = new Human(name, symbol, true);
                p2 = new Bot("Bot", (symbol == 'X') ? 'O' : 'X', false);
            } else {
                System.out.println("Enter Player 1 name: ");
                String name = sc.next();
                System.out.println("Choose Player 1 character: X or O");
                char symbol = sc.next().toUpperCase().charAt(0);
                p1 = new Human(name, symbol, true);
                System.out.println("Enter Player 2 name: ");
                name = sc.next();
                symbol = (symbol == 'X') ? 'O' : 'X';
                p2 = new Human(name, symbol, false);
            }
            GameService.startGame(p1, p2);
        }
    }
}

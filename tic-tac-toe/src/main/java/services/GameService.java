package services;

import models.Human;
import models.Player;

import java.util.Scanner;

public class GameService {
    private static char [][] board = new char[3][3];
    private static boolean gameStatus = true;
    private static Scanner sc = new Scanner(System.in);

    public static void startGame(Player p1, Player p2){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }
        while(gameStatus){
            displayBoard();
            Player currentPlayer = checkCurrentPlayer(p1, p2);
            boolean moveStatus = makeMove(currentPlayer);
            if (moveStatus){
                p1.setCurrentMove(!p1.isCurrentMove());
                p2.setCurrentMove(!p2.isCurrentMove());
            }
            if(checkWinner(currentPlayer)){
                System.out.println(currentPlayer.getName() + " is the winner");
                gameStatus = false;
            }
            if(!checkIfEmptyCellAvailable()){
                System.out.println("The game is Draw");
                gameStatus = false;
            }
        }
    }
    public static void displayBoard(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (j != 2){
                    System.out.print(" " + board[i][j] + " |");
                }
                else{
                    System.out.println(" " + board[i][j]);
                }
            }
            if (i != 2) System.out.println("------------");
        }
    }
    public static Player checkCurrentPlayer(Player p1, Player p2){
        if (p1.isCurrentMove()){
            return p1;
        }
        else{
            return p2;
        }
    }
    public static boolean makeMove(Player currentPlayer){
        int [] input = new int[2];
        input = fetchInput(currentPlayer);
        int row = input[0];
        int col = input[1];
        if(checkValidInput(row, col)){
            board[row][col] = currentPlayer.getSymbol();
            return true;
        }
        else{
            System.out.println("Invalid input, try again");
            return false;
        }
    }

    public static boolean checkValidInput(int row, int col){
        if (row > 2) return false;
        if (col > 2) return false;
        if (board[row][col] != ' ') return false;
        return true;
    }

    public static int[] fetchInput(Player currentPlayer){
        int [] input = new int[2];
        if (currentPlayer instanceof Human){
            System.out.print("Enter the row: ");
            input[0] = sc.nextInt();
            System.out.print("Enter the column : ");
            input[1] = sc.nextInt();
        }
        else{

        }
        return input;
    }
    public static boolean checkWinner(Player currentPlayer){
        char Symbol = currentPlayer.getSymbol();
        //Checking the row
        for(int i = 0; i < 3; i++){
            if(Symbol == board[i][0] && Symbol == board[i][1] && Symbol == board[i][2]){
                return true;
            }
        }
        //Checking the col
        for(int i = 0; i < 3; i++){
            if(Symbol == board[0][i] && Symbol == board[1][i] && Symbol == board[2][i]){
                return true;
            }
        }
        //Checking the diagonal
        if(Symbol == board[0][0] && Symbol == board[1][1] && Symbol == board[2][2]){
            return true;
        }
        if(Symbol == board[0][2] && Symbol == board[1][1] && Symbol == board[2][0]){
            return true;
        }

        return false;
    }

    public static boolean checkIfEmptyCellAvailable(){
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (board[i][j] == ' '){
                    count++;
                }
            }
        }
        if (count == 0) return false;
        return true;
    }
}

import java.util.Scanner;

public class TicTacToeSingleFile {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe Game");
        System.out.println("-----------------------------------------");
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        boolean isGameOver = false;
        char [][] board = new char[3][3];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = ' ';
            }
        }

        while(!isGameOver){

            //Getting input from the user
            displayBoard(board);
            System.out.println("Player " + player + " make your move");
            System.out.print("Enter the row number: ");
            int row = sc.nextInt();
            System.out.print("Enter the column number: ");
            int col = sc.nextInt();

            if ( row < board.length && col < board[0].length && board[row][col] == ' '){
                board[row][col] = player;
                isGameOver = checkWinner(board, player);
                if(isGameOver) System.out.println("Player " + player + " has won");
                player = (player == 'X')? 'O':'X';
            }
            else{
                System.out.println("Invalid input, please choose a valid input");
                continue;
            }
        }

    }

    public static boolean checkWinner(char[][] board, char player){
        //check row
        for (int i = 0; i < board.length; i++){
            if(player == board[i][0] && player == board[i][1] && player == board[i][2]){
                return true;
            }
        }

        //check column
        for (int i = 0; i < board[0].length; i++){
            if(player == board[0][i] && player == board[1][i] && player == board[2][i]){
                return true;
            }
        }

        //check diagonal
        if(player == board[0][0] && player == board[1][1] && player == board[2][2]){
            return true;
        }
        if(player == board[0][2] && player == board[1][1] && player == board[2][0]){
            return true;
        }

        return false;
    }
    public static void displayBoard(char [][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(j != 2){
                    System.out.print(" " + board[i][j] + " |");
                }
                else{
                    System.out.print(" " + board[i][j] + " ");
                }
            }
            System.out.println();
            if (i == 0 || i == 1) {
                System.out.println("------------");
            }
        }
    }
}
package Service;

import Entity.Balloon;
import Repository.BalloonFillerRepository;

public class Version1GameService {

    public static void startGame(){
        boolean isGameRunning = true;
        while(isGameRunning){
            fillColumn();
            if(checkExit()){
                System.out.println("🙏🏻 Thanks for playing");
                isGameRunning = false;
            }
            if(checkIfFull()){
                System.out.println("🍺 The board is full");
                isGameRunning = false;
            }
        }
    }
    public static int fillColumn(){
        Balloon[][] board = BalloonFillerRepository.getBoard();
        int columnToFill = InputOutputService.getColumnFromUser() - 1;
        String colorToFill = InputOutputService.getColorFromUser();
        boolean isColumnFull = true;
        if(columnToFill < board[0].length){
            for(int i = board.length - 1; i >= 0; i--){
                if(board[i][columnToFill].getColor().equalsIgnoreCase("-")){
                    board[i][columnToFill].setColor(colorToFill);
                    isColumnFull = false;
                    break;
                }
            }
            PrintBoardService.printBoard();
            if(isColumnFull){
                System.out.println("Column is full ✋🏻");
            }
        }
        else{
            System.out.println("The column is out of bound ❌ Please enter proper column again.👇🏻");
        }

        return columnToFill;
    }

    public static boolean checkExit(){
        String userWishToContinue = InputOutputService.doWantToContinueGame();
        if(userWishToContinue.equalsIgnoreCase("yes")) return false;
        return true;
    }

    public static boolean checkIfFull(){
        Balloon[][] board = BalloonFillerRepository.getBoard();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j  < board[i].length; j++){
                if(board[i][j].getColor().equalsIgnoreCase("-")) return false;
            }
        }
        return true;
    }
}

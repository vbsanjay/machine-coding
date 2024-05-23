package Service;

import Entity.Balloon;
import Repository.BalloonFillerRepository;

public class Version3GameService {
    public static void startGame(){
        boolean isGameRunning = true;

        while(isGameRunning){
            fillColumn();
            if(Version1GameService.checkExit()){
                System.out.println("🙏🏻 Thanks for playing");
                isGameRunning = false;
            }
            if(checkIfFull()){
                System.out.println("🍺 The Column is full. Terminating the Game...");
                isGameRunning = false;
            }
        }
    }
    public static void fillColumn(){
        Balloon[][] board = BalloonFillerRepository.getBoard();

        int columnToFill = InputOutputService.getColumnFromUser() - 1;
        String colorToFill = InputOutputService.getColorFromUser().toUpperCase();

        if(columnToFill < board[0].length){
            for(int i = board.length - 1; i >= 0; i--){
                if(i == board.length - 1 && board[i][columnToFill].toString().equalsIgnoreCase("-")){
                    board[i][columnToFill].setColor(colorToFill);
                    break;
                }
                else{
                    boolean isFilled = false;
                    // detect the column
                    if(!board[i][columnToFill].toString().equalsIgnoreCase("-")){
                        //System.out.println(i);
                        boolean isLeftPlaced = false;
                        boolean isRightPlaced = false;
                        // check left
                        for(int j = columnToFill - 1; j >= 0; j--){
                            if(board[i][j].toString().equalsIgnoreCase("-")){
                                board[i][j].setColor(colorToFill);
                                isLeftPlaced = true;
                                break;
                            }
                        }
                        // check right
                        if(!isLeftPlaced){
                            for(int j = columnToFill + 1; j < board[i].length; j++){
                                if(board[i][j].toString().equalsIgnoreCase("-")){
                                    board[i][j].setColor(colorToFill);
                                    isRightPlaced = true;
                                    break;
                                }
                            }
                        }
                        if(isLeftPlaced || isRightPlaced){
                            isFilled = true;
                        }
                    }
                    else if(board[i][columnToFill].toString().equalsIgnoreCase("-")){
                        board[i][columnToFill].setColor(colorToFill);
                        isFilled = true;
                    }
                    if(isFilled){
                        break;
                    }
                }
            }
            PrintBoardService.printBoard();
        }
        else{
            System.out.println("The column is out of bound ❌ You can enter proper column if you wish to continue again ✅");
        }
    }

    public static boolean checkIfFull(){
        Balloon[][] board = BalloonFillerRepository.getBoard();
        for(int i = 0; i < BalloonFillerRepository.getNumberOfColumn(); i++){
            if(!board[0][i].toString().equalsIgnoreCase("-")) return true;
        }
        return false;
    }
}

package Service;

import Entity.Balloon;
import Repository.BalloonFillerRepository;

public class Version2GameService {
    public static void startGame(){
        boolean isGameRunning = true;
        while(isGameRunning){
            int columnSelected = Version1GameService.fillColumn();

            if(Version1GameService.checkExit()){
                System.out.println("🙏🏻 Thanks for playing");
                isGameRunning = false;
            }
            if(checkIfFull(columnSelected)){
                System.out.println("🍺 The Column is full. Terminating the Game...");
                isGameRunning = false;
            }
        }
    }

    public static boolean checkIfFull(int columnSelected){
        Balloon [][] board = BalloonFillerRepository.getBoard();
        for(int i = 0; i < board.length; i++){
            if(board[i][columnSelected].toString().equalsIgnoreCase("-")){
                return false;
            }
        }
        return true;
    }
}

package Service;

import Entity.Balloon;
import Repository.BalloonFillerRepository;

public class Version5GameService {
    public static void startGame(){
        boolean isGameRunning = true;

        while(isGameRunning){
            Version3GameService.fillColumn();
            Version4GameService.burstColumn();
            burstRow();
            if(Version1GameService.checkExit()){
                System.out.println("🙏🏻 Thanks for playing");
                isGameRunning = false;
            }
            if(Version3GameService.checkIfFull()){
                System.out.println("🍺 The Column is full. Terminating the Game...");
                isGameRunning = false;
            }
        }
    }
    public static void burstRow(){
        Balloon[][] board = BalloonFillerRepository.getBoard();
        for(int i = 0; i < BalloonFillerRepository.getNumberOfRows(); i++){
            boolean isRowMatch = true;
            for(int j = 0; j < BalloonFillerRepository.getNumberOfColumn() - 1; j++){
                if(board[i][j].getColor().equalsIgnoreCase("-")){
                    isRowMatch = false;
                    break;
                }
                if(!board[i][j].getColor().equalsIgnoreCase(board[i][j+1].getColor())){
                    isRowMatch = false;
                    break;
                }
            }
            if(isRowMatch){
                for(int j = 0; j < BalloonFillerRepository.getNumberOfColumn(); j++){
                    board[i][j].setColor("-");
                }
                System.out.println("💥 Bursting the balloons in row: " + i);
                PrintBoardService.printBoard();
            }
        }

    }
}

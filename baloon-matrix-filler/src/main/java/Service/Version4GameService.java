package Service;

import Entity.Balloon;
import Repository.BalloonFillerRepository;

public class Version4GameService {
    public static void startGame(){
        boolean isGameRunning = true;

        while(isGameRunning){
            Version3GameService.fillColumn();
            burstColumn();
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

    public static void burstColumn(){
        Balloon[][] board = BalloonFillerRepository.getBoard();
        for(int i = 0; i < BalloonFillerRepository.getNumberOfColumn(); i++){
            if(!board[0][i].toString().equalsIgnoreCase("-")){
                boolean isSameColor = true;
                String comparableColor = board[0][i].toString();
                for(int j = 0; j < BalloonFillerRepository.getNumberOfRows(); j++){
                    if(!board[j][i].toString().equalsIgnoreCase(comparableColor)){
                        isSameColor = false;
                    }
                }
                if(isSameColor){
                    System.out.println("💥 Bursting the balloons in column: " + i);
                    for(int j = 0; j < BalloonFillerRepository.getNumberOfRows(); j++){
                        board[j][i].setColor("-");
                    }
                    PrintBoardService.printBoard();
                }
            }
        }
    }
}

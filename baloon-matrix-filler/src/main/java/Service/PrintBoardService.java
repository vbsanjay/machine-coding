package Service;

import Entity.Balloon;
import Repository.BalloonFillerRepository;

public class PrintBoardService {
    static int numberOfRows = BalloonFillerRepository.getNumberOfRows();
    static int numberOfColumn = BalloonFillerRepository.getNumberOfColumn();
    static Balloon [][] board = BalloonFillerRepository.getBoard();
    public static void printBoard(){
        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j  < numberOfColumn; j++){
                String message = board[i][j].toString();
                if(j != numberOfColumn - 1)
                    message += " | ";
                System.out.print(message);
            }
            System.out.println();
        }
    }
}

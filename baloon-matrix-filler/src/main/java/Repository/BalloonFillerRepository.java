package Repository;

import Entity.Balloon;
import Service.InputOutputService;
import Service.PrintBoardService;

public class BalloonFillerRepository {
    static int numberOfRows;
    static int numberOfColumn;
    static Balloon[][] board;

    public static void createStartupEnvironment(){
        numberOfRows = InputOutputService.getNumberOfRowsFromUser();
        numberOfColumn = InputOutputService.getNumberOfColumnFromUser();
        board = new Balloon[numberOfRows][numberOfColumn];
        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j  < numberOfColumn; j++){
                board[i][j] = new Balloon("-");
            }
        }
        PrintBoardService.printBoard();
    }

    public static int getNumberOfRows() {
        return numberOfRows;
    }

    public static void setNumberOfRows(int numberOfRows) {
        BalloonFillerRepository.numberOfRows = numberOfRows;
    }

    public static int getNumberOfColumn() {
        return numberOfColumn;
    }

    public static void setNumberOfColumn(int numberOfColumn) {
        BalloonFillerRepository.numberOfColumn = numberOfColumn;
    }

    public static Balloon[][] getBoard() {
        return board;
    }

    public static void setBoard(Balloon[][] board) {
        BalloonFillerRepository.board = board;
    }
}

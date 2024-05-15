package Service;

import Entity.BrickBreaker;
import Entity.Position;

import java.util.List;

public class DisplayBoardService {
    public static void displayBoard(BrickBreaker brickBreaker){
        int numberOfRows = brickBreaker.getNumberOfRows();
        int numberOfColumns = brickBreaker.getNumberOfColumns();
        int numberOfBricks = brickBreaker.getNumberOfBricks();
        List<Position > brickPositions = brickBreaker.getBrickPositions();
        Position ballPosition = brickBreaker.getBallPosition();
        char [][] board = brickBreaker.getBoard();

        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                if(i == 0) board[i][j] = 'w';
                else if(j == 0 || j == numberOfColumns - 1) board[i][j] = 'w';
                else if(i == numberOfRows - 1) board[i][j] = 'g';
                else{
                    board[i][j] = '-';
                }
            }
        }

        board[ballPosition.getX() - 1][ballPosition.getY() - 1] = 'o';

        for(int i = 0; i < brickPositions.size(); i++){
            Position brickPosition = brickPositions.get(i);
            board[brickPosition.getX()-1][brickPosition.getY() -1] = '1';
        }
        System.out.println("---------------------------------------");
        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void displayUpdatedBoard(BrickBreaker brickBreaker){
        int numberOfRows = brickBreaker.getNumberOfRows();
        int numberOfColumns = brickBreaker.getNumberOfColumns();
        char [][] board = brickBreaker.getBoard();
        System.out.println("---------------------------------------");
        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColumns; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}

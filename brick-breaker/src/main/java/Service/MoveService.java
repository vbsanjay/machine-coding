package Service;

import Entity.BrickBreaker;

public class MoveService {
    public static void moveStraight(){
        BrickBreaker brickBreaker = ApplicationSetupService.brickBreaker;
        char [][] board = brickBreaker.getBoard();
        for(int i = brickBreaker.getNumberOfRows() - 1; i >= 0; i--){
            if(board[i][brickBreaker.getBallPosition().getY() - 1] == '1'){
                board[i][brickBreaker.getBallPosition().getY() - 1] = '-';
                break;
            }
        }
        DisplayBoardService.displayUpdatedBoard(brickBreaker);
    }

    public static void moveLeft(){

    }

    public static void moveRight(){

    }
}

package Service;

import Entity.BrickBreaker;
import Entity.Position;

public class MoveService {
    static BrickBreaker brickBreaker = ApplicationSetupService.brickBreaker;
    static char[][] board = brickBreaker.getBoard();

    public static void moveStraight() {

        if(brickBreaker.getNumberOfBalls() == 0) System.out.println("You have no life left. Restart the game 💔");

        for (int i = brickBreaker.getNumberOfRows() - 1; i >= 0; i--) {
            if (board[i][brickBreaker.getBallPosition().getY() - 1] == '1') {
                board[i][brickBreaker.getBallPosition().getY() - 1] = '-';
                break;
            }
        }
        DisplayBoardService.displayUpdatedBoard(brickBreaker);
    }

    public static void moveRight() {

        if(brickBreaker.getNumberOfBalls() == 0) System.out.println("You have no life left. Restart the game 💔");

        int initialBallPosition = brickBreaker.getBallPosition().getY() - 1;;
        for (int i = brickBreaker.getNumberOfRows() - 1; i > 0; i--) {
            // We know the current ball position is at the row (bottom row) we need to get the column
            // We always save ball position in 1 index so column position is fetch and subtracted by 1
            int currentYaxisBallPosition = brickBreaker.getBallPosition().getY() - 1;

            // Diagonally next row and column are found
            int nextRow = i - 1; //We traverse from bottom so subtracted by 1
            int nextColumn = currentYaxisBallPosition + 1; //We traverse to the right by adding 1 to the column

            boolean isHit = false; //To keep track if the Ball is hit in the Diagonally nearby wall or not

            //For each move are 3 scenarios
            //1. Ball can hit in the wall
            //2. Ball can hit in the brick
            //3. Ball does not hit anywhere

            if (board[nextRow][nextColumn] == 'w') { //1. if ball hits in the wall

                isHit = true; //Since the ball hit in the wall we are changing this to true

                // Move Horizontally after hitting the wall

                // Define the start point for horizontal movement
                int currentRow = i; // We need to move horizontally in the current row so current row is i itself
                int currentColumn = nextColumn - 1; // Logically current Column would be nextCoulmn - 1

                // Started moving horizontally
                while(currentColumn > 0){ // row will remain fixed and column will change due to Horizontal movement

                    //There are 2 scenarios
                    //1. Ball can hit in the brick
                    //2. Ball can hit in the wall

                    //1. If ball hit the brick or 2. If ball hit the wall
                    if(board[currentRow][currentColumn] == '1' || currentColumn == 1){

                        // Move Downward after hitting the brick
                        while(currentRow < brickBreaker.getNumberOfRows() - 1){
                            board[currentRow][currentColumn] = '-';
                            currentRow++;
                        }
                        i = 0;
                        break; //Since the ball falls down we can end the loop, the complete move right action is end outer the while loop
                    }
                    currentColumn--;
                }
                if(isHit) {
                    if(board[brickBreaker.getNumberOfRows() - 1][currentColumn] != 'o') {
                        board[brickBreaker.getNumberOfRows() - 1][initialBallPosition] = 'g';
                        board[brickBreaker.getNumberOfRows() - 1][currentColumn] = 'o';
                        brickBreaker.setBallPosition(new Position(brickBreaker.getNumberOfRows(), currentColumn + 1));
                        brickBreaker.setNumberOfBalls(brickBreaker.getNumberOfBalls() - 1);
                    }
                }
                //break; // this breaks ends the complete move right action
            }
            else if(board[nextRow][nextColumn] == '1'){ //2. If the ball hit the brick
                isHit = true;
                // Make the brick disappear
                board[nextRow][nextColumn] = '-';
                int currentRow = nextRow; // We need to move horizontally in the current row so current row is i itself
                int currentColumn = nextColumn; // Logically current Column would be nextCoulm
                //Move downward
                while(currentRow < brickBreaker.getNumberOfRows() - 1){
                    board[currentRow][currentColumn] = '-';
                    currentRow++;
                }
                i = 0;
                if(isHit) {
                    if(board[brickBreaker.getNumberOfRows() - 1][currentColumn] != 'o'){
                        board[brickBreaker.getNumberOfRows() - 1][initialBallPosition] = 'g';
                        board[brickBreaker.getNumberOfRows() - 1][currentColumn] = 'o';
                        brickBreaker.setBallPosition(new Position(brickBreaker.getNumberOfRows(), currentColumn + 1));
                        brickBreaker.setNumberOfBalls(brickBreaker.getNumberOfBalls() - 1);
                    }
                    break; // this breaks ends the complete move right action
                }
                break; //Since the ball falls down we can end the loop, the complete move right action is end outer the while loop
            }

            if(!isHit){ //3. If the ball didn't hit in the wall or brick just update the ball position
                brickBreaker.getBallPosition().setX(nextRow + 1);
                brickBreaker.getBallPosition().setY(nextColumn + 1);
            }
        }
        DisplayBoardService.displayUpdatedBoard(brickBreaker);
        System.out.println("Number of life: " + brickBreaker.getNumberOfBalls());
    }
    public static void moveLeft(){

        if(brickBreaker.getNumberOfBalls() == 0) System.out.println("You have no life left. Restart the game 💔");

        int initialBallPosition = brickBreaker.getBallPosition().getY() - 1;

        for (int i = brickBreaker.getNumberOfRows() - 1; i > 0; i--) {
            // We know the current ball position is at the row (bottom row) we need to get the column
            // We always save ball position in 1 index so column position is fetch and subtracted by 1
            int currentYaxisBallPosition = brickBreaker.getBallPosition().getY() - 1;

            // Diagonally next row and column are found
            int nextRow = i - 1; //We traverse from bottom so subtracted by 1
            int nextColumn = currentYaxisBallPosition - 1; //We traverse to the left by subtracting 1 to the column

            boolean isHit = false; //To keep track if the Ball is hit in the Diagonally nearby wall or not

            //For each move are 3 scenarios
            //1. Ball can hit in the wall
            //2. Ball can hit in the brick
            //3. Ball does not hit anywhere

            if (board[nextRow][nextColumn] == 'w') { //1. if ball hits in the wall
                System.out.println("I m inside");
                isHit = true; //Since the ball hit in the wall we are changing this to true

                // Move Horizontally after hitting the wall

                // Define the start point for horizontal movement
                int currentRow = i; // We need to move horizontally in the current row so current row is i itself
                int currentColumn = nextColumn + 1; // Logically current Column would be nextCoulmn + 1

                // Started moving horizontally
                while(currentColumn < brickBreaker.getNumberOfColumns() - 1){ // row will remain fixed and column will change due to Horizontal movement

                    //There are 2 scenarios
                    //1. Ball can hit in the brick
                    //2. Ball can hit in the wall

                    //1. If ball hit the brick or 2. If ball hit the wall
                    if(board[currentRow][currentColumn] == '1' || currentColumn == brickBreaker.getNumberOfColumns() - 2){

                        // Move Downward after hitting the brick
                        while(currentRow < brickBreaker.getNumberOfRows() - 1){
                            board[currentRow][currentColumn] = '-';
                            currentRow++;
                        }
                        i = 0;
                        break; //Since the ball falls down we can end the loop, the complete move right action is end outer the while loop
                    }
                    currentColumn++;
                }
                if(isHit) {
                    if(board[brickBreaker.getNumberOfRows() - 1][currentColumn] != 'o') {
                        board[brickBreaker.getNumberOfRows() - 1][initialBallPosition] = 'g';
                        board[brickBreaker.getNumberOfRows() - 1][currentColumn] = 'o';
                        brickBreaker.setBallPosition(new Position(brickBreaker.getNumberOfRows(), currentColumn + 1));
                        brickBreaker.setNumberOfBalls(brickBreaker.getNumberOfBalls() - 1);
                    }
                }
                //break; // this breaks ends the complete move right action
            }
            else if(board[nextRow][nextColumn] == '1'){ //2. If the ball hit the brick
                isHit = true;
                // Make the brick disappear
                board[nextRow][nextColumn] = '-';
                int currentRow = nextRow; // We need to move horizontally in the current row so current row is i itself
                int currentColumn = nextColumn; // Logically current Column would be nextCoulmn
                //Move downward
                while(currentRow < brickBreaker.getNumberOfRows() - 1){
                    board[currentRow][currentColumn] = '-';
                    currentRow++;
                }
                i = 0;
                if(isHit) {
                    if(board[brickBreaker.getNumberOfRows() - 1][currentColumn] != 'o'){
                        board[brickBreaker.getNumberOfRows() - 1][initialBallPosition] = 'g';
                        board[brickBreaker.getNumberOfRows() - 1][currentColumn] = 'o';
                        brickBreaker.setBallPosition(new Position(brickBreaker.getNumberOfRows(), currentColumn + 1));
                        brickBreaker.setNumberOfBalls(brickBreaker.getNumberOfBalls() - 1);
                    }
                    break; // this breaks ends the complete move right action
                }
               // break; //Since the ball falls down we can end the loop, the complete move right action is end outer the while loop
            }

            if(!isHit){ //3. If the ball didn't hit in the wall or brick just update the ball position
                brickBreaker.getBallPosition().setX(nextRow + 1);
                brickBreaker.getBallPosition().setY(nextColumn + 1);
            }
        }
        DisplayBoardService.displayUpdatedBoard(brickBreaker);
        System.out.println("Number of life: " + brickBreaker.getNumberOfBalls());

    }
}



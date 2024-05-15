package Service;

import Entity.BrickBreaker;
import Entity.Position;

import java.util.List;

public class ApplicationSetupService {
    static BrickBreaker brickBreaker;
    public static void initializeBrickBreaker(){
        int noOfRows = UserInputOutputService.fetchNumberOfRowsFromUser();
        int noOfColumns = UserInputOutputService.fetchNumberOfColumnsFromUser();
        int noOfBricks = UserInputOutputService.fetchNumberOfBricksFromUser();
        List<Position> brickPositions = UserInputOutputService.fetchBrickPositionsFromUser(noOfBricks);
        brickBreaker = new BrickBreaker(noOfRows, noOfColumns, noOfBricks, brickPositions);
    }
    public static void startBrickBreaker(){
        Position ballPosition = UserInputOutputService.fetchBallPositionFromUser(brickBreaker.getNumberOfRows());
        brickBreaker.setBallPosition(ballPosition);
        DisplayBoardService.displayBoard(brickBreaker);
        UserCommandService.processUserCommand(brickBreaker);
    }
}

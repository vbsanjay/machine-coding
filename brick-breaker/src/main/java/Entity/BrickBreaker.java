package Entity;

import java.util.List;

public class BrickBreaker {
    private int numberOfRows;
    private int numberOfColumns;
    private char[][] board;
    private int numberOfBalls = 5;
    private int numberOfBricks;
    private List<Position> brickPositions;
    private Position ballPosition;

    public BrickBreaker(int numberOfRows, int numberOfColumns, int numberOfBricks, List<Position> brickPositions) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.board = new char[numberOfRows][numberOfColumns];
        this.numberOfBricks = numberOfBricks;
        this.brickPositions = brickPositions;
    }

    public Position getBallPosition() {
        return ballPosition;
    }

    public void setBallPosition(Position ballPosition) {
        this.ballPosition = ballPosition;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int getNumberOfBalls() {
        return numberOfBalls;
    }

    public void setNumberOfBalls(int numberOfBalls) {
        this.numberOfBalls = numberOfBalls;
    }

    public int getNumberOfBricks() {
        return numberOfBricks;
    }

    public void setNumberOfBricks(int numberOfBricks) {
        this.numberOfBricks = numberOfBricks;
    }

    public List<Position> getBrickPositions() {
        return brickPositions;
    }

    public void setBrickPositions(List<Position> brickPositions) {
        this.brickPositions = brickPositions;
    }
}

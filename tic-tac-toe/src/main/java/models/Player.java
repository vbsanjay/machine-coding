package models;

public class Player {
    private String name;
    private char symbol;
    private boolean currentMove;
    public Player(String name, char symbol, boolean currentMove){
        this.name = name;
        this.symbol = symbol;
        this.currentMove = currentMove;
    }

    public boolean isCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(boolean currentMove) {
        this.currentMove = currentMove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

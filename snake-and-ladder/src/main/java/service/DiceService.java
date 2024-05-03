package service;

public class DiceService {
    public static int rollDice(){
        int totalNumberOfDice = 1;
        //Each dice will have 6 numbers
        int totalNumber = totalNumberOfDice * 6;
        return (int) (Math.random() * totalNumber) + 1;
    }
}

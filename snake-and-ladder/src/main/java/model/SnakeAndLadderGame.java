package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderGame {
    private int noOfSnakes;
    private int noOfLadders;
    private int noOfPlayers;
    private Map<Integer, Integer> laddersMap = new HashMap<>();
    private Map<Integer, Integer> snakesMap = new HashMap<>();
    private List<Player> players;
    private Map<Player, Integer> playerMap = new HashMap<>();

    public SnakeAndLadderGame(int noOfSnakers, int noOfLadders, int noOfPlayers, Map<Integer, Integer> laddersMap, Map<Integer, Integer> snakesMap, List<Player> players) {
        this.noOfSnakes = noOfSnakers;
        this.noOfLadders = noOfLadders;
        this.noOfPlayers = noOfPlayers;
        this.laddersMap = laddersMap;
        this.snakesMap = snakesMap;
        this.players = players;
    }

    public int getNoOfSnakes() {
        return noOfSnakes;
    }

    public void setNoOfSnakes(int noOfSnakes) {
        this.noOfSnakes = noOfSnakes;
    }

    public int getNoOfLadders() {
        return noOfLadders;
    }

    public void setNoOfLadders(int noOfLadders) {
        this.noOfLadders = noOfLadders;
    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    public Map<Integer, Integer> getLaddersMap() {
        return laddersMap;
    }

    public void setLaddersMap(Map<Integer, Integer> laddersMap) {
        this.laddersMap = laddersMap;
    }

    public Map<Integer, Integer> getSnakesMap() {
        return snakesMap;
    }

    public void setSnakesMap(Map<Integer, Integer> snakesMap) {
        this.snakesMap = snakesMap;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Map<Player, Integer> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<Player, Integer> playerMap) {
        this.playerMap = playerMap;
    }
}

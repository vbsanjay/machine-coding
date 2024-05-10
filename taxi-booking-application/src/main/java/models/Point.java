package models;

//point
// name, state (no of taxi it has)
//A -------60min------- B  -------60min------- C  -------60min------- D  -------60min------- E  -------60min------- F
//Charges for A to B 100 + 50 = 150 rs
//If two taxis are free at the same point, one with lower earning is allocated.
//If no taxi is free at that time, booking is rejected.

import java.util.List;

public class Point {
    private char name;
    private List<Taxi> taxis;

    public Point(char name, List<Taxi> taxis) {
        this.name = name;
        this.taxis = taxis;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(List<Taxi> taxis) {
        this.taxis = taxis;
    }
}

package services;

import models.Point;
import models.Taxi;

import java.util.List;

public class ApplicationSetup {
    private int numberOfTaxi;
    private List<Taxi> taxis;
    private List<Point> points;
    public void startApplication(){
        InitialSetupService initialSetupService = new InitialSetupService();
        numberOfTaxi = initialSetupService.getNoOfTaxi();
        taxis = initialSetupService.createTaxis(numberOfTaxi);
        points = initialSetupService.createPoint(6, taxis);
    }

    public int getNumberOfTaxi() {
        return numberOfTaxi;
    }

    public void setNumberOfTaxi(int numberOfTaxi) {
        this.numberOfTaxi = numberOfTaxi;
    }

    public List<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(List<Taxi> taxis) {
        this.taxis = taxis;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}

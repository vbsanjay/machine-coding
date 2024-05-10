package services;

import models.Point;
import models.Taxi;

import java.util.ArrayList;
import java.util.List;

public class InitialSetupService {

    // Initial input is taken form the admin before the application is public to the user
    public int getNoOfTaxi(){
        PrintService.printWelcomeAdmin();
        UserIOService userIOService = new UserIOService();
        userIOService.getInputForInitialSetup();
        return userIOService.getNumberOfTaxi();
    }

    public List<Taxi> createTaxis(int numberOfTaxi){
        List <Taxi> taxis = new ArrayList<>();
        for(int i = 1; i <= numberOfTaxi; i++){
            taxis.add(new Taxi(i, new ArrayList<>(), 0, new ArrayList<>()));
        }
        return taxis;
    }

    public List<Point> createPoint(int numberOfPoints, List<Taxi> allTaxis){
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < numberOfPoints; i++){
            points.add(new Point((char) ('A' + i), new ArrayList<>()));
        }
        Point initialPoint = points.get(0);
        initialPoint.getTaxis().addAll(allTaxis);
        return points;
    }

}

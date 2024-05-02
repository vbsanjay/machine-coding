package service;

import java.util.Scanner;

public class FeatureSelectionService {
    public static void featureSelection() {
        Scanner sc =  new Scanner(System.in);
        System.out.println("1. Look for available vehicles \n 2. Book a vehicle " +
                "\n 3. Drop a vehicle \n 4. Cancel the reservation ");
        int n = sc.nextInt();
    }
}

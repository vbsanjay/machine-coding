package Service;

import Entity.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputOutputService {
    static Scanner sc = new Scanner(System.in);
    public static int fetchNumberOfRowsFromUser(){
        System.out.println("---------------------------------------");
        System.out.print("Enter the number of rows in your grid: ");
        return sc.nextInt();
    }

    public static int fetchNumberOfColumnsFromUser(){
        System.out.println("---------------------------------------");
        System.out.print("Enter the number of columns in your grid: ");
        return sc.nextInt();
    }

    public static int fetchNumberOfBricksFromUser(){
        System.out.println("---------------------------------------");
        System.out.print("Enter the number of bricks 🧱: ");
        return sc.nextInt();
    }

    public static List<Position> fetchBrickPositionsFromUser(int numberOfBricks){
        System.out.println("---------------------------------------");
        List<Position> positions = new ArrayList<>();
        for(int i = 0; i < numberOfBricks; i++){
            System.out.println("Enter details of brick " + (i + 1)+ " below 👇🏻");
            System.out.print("Enter x co-ordinate ❎: ");
            int x = sc.nextInt();
            System.out.print("Enter y co-ordinate 💹: ");
            int y = sc.nextInt();
            positions.add(new Position(x,y));
            System.out.println();
        }
        return positions;
    }

    public static Position fetchBallPositionFromUser(int x){
        System.out.println("---------------------------------------");
        System.out.println("Enter details of ball position below 👇🏻");
        System.out.print("Enter y co-ordinate 💹: ");
        int y = sc.nextInt();
        return new Position(x,y);
    }

    public static int fetchServiceRequiredFromUser(){
        System.out.println("---------------------------------------");
        System.out.println("Please choose the next move");
        System.out.println("1. Move Straight \n2. Move Left \n3. Move Right \n4. Exit");
        return sc.nextInt();
    }
}

package services;

public class PrintService {

    public static void printWelcomeAdmin(){
        System.out.println("🔓 Launching Admin setup...");
    }
    public static void printWelcomeUser(){
        System.out.println("🚖 Welcome to taxi booking application 🚖");
    }
    public static void printGetNumberOfTaxi(){
        System.out.println("Enter the number of Taxi in our application 🚕: ");
    }
    public static void getWhatUserNeedToDo(){
        System.out.println("1. Book a Taxi 🔍");
        System.out.println("2. Display Taxi Details 📝");
        System.out.println("3. Exit 🚪");
    }
    public static void printGetCustomerID(){
        System.out.println("Customer ID 🪪: ");
    }
    public static void printGetPickupPoint(){
        System.out.println("Pickup Point 📍: ");
    }
    public static void printGetDropPoint(){
        System.out.println("Drop Point 📍: ");
    }
    public static void printGetPickupTime(){
        System.out.println("Pickup Time ⏰: ");
    }
    public static void invalidOption(){
        System.out.println("❌ Invalid option. Please try again. ❌");
    }

    public static void taxiConfirmation(int id){
        System.out.println("Taxi can be allocated ✅");
        System.out.println("Taxi - " + id + " is allotted 🚕");
    }
}

package Services;

import Entities.Customer;

public class DisplayService {
    public static void displayDetails(Customer customer){
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer username: " + customer.getName());
    }
}

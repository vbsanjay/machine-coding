import Controllers.AuthenticationController;
import Entities.Customer;
import Repository.BankingApplicationRepository;
import Services.UserCommand;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- 🏦 Welcome to our banking Application 🏦 -----");
        initializeApplicationSetup();
        while(true){
            loginUser();
            startBankingService();
        }
    }
    public static void initializeApplicationSetup(){
        BankingApplicationRepository.createStartupEnvironment();
    }

    public static void loginUser(){
        boolean isLoggedIn = false;
        while(!isLoggedIn){
            isLoggedIn = AuthenticationController.login();
        }
    }

    public static void startBankingService(){
        int loggedInCustomerID = AuthenticationController.getLoggedInCustomerID();
        Customer loggedInCustomer = BankingApplicationRepository.getCustomersList().get(loggedInCustomerID - 1);
        UserCommand.userCommandProcessor(loggedInCustomer);
    }

}

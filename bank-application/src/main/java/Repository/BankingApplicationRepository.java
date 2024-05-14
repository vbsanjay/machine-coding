package Repository;

import Entities.BankingApplication;
import Entities.Customer;
import Services.AuthenticationService;

import java.util.List;
import java.util.Map;

public class BankingApplicationRepository {
    private static List<Customer> customersList;
    private static Map<Integer, String> userIdPasswordMap;
    public static void createStartupEnvironment(){
        BankingApplication bankingApplication = new BankingApplication();
        customersList = bankingApplication.getCustomersList();
        userIdPasswordMap = bankingApplication.getUserIdPasswordMap();
        createPassword(userIdPasswordMap);
    }
    public static void createPassword(Map<Integer, String> userIdPasswordMap){
        userIdPasswordMap.put(1, AuthenticationService.encryptPassword("Sanjay@123"));
        userIdPasswordMap.put(2, AuthenticationService.encryptPassword("Thellai@123"));
        userIdPasswordMap.put(3, AuthenticationService.encryptPassword("Prem@123"));
    }

    public static List<Customer> getCustomersList() {
        return customersList;
    }

    public static void setCustomersList(List<Customer> customersList) {
        BankingApplicationRepository.customersList = customersList;
    }

    public static Map<Integer, String> getUserIdPasswordMap() {
        return userIdPasswordMap;
    }

    public static void setUserIdPasswordMap(Map<Integer, String> userIdPasswordMap) {
        BankingApplicationRepository.userIdPasswordMap = userIdPasswordMap;
    }
}

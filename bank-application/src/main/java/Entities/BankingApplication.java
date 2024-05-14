package Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingApplication {
    private List<Customer> customersList;
    private Map<Integer, String> userIdPasswordMap = new HashMap<>();
    public BankingApplication(){
        customersList = new ArrayList<>();
        customersList.add(new Customer(1, "Sanjay"));
        customersList.add(new Customer(2, "Thellai"));
        customersList.add(new Customer(3, "Prem"));
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customer> customersList) {
        this.customersList = customersList;
    }

    public Map<Integer, String> getUserIdPasswordMap() {
        return userIdPasswordMap;
    }

    public void setUserIdPasswordMap(Map<Integer, String> userIdPasswordMap) {
        this.userIdPasswordMap = userIdPasswordMap;
    }
}

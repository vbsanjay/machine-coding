package Service;

import Entity.Employee;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SearchingService {
    static List<Employee> searchResult;
    public static void searchAndDisplayDetails(List<Employee> employees){
        searchResult = new ArrayList<>(employees);
        boolean isSearching = true;
        while(isSearching) {
            int searchChoice = UserInputOutputService.fetchSearchChoiceFromUser();
            switch (searchChoice) {
                case 1:
                    searchById();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    searchByAge();
                    break;
                case 4:
                    searchByDesignation();
                    break;
                case 5:
                    searchByDepartment();
                    break;
                case 6:
                    searchByReportingTo();
                    break;
            }
            isSearching = UserInputOutputService.continueSearch();
        }
        DisplayService.displayAllEmployeeDetailInTable(searchResult);
    }

    public static void doStringOperation(String searchField) {
        int getOperation = UserInputOutputService.fetchOperationFromUser();
        switch(getOperation){
            case 1:
                stringSearchingCommonLogic(searchField, "EQUALS");
                break;
            case 2:
                stringSearchingCommonLogic(searchField, "NOT_EQUALS");
                break;
            case 3:
                stringSearchingCommonLogic(searchField, "CONTAINS");
                break;
            case 4:
                stringSearchingCommonLogic(searchField, "NOT_CONTAINS");
                break;
            case 5:
                stringSearchingCommonLogic(searchField, "STARTS_WITH");
                break;
            case 6:
                stringSearchingCommonLogic(searchField, "ENDS_WITH");
                break;
        }
    }
    public static void stringSearchingCommonLogic(String searchField, String operation){
        String stringToSearch = UserInputOutputService.fetchStingFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            if(employee.getDesignation().equals("CEO")){
                searchResult.remove(employee);
                continue;
            }
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof String && field.getName().equalsIgnoreCase(searchField) ) {
                        stringSearchingCoreLogic(operation, stringToSearch.toLowerCase(), ((String) value).toLowerCase(), employee);
                    }
                    else if(value instanceof Employee && field.getName().equalsIgnoreCase(searchField)) {
                        String reportingToName = ((Employee) value).getEmpName();
                        //System.out.println(reportingToName);
                        stringSearchingCoreLogic(operation, stringToSearch.toLowerCase(), reportingToName.toLowerCase(), employee);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        DisplayService.displayAllEmployeeDetailInTable(searchResult);
    }
    public static void stringSearchingCoreLogic(String operation, String stringToSearch, String value, Employee employee){
        if(operation.equals("EQUALS")){
            if(!stringToSearch.equalsIgnoreCase(value)){
                searchResult.remove(employee);
            }
        }
        else if(operation.equals("NOT_EQUALS")){
            if (stringToSearch.equalsIgnoreCase(value))
                searchResult.remove(employee);
        }
        else if(operation.equals("CONTAINS")){
            if ( (value).contains(stringToSearch) ){
                searchResult.remove(employee);
            }
        }
        else if(operation.equals("NOT_CONTAINS")){
            if ( (value).contains(stringToSearch) ){
                searchResult.remove(employee);
            }
        }
        else if(operation.equals("STARTS_WITH")){
            if ( !(value).startsWith(stringToSearch) ){
                searchResult.remove(employee);
            }
        }
        else if(operation.equals("ENDS_WITH")){
            if ( !(value).endsWith(stringToSearch) ){
                searchResult.remove(employee);
            }
        }
    }
    public static void doIntegerOperation(String searchField) {
        int getOperation = UserInputOutputService.fetchIntegerOperationFromUser();
        //<, >, =, !=, between
        switch(getOperation){
            case 1:
                //checkIntegerLesserThan(searchField);
                integerSearchingCommonLogic(searchField, "LESSER_THAN");
                break;
            case 2:
                //checkIntegerGreaterThan(searchField);
                integerSearchingCommonLogic(searchField, "GREATER_THAN");
                break;
            case 3:
                //checkIntegerEqualTo(searchField);
                integerSearchingCommonLogic(searchField, "EQUAL_TO");
                break;
            case 4:
                //checkIntegerNotEqualTo(searchField);
                integerSearchingCommonLogic(searchField, "NOT_EQUAL_TO");
                break;
            case 5:
                checkIntegerBetween(searchField);
                //integerSearchingCommonLogic(searchField, "LESSER_THAN");
                break;
        }
    }

    public static void integerSearchingCommonLogic(String searchField, String operation) {
        int integerToSearch = UserInputOutputService.fetchIntegerFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof Integer && field.getName().equalsIgnoreCase(searchField)) {
                        integerSearchingCoreLogic(operation, (int)value, integerToSearch, employee);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        DisplayService.displayAllEmployeeDetailInTable(searchResult);
    }

    public static void integerSearchingCoreLogic(String operation, int value, int integerToSearch, Employee employee){
        if(operation.equals("LESSER_THAN")){
            if ( value >= integerToSearch ){
                searchResult.remove(employee);
            }
        }
        else if(operation.equals("GREATER_THAN")){
            if ( value <= integerToSearch ){
                searchResult.remove(employee);
            }
        }
        else if(operation.equals("EQUAL_TO")){
            if ( value != integerToSearch) {
                searchResult.remove(employee);
            }
        }
        else if(operation.equals("NOT_EQUAL_TO")){
            if ((int) value == integerToSearch) {
                searchResult.remove(employee);
            }
        }

    }
    public static void checkIntegerBetween(String searchField){
        int [] integerToSearch = UserInputOutputService.fetchIntegerBetweenFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList) {
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof Integer && field.getName().equalsIgnoreCase(searchField)) {
                        if ((int) value < integerToSearch[0] || (int) value > integerToSearch[1]) {
                            searchResult.remove(employee);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        DisplayService.displayAllEmployeeDetailInTable(searchResult);
    }

    public static void searchById(){
        doIntegerOperation("employeeId");
    }
    public static void searchByName(){
        doStringOperation("empName");
    }
    public static void searchByAge(){
        doIntegerOperation("age");
    }
    public static void searchByDesignation(){
        doStringOperation("designation");
    }
    public static void searchByDepartment(){
        doStringOperation("department");
    }
    public static void searchByReportingTo(){
        doStringOperation("reportingTo");
    }
}

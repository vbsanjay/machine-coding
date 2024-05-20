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
                checkStringEquals(searchField);
                break;
            case 2:
                checkStringNotEquals(searchField);
                break;
            case 3:
                checkStringContains(searchField);
                break;
            case 4:
                checkStringNotContains(searchField);
                break;
            case 5:
                checkStringStartsWith(searchField);
                break;
            case 6:
                checkStringEndsWith(searchField);
                break;
        }
    }
    public static void stringSearchingCommonLogic(String operation, String searchField){
        String stringToSearch = UserInputOutputService.fetchStingFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof String && field.getName().equalsIgnoreCase(searchField) ) {
                        stringSearchingCoreLogic(operation,stringToSearch, (String) value, employee);
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
            if(!stringToSearch.equalsIgnoreCase((String)value)){
                searchResult.remove(employee);
            }
        }
        else if(operation.equals("NOT_EQUALS")){

        }
        else if(operation.equals("CONTAINS")){

        }
        else if(operation.equals("NOT_CONTAINS")){

        }
        else if(operation.equals("STARTS_WITH")){

        }
        else if(operation.equals("ENDS_WITH")){

        }
    }
    public static void checkStringEquals(String searchField){
        String stringToSearch = UserInputOutputService.fetchStingFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof String && field.getName().equalsIgnoreCase(searchField) ) {
                        if(!stringToSearch.equalsIgnoreCase((String)value)){
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

    public static void checkStringNotEquals(String searchField){
        String stringToSearch = UserInputOutputService.fetchStingFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof String && field.getName().equalsIgnoreCase(searchField)) {
                        if (stringToSearch.equalsIgnoreCase((String)value))
                            searchResult.remove(employee);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        DisplayService.displayAllEmployeeDetailInTable(searchResult);
    }

    public static void checkStringContains(String searchField){
        String stringToSearch = UserInputOutputService.fetchStingFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof String && field.getName().equalsIgnoreCase(searchField)) {
                        if ( !((String) value).contains(stringToSearch) ){
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

    public static void checkStringNotContains(String searchField){
        String stringToSearch = UserInputOutputService.fetchStingFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof String && field.getName().equalsIgnoreCase(searchField)) {
                        if ( ((String) value).contains(stringToSearch) ){
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

    public static void checkStringStartsWith(String searchField){
        String stringToSearch = UserInputOutputService.fetchStingFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof String && field.getName().equalsIgnoreCase(searchField)) {
                        if ( !((String) value).startsWith(stringToSearch) ){
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
    public static void checkStringEndsWith(String searchField){
        String stringToSearch = UserInputOutputService.fetchStingFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof String && field.getName().equalsIgnoreCase(searchField)) {
                        if ( !((String) value).endsWith(stringToSearch) ){
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

    public static void doIntegerOperation(String searchField) {
        int getOperation = UserInputOutputService.fetchIntegerOperationFromUser();
        //<, >, =, !=, between
        switch(getOperation){
            case 1:
                checkIntegerLesserThan(searchField);
                break;
            case 2:
                checkIntegerGreaterThan(searchField);
                break;
            case 3:
                checkIntegerEqualTo(searchField);
                break;
            case 4:
                checkIntegerNotEqualTo(searchField);
                break;
            case 5:
                checkIntegerBetween(searchField);
                break;
        }
    }

    public static void checkIntegerLesserThan(String searchField){
        int integerToSearch = UserInputOutputService.fetchIntegerFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof Integer && field.getName().equalsIgnoreCase(searchField)) {
                        if ( (int)value >= integerToSearch ){
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
    public static void checkIntegerGreaterThan(String searchField){
        int integerToSearch = UserInputOutputService.fetchIntegerFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList){
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof Integer && field.getName().equalsIgnoreCase(searchField)) {
                        if ( (int)value <= integerToSearch ){
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
    public static void checkIntegerEqualTo(String searchField){
        int integerToSearch = UserInputOutputService.fetchIntegerFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList) {
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof Integer && field.getName().equalsIgnoreCase(searchField)) {
                        if ((int) value != integerToSearch) {
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
    public static void checkIntegerNotEqualTo(String searchField){
        int integerToSearch = UserInputOutputService.fetchIntegerFromUser(searchField);
        List<Employee> tempList = new ArrayList<>(searchResult);
        for(Employee employee: tempList) {
            Field[] fields = Employee.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(employee);
                    if (value instanceof Integer && field.getName().equalsIgnoreCase(searchField)) {
                        if ((int) value == integerToSearch) {
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

package Services;

import Repository.BankingApplicationRepository;

public class AuthenticationService {

    public static int fetchCustomerID(){
        return UserInputOutputService.fetchCustomerIDFromUser();
    }

    public static String fetchPassword(){
        return UserInputOutputService.fetchPasswordFromUser();
    }

    public static boolean validateLogin(int id, String password){
        String enterPassword = encryptPassword(password);
        if(BankingApplicationRepository.getUserIdPasswordMap().containsKey(id)){
            String storedPassword =  BankingApplicationRepository.getUserIdPasswordMap().get(id);
            if(storedPassword.equals(enterPassword)){
                System.out.println("Account has been logged in ✅");
                return true;
            }
            else{
                System.out.println("❌ Invalid password 🔑");
                return false;
            }
        }
        else{
            System.out.println("❌ Invalid Customer ID 🪪");
            return false;
        }

    }

    public static String encryptPassword(String password){
        StringBuilder encryptedPassword = new StringBuilder();
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar = (char) (c + 1);
                if (encryptedChar > 'z') {
                    encryptedChar = 'a'; // wrap around
                } else if (encryptedChar > 'Z' && encryptedChar < 'a') {
                    encryptedChar = 'A'; // wrap around
                }
                encryptedPassword.append(encryptedChar);
            } else if (Character.isDigit(c)) {
                char encryptedChar = (char) (c + 1);
                if (encryptedChar > '9') {
                    encryptedChar = '0'; // wrap around
                }
                encryptedPassword.append(encryptedChar);
            } else {
                encryptedPassword.append(c); // leave non-alphanumeric characters unchanged
            }
        }
        return encryptedPassword.toString();
    }
}

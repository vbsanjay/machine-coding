package Service;

public class UserCommandService {
     public static void userCommandProcessor(){
         boolean isApplicationRunning = true;
         while(isApplicationRunning){

             int userChoice = InputOutputService.fetchVersionRequiredFromUser();
             switch (userChoice){
                 case 1:
                     Version1GameService.startGame();
                     break;
                 case 2:
                     Version2GameService.startGame();
                     break;
                 case 3:
                     Version3GameService.startGame();
                     break;
                 case 4:
                     Version4GameService.startGame();
                     break;
                 case 5:
                     Version5GameService.startGame();
                     break;
                 default:
                     isApplicationRunning = false;
                     break;
             }
         }
     }
}

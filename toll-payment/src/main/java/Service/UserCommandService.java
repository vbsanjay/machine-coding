package Service;

public class UserCommandService {

    public static void userCommandProcessor(){

        boolean isApplicationRunning = true;
        while(isApplicationRunning){
            int useChoice = UserInputOutputService.fetchUserChoiceFromUser();
            switch(useChoice) {
                case 1:
                    JourneyService.journeyGenerator();
                    break;
                case 2:
                    TollDisplayService.displayAllTollDetails();
                    break;
                case 3:
                    VehicleDisplayService.displayAllVehicleDetails();
                    break;
                case 4:
                    isApplicationRunning = false;
                    break;
            }
        }

    }
}

import services.ApplicationSetup;
import services.PrintService;
import services.UserCommandService;

public class Main {
    public static void main(String[] args) {
        ApplicationSetup applicationSetup = new ApplicationSetup();
        applicationSetup.startApplication();

        PrintService.printWelcomeUser();

        UserCommandService userCommandService = new UserCommandService();
        userCommandService.processUserCommands(applicationSetup.getTaxis(), applicationSetup.getPoints());

    }
}
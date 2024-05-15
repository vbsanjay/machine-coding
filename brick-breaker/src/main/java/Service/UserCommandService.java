package Service;

import Entity.BrickBreaker;

public class UserCommandService {
    public static void processUserCommand(BrickBreaker brickBreaker){
        boolean isCurrentGameNotOver = true;
        while(isCurrentGameNotOver){
            int choice = UserInputOutputService.fetchServiceRequiredFromUser();
            switch (choice){
                case 1:{
                    MoveService.moveStraight();
                    break;
                }
                case 2:{
                    MoveService.moveLeft();
                }
                case 3:{
                    MoveService.moveRight();
                }
                case 4:{
                    isCurrentGameNotOver = false;
                    System.out.print("Game has been exited 📤");
                }
            }
        }


    }
}

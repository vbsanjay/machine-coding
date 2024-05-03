import model.Player;
import model.SnakeAndLadderGame;
import service.InitialSetup;
import service.SnakeAndLadderGameService;

public class Main {
    public static void main(String[] args) {
        boolean isGameRunning = true;

        while(isGameRunning){
            System.out.println("\uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C");
            System.out.println("Welcome to the Snake and ladder game ");
            System.out.println("\uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C \uD83D\uDC0D \uD83E\uDE9C");
            System.out.println();

            // Create a snake and ladder game
            SnakeAndLadderGame snakeAndLadderGame = InitialSetup.getInputFromUser();
            // Start the game
            Player winner = SnakeAndLadderGameService.startGame(snakeAndLadderGame);
            // Announce winner
            System.out.println();
            System.out.println("😀 🙈 🐉 🔥 🌪️ ☄️ 💥 ⚡ ✨ 🍾 🍗 🏆 🎖️");
            System.out.println("The winner of the game is: " + winner.getName());
            System.out.println("😀 🙈 🐉 🔥 🌪️ ☄️ 💥 ⚡ ✨ 🍾 🍗 🏆 🎖️");
            System.out.println();
        }
    }
}
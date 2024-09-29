package MyDailyWork;
import java.util.Random;
import java.util.Scanner;

class NumberGame {
    private int lower;
    private int upper;
    private int numberToGuess;
    private int numAttempts;

    // Constructor
    public NumberGame(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        Random random = new Random();
        this.numberToGuess = random.nextInt(upper - lower + 1) + lower;
        this.numAttempts = 0;
    }

    // Method to start the game
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int userGuess = -1;

        System.out.println("Guess the number between " + lower + " and " + upper);

        // Loop until the user guesses the correct number
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numAttempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + numAttempts + " attempts.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        NumberGame player = new NumberGame(0, 100);
        player.startGame();
    }
}


package MyDailyWork;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static int score = 0;
    private static int currentQuestion = 0;
    private static boolean timeUp = false;

    private static String[][] questions = {
            {"What is the capital of France?", "1) Paris", "2) London", "3) Rome", "4) Berlin", "1"},
            {"Which planet is known as the Red Planet?", "1) Earth", "2) Venus", "3) Mars", "4) Jupiter", "3"},
            {"Who wrote 'Hamlet'?", "1) Mark Twain", "2) William Shakespeare", "3) Charles Dickens", "4) J.K. Rowling", "2"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Application with Timer!");
        while (currentQuestion < questions.length) {
            timeUp = false; // Reset timeUp for each question
            askQuestion(scanner, currentQuestion);
            currentQuestion++;
        }

        System.out.println("Quiz Finished!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
    }

    private static void askQuestion(Scanner scanner, int questionIndex) {
        System.out.println(questions[questionIndex][0]); // Display the question
        for (int i = 1; i <= 4; i++) {
            System.out.println(questions[questionIndex][i]); // Display the options
        }

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timeUp = true; // Mark time as up when the timer finishes
                System.out.println("\nTime is up for this question!\n");
                timer.cancel(); // Cancel the timer
            }
        };

        timer.schedule(task, 10000);

        // Get user input
        System.out.print("Please enter your answer (1-4): ");
        String answer = "";
        while (true) {
            if (scanner.hasNextLine()) {
                answer = scanner.nextLine();
                if (!timeUp) {
                    break;
                } else {
                    return;
                }
            }
        }

        timer.cancel();

        // Check the answer and update the score
        if (answer.equals(questions[questionIndex][5])) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer was: " + questions[questionIndex][5]);
        }

        System.out.println();
    }
}

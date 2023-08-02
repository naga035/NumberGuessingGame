import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int secretNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("\n Now I have chosen a number between " + RANGE_MIN + " and " + RANGE_MAX + ". Can you guess it?");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    isCorrect = true;
                    score += MAX_ATTEMPTS - attempts + 1;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (isCorrect) {
                System.out.println("Congratulations! You guessed the number correctly!");
            } else {
                System.out.println("Sorry, you ran out of attempts. The correct number was: " + secretNumber);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (y/n): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }
        }

        System.out.println("Thank you for playing! Your final score: " + score);
        scanner.close();
    }
}

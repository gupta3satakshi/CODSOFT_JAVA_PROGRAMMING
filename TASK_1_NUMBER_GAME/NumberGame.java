import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guessing Game!");
        int rounds = 1;
        while (true) {
            System.out.print("Choose a difficulty: easy (100-range) or hard (200-range) (or type 'exit' to quit): ");
            String difficulty = scanner.nextLine();
            if (difficulty.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            if (!difficulty.equalsIgnoreCase("easy") && !difficulty.equalsIgnoreCase("hard")) {
                System.out.println("Invalid input. Please choose either 'easy' or 'hard'.");
                continue;
            }

            int numberToGuess = getRandomNumber(random, difficulty);
            int attempts = 0;
            while (true) {
                attempts++;
                System.out.printf("Guess the number between %d and %d: ", getMinValue(difficulty), getMaxValue(difficulty));
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.printf("Congratulations! You guessed the number in %d attempts!%n", attempts);
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            System.out.printf("Your score for this round is %d.%n", attempts);
            rounds++;
            System.out.printf("Your total score for %d rounds is %d.%n", rounds, attempts);
        }
        scanner.close();
    }

    private static int getRandomNumber(Random random, String difficulty) {
        int minValue = getMinValue(difficulty);
        int maxValue = getMaxValue(difficulty);
        return minValue + random.nextInt(maxValue - minValue + 1);
    }

    private static int getMinValue(String difficulty) {
        return difficulty.equalsIgnoreCase("easy") ? 1 : 1;
    }

    private static int getMaxValue(String difficulty) {
        return difficulty.equalsIgnoreCase("easy") ? 100 : 200;
    }
}
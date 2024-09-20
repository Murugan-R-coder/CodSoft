import java.util.*;

class GuessingGame {
    public static int playRound(int maxAttempts) {
        Random rand = new Random();
        int number = rand.nextInt(5) + 1;
        int attempts = 0;
        Scanner sc= new Scanner(System.in);

        System.out.println("\nGuess the number between 1 and 100!");

        while (attempts < maxAttempts) {
            System.out.printf("Attempt %d/%d: Enter your guess: ", attempts + 1, maxAttempts);
            int guess = sc.nextInt();
            attempts++;

            if (guess < number) {
                System.out.println("Too low!");
            } else if (guess > number) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                return attempts;
            }
        }

        System.out.printf("Sorry, you've used all your attempts. The correct number was %d.\n", number);
        return maxAttempts + 1;
    }

    public static void main(String[] args) {
        int rounds = 0;
        int score = 0;
        int maxAttempts = 5;
        Scanner scanner = new Scanner(System.in);
        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {
            rounds++;
            System.out.printf("\nRound %d\n", rounds);
            int attempts = playRound(maxAttempts);

            if (attempts <= maxAttempts) {
                score += (maxAttempts - attempts + 1);
            } else {
                score -= 1;
            }

            System.out.printf("Your score after round %d: %d\n", rounds, score);

            System.out.print("Do you want to play another round? (y/n): ");
            playAgain = scanner.next();
        }

        System.out.printf("\nGame over! You played %d round(s) with a final score of %d.\n", rounds, score);
    }
}

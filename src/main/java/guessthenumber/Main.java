package guessthenumber;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static int[] customRange() {
        int minNumber = 0;
        int maxNumber = 0;
        while (true) {
            System.out.println("Minimum number in range:");
            if (scanner.hasNextInt()) {
                minNumber = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
                System.out.println("Invalid number");
                continue;
            }
        }
        System.out.println("Minimum: " + minNumber);

        while (true) {
            System.out.println("Maximum number in range:");
            if (scanner.hasNextInt()) {
                maxNumber = scanner.nextInt();
                if (maxNumber < minNumber) {
                    System.out.println("The numbers you provided were out of order so they were swapped.");
                    int oldMin = minNumber;
                    minNumber = maxNumber;
                    maxNumber = oldMin;
                }
                break;
            } else {
                scanner.nextLine();
                System.out.println("Invalid number");
                continue;
            }
        }
        System.out.println("Maximum: " + maxNumber);
        return new int[] {minNumber,maxNumber};
    }
    public static void chooseDifficulty(){
        
    }
    public static void play() {
        while (true) {
            System.out.println("Choose a difficulty!");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Normal (1-100)");
            System.out.println("3. Hard (1-200)");
            System.out.println("4. Custom (? - ?)");

            String difficulty = scanner.nextLine();
            String difficultyName = "";
            int maxNumber = 0;
            int minNumber = 1;
            switch (difficulty.strip().toLowerCase()) {
                case "easy":
                    
                case "1": // this is a string bc nextline
                    maxNumber = 50;
                    difficultyName = "easy";
                    break;
                case "normal":
                    
                case "2":
                    maxNumber = 100;
                    difficultyName = "normal";
                    break;
                case "hard":
                   
                case "3":
                    maxNumber = 200;
                    difficultyName = "hard";
                    break;
                case "custom":

                case "4":
                    difficultyName = "custom";
                    int[] rangeAgain = customRange();
                    minNumber = rangeAgain[0];
                    maxNumber = rangeAgain[1];
                    System.out.println(String.format(
                    "Selected range: %s-%s",minNumber,maxNumber)
                    );
                    break;
                default:
                    System.out.println("Invalid difficulty");
                    continue;
            }
            int numberToGuess = (int) Math.floor(Math.random() * (maxNumber - minNumber + 1)) + minNumber;
            int guesses = 0;
            boolean guessed = false;
            int guess = 0;
            System.out.println("Playing " + difficultyName + " difficulty ("
                    + minNumber + "-" + maxNumber + ")");
            while (!guessed) {
                boolean isInt = scanner.hasNextInt();
                if (isInt) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("Choose a number from " + minNumber + "-" + maxNumber);
                    scanner.nextLine();
                    continue;
                }
                scanner.nextLine();

                if (guess > maxNumber || guess < minNumber) {
                    System.out.println("Choose a number from " + minNumber + "-" + maxNumber);
                } else if (guess > numberToGuess) {
                    guesses++;
                    System.out.println("too high");
                } else if (guess < numberToGuess) {
                    guesses++;
                    System.out.println("too low");
                } else {
                    guesses++;
                    System.out.println("You got it on " + difficultyName + " difficulty!");
                    System.out.println("It took you " + guesses + " guesses!");
                    guessed = true;
                }
            }
            System.out.println("Play again? (y/n)");
            String decision = scanner.nextLine();
            if (decision.toLowerCase().strip().equals("y")) {
                System.out.println("Starting a new game!");
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("== Welcome to guess the number!! ==");
        System.out.println("and you will try to guess it!");
        System.out.println("Ready?");
        play();
        scanner.close();
    }
}

package test;
import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int secret = random.nextInt(50) + 1; // number from 1 to 50
        int maxTries = 6;
        boolean won = false;

        System.out.println("=================================");
        System.out.println("   WELCOME TO THE GUESSING GAME  ");
        System.out.println("=================================");
        System.out.println("I'm thinking of a number between 1 and 50.");
        System.out.println("You have " + maxTries + " tries. Good luck!\n");

        for (int tries = 1; tries <= maxTries; tries++) {
            System.out.print("Try " + tries + " - Your guess: ");
            int guess = input.nextInt();

            if (guess == secret) {
                System.out.println("\nYOU GOT IT! The number was " + secret + "!");
                System.out.println("You needed " + tries + " tries.");

                if (tries <= 2) {
                    System.out.println("Rank: Mind Reader");
                } else if (tries <= 4) {
                    System.out.println("Rank: Smart Player");
                } else {
                    System.out.println("Rank: Lucky Survivor");
                }
                won = true;
                break;
            } else if (Math.abs(guess - secret) <= 5) {
                System.out.println("Burning hot! Very close!");
            } else if (guess < secret) {
                System.out.println("Too low. Go higher!");
            } else {
                System.out.println("Too high. Go lower!");
            }
        }

        if (!won) {
            System.out.println("\nGame over! The number was " + secret + ".");
            System.out.println("Better luck next time!");
        }

        input.close();
    }
}
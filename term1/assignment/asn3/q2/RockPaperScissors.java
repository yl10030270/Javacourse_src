package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>
 * An application that plays the Rock-Paper-Scissors game against the computer.
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class RockPaperScissors {
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {

        final int randomLimit = 3;
        String personPlay; // User's play -- "R", "P", or "S"
        String computerPlay; // Computer's play -- "R", "P", or "S"
        int computerInt; // Randomly generated number used to determine
                         // computer's play
        int wins = 0;
        int looses = 0;
        int ties = 0;
        boolean keepplaying = true;
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        System.out.println("Game start!Type \"quit\" to stop.");
        System.out.println();
        do {
            // Get player's play
            System.out.print("Eenter your play(R,P,S): ");
            // Make player's play
            personPlay = scan.nextLine().toUpperCase();
            // Generate computer's play
            if (personPlay.equalsIgnoreCase("quit")) {
                keepplaying = false;
            } else if (personPlay.equalsIgnoreCase("R")
                    || personPlay.equalsIgnoreCase("P")
                    || personPlay.equalsIgnoreCase("S")) {
                computerInt = generator.nextInt(randomLimit);
                switch (computerInt) {
                case 0:
                    computerPlay = "R";
                    break;
                case 1:
                    computerPlay = "P";
                    break;
                default:
                    computerPlay = "S";
                    break;
                }
                // Print computer's play
                System.out.println("Computer play is " + computerPlay);

                if (personPlay.equals(computerPlay)) {
                    ties++;
                    System.out.println("It's a tie!");
                } else if (personPlay.equals("R")) {
                    if (computerPlay.equals("S")) {
                        wins++;
                        System.out.println("Rock crushes scissors. You win!!");
                    } else {
                        looses++;
                        System.out.println("You lose.");
                    }
                } else if (personPlay.equals("S")) {
                    if (computerPlay.equals("R")) {
                        looses++;
                        System.out.println("You lose.");
                    } else {
                        wins++;
                        System.out.println("You win!!");
                    }
                } else {
                    if (computerPlay.equals("S")) {
                        looses++;
                        System.out.println("You lose.");
                    } else {
                        wins++;
                        System.out.println("You win!!");
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
        } while (keepplaying);

        System.out.println();
        System.out.println("You wons:" + wins + " You looses:" + looses
                + " You ties:" + ties);
        System.out.println();
        System.out.println("Question two was called and ran sucessfully.");
    }

};

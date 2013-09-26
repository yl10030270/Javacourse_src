package lab7;

//************************************************************
//Rock.java
//
//Play Rock, Paper, Scissors with the user
//
//************************************************************
import java.util.Scanner;
import java.util.Random;

public class Rock {
    public static void main(String[] args) {
        String personPlay; // User's play -- "R", "P", or "S"
        String computerPlay; // Computer's play -- "R", "P", or "S"
        int computerInt; // Randomly generated number used to determine
                         // computer's play
        String keepplaying = "y";
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        do{
            System.out.print("Eenter your play(R,P,S): ");// Get player's play --
                                                          // note that this is
                                                          // stored as a string
            personPlay = scan.nextLine().toUpperCase();// Make player's play
                                                       // uppercase for ease of
                                                       // comparison
            computerInt = generator.nextInt(3);// Generate computer's play (0,1,2)
            // System.out.println(computerInt);
            // Translate computer's randomly generated play to string
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
            System.out.println("Computer play is " + computerPlay); // Print
                                                                    // computer's
                                                                    // play
            // See who won. Use nested ifs instead of &&.
            if (personPlay.equals(computerPlay)) {
                System.out.println("It's a tie!");
            } else if (personPlay.equals("R")) {
                if (computerPlay.equals("S")) {
                    System.out.println("Rock crushes scissors. You win!!");
                } else {
                    System.out.println("You lose.");
                }
            } else if (personPlay.equals("S")){
                if (computerPlay.equals("R")){
                    System.out.println("You lose.");
                } else {
                    System.out.println("You win!!");
                }
            } else {
                if (computerPlay.equals("S")) {
                    System.out.println("You lose.");
                } else {
                    System.out.println("You win!!");            
                }
            }
            System.out.print("You want to play again?(y/n)");
            keepplaying = scan.nextLine();
        } while (keepplaying.equalsIgnoreCase("y"));
        System.out.println();
        System.out.println("Game Over!");        
        // ... Fill in rest of code
    }
}

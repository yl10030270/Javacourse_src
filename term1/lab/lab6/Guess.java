package lab6;

//************************************************************
//Guess.java
//
//Play a game where the user guesses a number from 1 to 10
//
//************************************************************
import java.util.Scanner;
import java.util.Random;

public class Guess {
    public static void main(String[] args) {
        int numToGuess; // Number the user tries to guess
        int guess; // The user's guess
        int count = 1;// how much time take the use to guess
        int toohigh = 0;//how much guess too high
        int toolow = 0;//how much guess too low
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        numToGuess = generator.nextInt(10) + 1;// randomly generate the number
                                               // to guess
        //System.out.println(numToGuess);
        System.out.print("Please enter a guess(1 to 10):");// print message
                                                           // asking user to
                                                           // enter a guess
        guess = scan.nextInt();// read in guess
        while (guess != numToGuess) // keep going as long as the guess is wrong
        {
            count++;
            if (guess > numToGuess) {
                System.out.println("it is too high.");
                toohigh++;
            } else {
                System.out.println("it is too low.");
                toolow++;
            }
            System.out.print("Guess is wrong,guess again:");// print message
                                                            // saying guess is
                                                            // wrong
            guess = scan.nextInt();// get another guess from the user
        }
        
        System.out.println();
        System.out.println("Congratulations!You got it!");// print message saying
                                                        // guess is right
        System.out.println("It takes you " + count
                + " guesses to get the number. ");// print message saying guess
                                                 // is right
        System.out.println(toohigh + " guesses too high and " + toolow + " guesses too low.");
    }
}
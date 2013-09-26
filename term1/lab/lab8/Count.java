package lab8;

//************************************************************
//Count.java
//
//This program reads in strings (phrases) and counts the
//number of blank characters and certain other letters
//in the phrase.
//************************************************************
import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        String phrase=""; // a string of characters
        int countBlank; // the number of blanks (spaces) in the phrase
        int length; // the length of the phrase
        //char ch; // an individual character in the string
        int countA = 0;
        int countE = 0;
        int countS = 0;
        int countT = 0;
        countBlank = 0;
        //String keepdoing = "";
        Scanner scan = new Scanner(System.in);
        // Print a program header
        System.out.println();
        System.out.println("Character Counter");
        System.out.println();
        // Read in a string and find its length
        System.out.print("Enter a sentence or phrase: ");
        while (!phrase.equalsIgnoreCase("quit")) {
            phrase = scan.nextLine();
            length = phrase.length();
            // Initialize counts
            // a for loop to go through the string character by character
            // and count the blank spaces

            for (int i = 0; i < length; i++) {
                switch (phrase.charAt(i)) {
                case 'a':
                    countA++;
                    break;
                case 'A':
                    countA++;
                    break;
                case 'e':
                    countE++;
                    break;
                case 'E':
                    countE++;
                    break;
                case 's':
                    countS++;
                    break;
                case 'S':
                    countS++;
                    break;
                case 't':
                    countT++;
                    break;
                case 'T':
                    countT++;
                    break;
                case ' ':
                    countBlank++;
                    break;
                default:
                    break;
                }
                // if (phrase.charAt(i)==' '){
                // countBlank++;
                // }               
            }
            System.out.print("Type \"quit\" to quit.or continue to enter: ");
            
        }
        // Print the results
        System.out.println();
        System.out.println("Number of blank spaces: " + countBlank);
        System.out.println("Number of character 'A': " + countA);
        System.out.println("Number of character 'E': " + countE);
        System.out.println("Number of character 'S': " + countS);
        System.out.println("Number of character 'T': " + countT);
        System.out.println();
    }
}
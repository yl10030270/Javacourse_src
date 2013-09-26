package q;

//***************************************************************
//StringManips.Java
//
//Test several methods for manipulating String objects
//***************************************************************
import java.util.Scanner;

public class StringManips {
    public static void main(String[] args) {
        String phrase = new String("This is a String test.");
        int phraseLength; // number of characters in the phrase String
        int middleIndex; // index of the middle character in the String
        String firstHalf; // first half of the phrase String
        String secondHalf; // second half of the phrase String
        String switchedPhrase; // a new phrase with original halves switched
        String middle3;
        String city;
        String state;
        String formatString;

        // compute the length and middle index of the phrase
        phraseLength = phrase.length();
        //System.out.println(phraseLength);
        middleIndex = phraseLength / 2;

        // get the substring for each half of the phrase
        firstHalf = phrase.substring(0, middleIndex);
        secondHalf = phrase.substring(middleIndex, phraseLength);
        middle3 = phrase.substring(middleIndex - 1, middleIndex + 2);
        
        // concatenate the firstHalf at the end of the secondHalf
        switchedPhrase = secondHalf.concat(firstHalf);
        switchedPhrase = switchedPhrase.replace(" ", "*");

        // print information about the phrase
        System.out.println();
        System.out.println("Original phrase: " + phrase);
        System.out.println("Length of the phrase: " + phraseLength
                + " characters");
        System.out.println("Index of the middle: " + middleIndex);
        System.out.println("Character at the middle index: "
                + phrase.charAt(middleIndex));
        System.out.println("Switched phrase: " + switchedPhrase);
        System.out.println();
        //System.out.println(phrase.substring(middleIndex, middleIndex + 1));

        System.out.println("The middle three Charactor of the phrase:"
                + middle3);
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your hometown");
        System.out.print("Your city:");
        city = scan.nextLine();
        System.out.print("Your state:");
        state = scan.nextLine();
        
        state = state.toUpperCase();
        city = city.toLowerCase();
//        System.out.print(state);
        formatString = state + city + state; 
        System.out.println(formatString);
    }
}
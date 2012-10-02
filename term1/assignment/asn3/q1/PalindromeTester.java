package q1;

import java.util.Scanner;

/**
 * <p>
 * PalindromeTester program, spaces, punctuation, and
 * changes in uppercase and lowercase are not considered.
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class PalindromeTester {
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        // your code will go here!!!
        String str;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the sentence,please!");
        str = scan.nextLine();
        if (str.length() == 0) {
            System.out.println("The input is empty.");
        } else if (letterCount(str) == 0) {
            System.out.println("There is no letter in the input.");
        } else if (letterCount(str) == 1) {
            System.out.println("It's a one letter input."
                    + "It is a special palindrome.");
        } else {
            System.out.println("This String is"
                    + ((isPalindrome(str)) ? "" : " not") + " a palindrome");
        }
        System.out.println();
        System.out.println("Question one was called and ran sucessfully.");
    }

    /**
     * Check if the string contains a letter.
     * 
     * @param str
     *            input string.
     * @return how much letter the string contains.
     */
    private static int letterCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                    || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    || (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                count++;
            }
        }
        return count;
    }

    /**
     * Check if the string is a palindrome.
     * 
     * @param str
     *            input string.
     * @return boolean return true if the string is a palindrome, otherwise
     *         false.
     */
    private static boolean isPalindrome(String str) {
        int r;
        int l = 0;
        r = str.length() - 1;
        while (l < r) {
            while (!(str.charAt(l) >= 'A' && str.charAt(l) <= 'Z')
                    && !(str.charAt(l) >= 'a' && str.charAt(l) <= 'z')
                    && !(str.charAt(l) >= '0' && str.charAt(l) <= '9')) {
                l++;
            }
            while (!(str.charAt(r) >= 'A' && str.charAt(r) <= 'Z')
                    && !(str.charAt(r) >= 'a' && str.charAt(r) <= 'z')
                    && !(str.charAt(r) >= '0' && str.charAt(r) <= '9')) {
                r--;
            }
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

};

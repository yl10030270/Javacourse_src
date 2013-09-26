package lab6;

import java.util.Scanner;

public class Factorials {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int f = 1;// Factorials
        int n;// input number
        // int c = 1;//count number
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an integer:");
        n = sc.nextInt();
        while (n < 0) {
            System.out.println("a nonnegative number is required"
                    + ", please enter another number.");
            n = sc.nextInt();
        }
        if (n == 0) {
            System.out.println();
            System.out.println("0!=1");
        } else {
            String outputString = n + "!=1";
            for (int i = 2; i <= n; i++) {
                outputString += "*" + i;
                // System.out.println(outputString);
            }
            while (n >= 1) {
                f *= n;
                n--;
            }
            System.out.println();
            System.out.println(outputString + "=" + f);
            // TODO Auto-generated method stub
        }
    }

}

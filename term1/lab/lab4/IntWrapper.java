package lab4;

import java.util.Scanner;

public class IntWrapper {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int num;
        String int1;
        String int2;
        
        Scanner scan = new Scanner(System.in);
        System.out.print("please enter an integer:");
        num = scan.nextInt();
        System.out.println("The integer in base 2 is: "
                + Integer.toBinaryString(num));
        System.out.println("The integer in base 8 is: "
                + Integer.toOctalString(num));
        System.out.println("The integer in base 16 is: "
                + Integer.toHexString(num));
        System.out.println("The Max integer is: " + Integer.MAX_VALUE);
        System.out.println("The Mix integer is: " + Integer.MIN_VALUE);
        System.out.println();

        System.out.print("Please enter the first integer:");
        int1 = scan.next();
        System.out.print("Please enter the second integer:");
        int2 = scan.next();
        System.out.print(int1 + " + " + int2 + " = "  
                + (Integer.parseInt(int1) + Integer.parseInt(int2)));
        
        // TODO Auto-generated method stub

    }

}

package lab8;

import java.util.Scanner;


public class Comparisons {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String val1;
        String val2;
        String val3;
        int i1;
        int i2;
        int i3;
        Scanner scan= new Scanner(System.in);
        System.out.print("Please enter the first string:");
        val1 = scan.nextLine();
        System.out.print("Please enter the second string:");
        val2 = scan.nextLine();
        System.out.print("Please enter the third string:");
        val3 = scan.nextLine();
        System.out.println("The largest string is :" + Compare3.largest(val1,val2,val3));
        System.out.println();
        System.out.print("Please enter the first integer:");
        i1 = scan.nextInt();
        System.out.print("Please enter the second integer:");
        i2 = scan.nextInt();
        System.out.print("Please enter the third integer:");
        i3 = scan.nextInt();
        System.out.println("The largest integer is :" + Compare3.largest(i1,i2,i3));
        
        
    }

}

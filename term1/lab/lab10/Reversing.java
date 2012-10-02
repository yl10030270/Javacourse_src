package lab10;

import java.util.Scanner;

public class Reversing {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        
        System.out.print("How much values you have? ");
        int number = scan.nextInt();
        while(number <= 0){
            System.out.print("Illegal intput, try again:  ");
            number = scan.nextInt();
        }
        double[] values = new double[number];
        scan.nextLine();
        System.out.print("Please enter the values wiht space between them: ");
        for (int i = 0; i < number; i++) {
            values[i] = scan.nextDouble();
        }
        for (double x : values) {
            System.out.print(x + "\t");
        }
        //System.out.println();
        int s = 0;
        int e = values.length - 1;
        double temp = 0;
        do {
            temp = values[s];
            values[s] = values[e];
            values[e] = temp;
            s++;
            e--;
        } while (s < e);
        System.out.println("\nAfter reversing:");
        for (double x : values) {
            System.out.print(x + "\t");
        }
    }

}

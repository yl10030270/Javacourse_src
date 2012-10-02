package lab10;

//***************************************************************
//Sales.java
//
//Reads in and stores sales for each of 5 salespeople. Displays
//sales entered by salesperson id and total sales for all salespeople.
//
//***************************************************************
import java.text.NumberFormat;
import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {
        int SALESPEOPLE = 5;
        int sum;
        int maxman = 0;
        int maxsale = Integer.MIN_VALUE;
        int minman = 0;
        int minsale = Integer.MAX_VALUE;
        double average;
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the number of sales people: ");
        SALESPEOPLE = scan.nextInt();
        int[] sales = new int[SALESPEOPLE];
        for (int i = 0; i < sales.length; i++) {
            System.out.print("Enter sales for salesperson " + (i+1) + ": ");
            sales[i] = scan.nextInt();
            if (maxsale < sales[i]) {
                maxsale = sales[i];
                maxman = i + 1;
            }
            if (minsale > sales[i]){
                minsale = sales[i];
                minman = i + 1;
            }
        }
        System.out.println("\nSalesperson Sales");
        System.out.println(" ------------------ ");
        sum = 0;
        for (int i = 0; i < sales.length; i++) {
            System.out.println(" " + (i+1) + " " + sales[i]);
            sum += sales[i];
        }
        average = sum / SALESPEOPLE;
        System.out.println("\nTotal sales: " + sum);
        System.out.println("The average: " + average);
        System.out.println("Salesperson " + maxman
                + " had the highest sale with " + fmt.format(maxsale) + ".");
        System.out.println("Salesperson " + minman
                + " had the lowest sale with " + fmt.format(minsale) + ".");
        System.out.print("\nPlease enter a value: ");
        int line;
        sum = 0;
        line = scan.nextInt();
        System.out.println("\nSalesperson Sales");
        System.out.println(" ------------------ ");
        for (int i = 0; i < sales.length; i++){
            if (sales[i] > line){
                System.out.println(" " + (i+1) + " " + sales[i]);
                sum += sales[i];
            }
        }
        System.out.println("\nTotal sales for who exceeded the line: " + sum);
        
    }
}
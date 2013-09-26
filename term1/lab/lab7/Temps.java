package lab7;

import java.util.Scanner;

public class Temps {
    // --------------------------------------------------
    // Reads in a sequence of temperatures and finds the
    // maximum and minimum read in.
    // --------------------------------------------------
    public static void main(String[] args) {
        final int HOURS_PER_DAY = 6;
        int temp; // a temperature reading
        int maxTemp = -1000;
        int minTemp = 999999;
        int timeOfMax = -11111;
        int timeOfMin = 999999;
        Scanner scan = new Scanner(System.in);
        // print program heading
        System.out.println();
        System.out.println("Temperature Readings for 24 Hour Period");
        System.out.println();
        for (int hour = 0; hour < HOURS_PER_DAY; hour++) {
            System.out.print("Enter the temperature reading at " + hour
                    + " hours: ");
            temp = scan.nextInt();
            //maxTemp = (maxTemp > temp)? maxTemp : temp;
            if (maxTemp < temp){
                maxTemp = temp;
                timeOfMax = hour;
            }
            if (minTemp > temp){
                minTemp = temp;
                timeOfMin = hour;
            }
        }
        
        System.out.println();// Print the results
        System.out.println("The maximum is :" + maxTemp);// Print the results
        System.out.println("The time of getting the maximum is :" + timeOfMax);// Print the results
        System.out.println();// Print the results
        System.out.println("The miximum is :" + minTemp);// Print the results
        System.out.println("The time of getting the miximum is :" + timeOfMin);// Print the results
    }
}

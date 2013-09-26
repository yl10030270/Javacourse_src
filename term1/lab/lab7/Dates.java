package lab7;

//************************************************************
//Dates.java
//
//Determine whether a 2nd-millenium date entered by the user
//is valid
//************************************************************
//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Dates {
    public static void main(String[] args) {
        int month=0, day=0, year=0; // date read in from user
        //boolean daysInMonth; // number of days in month read in
        boolean monthValid, yearValid, dayValid; // true if input from user is
                                                 // valid
        boolean leapYear; // true if user's year is a leap year
        String input1, input2, input3;
        String keepdoing;
        Scanner scan = new Scanner(System.in);
        // Get integer month, day, and year from user
        // Check to see if year is valid
        do {
            keepdoing = "n";
            System.out.print("Please enter year(1000-1999): ");
            input1 = scan.nextLine();
            yearValid = isInt(input1) && Integer.parseInt(input1) >= 1000
                    && Integer.parseInt(input1) <= 1999;
            if (yearValid) {
                year = Integer.parseInt(input1);
            } else {
                System.out.print("Date(year) is not valid."
                        + "You want to redo it and continue?(y/n)");
                keepdoing = scan.nextLine();
                if (!keepdoing.equalsIgnoreCase("y")){
                    System.exit(0);
                }
            }
        } while (keepdoing.equalsIgnoreCase("y"));
        // Check to see if month is valid
        do {
            keepdoing = "n";
            System.out.print("please enter month: ");
            input2 = scan.nextLine();
            monthValid = isInt(input2) && Integer.parseInt(input2) >= 1
                    && Integer.parseInt(input2) <= 12;
            if (monthValid) {
                month = Integer.parseInt(input2);
            } else {
                System.out.print("Date(month) is not valid."
                        + "You want to redo it and continue?(y/n)");
                keepdoing = scan.nextLine();
                if (!keepdoing.equalsIgnoreCase("y")){
                    System.exit(0);
                }
            }
        } while (keepdoing.equalsIgnoreCase("y"));
        // Determine whether it's a leap year
        leapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        // Determine number of days in month

        // User number of days in month to check to see if day is valid
        // Determine whether date is valid and print appropriate message
        do {
            keepdoing = "n";
            System.out.print("please enter day: ");
            input3 = scan.nextLine();
            dayValid = isInt(input3) && dayInMonth(input3, month, leapYear);
            if (dayValid) {
                day = Integer.parseInt(input3);
            } else {
                System.out.print("Date(day) is not valid."
                        + "You want to redo it and continue?(y/n)");
                keepdoing = scan.nextLine();
                if (!keepdoing.equalsIgnoreCase("y")){
                    System.exit(0);
                }
            }
        } while (keepdoing.equalsIgnoreCase("y"));
       System.out.println();
       System.out.println(year + "-" + month + "-" + day);
       System.out.println("Date is valid.");
       if (leapYear){
           System.out.println("It is a leapYear");
       }
       
    }

    /**
     * Test the input.If it is an integer return true or return false.
     * 
     * @param s
     *            the input string
     * @return if the input is an integer
     */
    private static boolean isInt(String test) {
        if (test.equals("")){
            return false;
        }
        // String test;
        // test = s.replace(" ", "");
        // test = test.replace("-", "");
        // test = test.replace("/", "");
        // System.out.println(test);
        int count = 0;
        ArrayList<String> num = new ArrayList<String>();
        for (int i = 0; i <= 9; i++) {
            num.add("" + i);
        }
        for (int i = 0; i < test.length(); i++) {
            for (String a : num) {
                if (test.substring(i, i + 1).equals(a)) {
                    count++;
                    break;
                }
            }
        }
        if (count == test.length()) {
            return true;
        } else {
            return false;
        }
    }
    
    private static boolean dayInMonth(String s, int month, boolean leapyear){
        int dayinmonth;
        boolean ok = false;
        ArrayList<String> bigmonth = new ArrayList<String>();
        for(int i = 1;i <= 7;i += 2){
          bigmonth.add("" + i);
        }
        for(int i = 8;i <= 12;i += 2){
          bigmonth.add("" + i);
        }
        dayinmonth = Integer.parseInt(s);
        if (dayinmonth > 0) {
            if (month != 2){
                if (dayinmonth < 31){
                    ok = true;
                }
                if (dayinmonth == 31){
                    for(String a : bigmonth){
                      if (("" + month).equals(a)){
                          ok = true;
                          break;
                      }    
                    }
                }
            } else {
                if (dayinmonth < 29){
                    ok = true;
                }
                if (dayinmonth == 29){
                    if (leapyear){
                        ok = true;
                    }
                }
            }    
        }
        return ok;
    }
}
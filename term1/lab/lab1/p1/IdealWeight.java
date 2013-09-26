package p1;
import java.util.Scanner;
public class IdealWeight {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int feet;
        int inch;
        int total;
        final int IW = 5 * 12;
        int idealmale;
        int idealfemale;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter his/her height in feet and inches:");
        System.out.print("feet(>=5)=: ");
        feet = scan.nextInt();
        System.out.print("inch(>=0)=: ");
        inch = scan.nextInt();
        total = feet * 12 + inch;
        idealmale = 106 + (total - IW)*6;
        idealfemale = 100 + (total - IW)*5;
        System.out.println("The Ideal Weight for male should be "+ idealmale 
                + " pounds.");
        System.out.println("The Ideal Weight for female should be " 
                + idealfemale + " pounds.");
        System.out.println("The Okay range for male should be from " 
                + (idealmale * (1 - (float)15 / 100)) + " to " 
                + (idealmale * (1 + (float)15 / 100)) + " pounds.");
        System.out.println("The Okay range for female should be from " 
                + (idealfemale * (1 - (float)15 / 100)) + " to " 
                + (idealfemale * (1 + (float)15 / 100)) + " pounds.");
    }

}

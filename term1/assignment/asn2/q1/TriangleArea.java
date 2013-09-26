package q1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <p>
 * that reads the lengths of the sides of a triangle from the user. Compute the
 * perimeter and area of the triangle and print the values to three decimal
 * places.
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class TriangleArea {
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        double a; // first side of the triangle
        double b; // second side
        double c; // third side
        double p; // perimeter
        double s; // half perimeter
        double area;
        double longestSide; // the longest side of the triangle

        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the first side of the triangle:");
        a = scan.nextDouble();
        System.out.print("Please enter the second side of the triangle:");
        b = scan.nextDouble();
        System.out.print("Please enter the third side of the triangle:");
        c = scan.nextDouble();

        p = a + b + c; // calculate the perimeter
        s = p / 2;

        longestSide = maxofThree(a, b, c); //get the longest side
        
        // validating if the three inputs can make a triangle
        // if they can , calculate the area and print out the result
        // if they can not , notice the user
        
        if (longestSide < s) {
            area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            DecimalFormat fmt = new DecimalFormat("#.###");
            System.out.println();
            System.out.println("The perimeter of this triangle is:"
                    + fmt.format(p));
            System.out.println("The area of this triangle is:"
                    + fmt.format(area));
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Your three inputs can not make a triangle");
            System.out.println();
        }
        // your code will go here!!!
        System.out.println("Question one was called and ran sucessfully.");
    }

    /**
     * Get the largest number of three input.
     * 
     * @param a
     *            the first number
     * @param b
     *            the second number
     * @param c
     *            the third number
     * @return The biggest number of these three
     */
    private static double maxofThree(double a, double b, double c) {
        double max;
        if (a > b) {
            if (a > c) {
                max = a;
            } else {
                max = c;
            }
        } else if (b > c) {
            max = b;
        } else {
            max = c;
        }
        return max;

    }

};

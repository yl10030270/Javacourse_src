package q2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <p>
 * reads the radius and height of a cylinder from users and prints its surface
 * area and volume.
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class CylinderStats {
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
        double ridus;
        double height;
        double area;
        double volume;
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the ridus of the cylinder:");
        ridus = scan.nextDouble();
        System.out.print("Please enter the height of the cylinder:");
        height = scan.nextDouble();
        area = 2 * Math.PI * ridus * (ridus + height);
        volume = Math.PI * Math.pow(ridus, 2) * height;
        DecimalFormat fmt = new DecimalFormat("#.####");
        System.out.println();
        System.out.println("The surface area of this cylinder is:"
                + fmt.format(area));
        System.out.println("The volume of this cylinder is :"
                + fmt.format(volume));
        System.out.println();
        System.out.println("Question two was called and ran sucessfully.");
    }

};

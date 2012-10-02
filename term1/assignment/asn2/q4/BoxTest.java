package q4;

import java.util.Scanner;

/**
 * <p>
 * Text box class.
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class BoxTest {
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        final double secondh = 3.4;
        final double secondw = 2.1;
        final double secondd = 3;
        String fullString;
        double h;
        double w;
        double d;
        Box b1;
        Box b2;

        // instantiate and update the first box using instructor
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the height of the first box:");
        h = scan.nextDouble();
        System.out.print("Please enter the width of the first box:");
        w = scan.nextDouble();
        System.out.print("Please enter the depth of the first box:");
        d = scan.nextDouble();
        b1 = new Box(h, w, d);
        System.out.print("Please enter \"1\" if the box is full "
                + "or enter \"0\":");
        if (scan.nextInt() == 1) {
            b1.setFull();
        }

        // instantiate and update the first box using getter and setter
        b2 = new Box(secondh, secondw, secondd);
        System.out.println();
        System.out.print("The second box's hight is " + b2.getHeight()
                + ".You want to change it to:");
        b2.setHeight(scan.nextDouble());
        System.out.print("The second box's width is " + b2.getWidth()
                + ".You want to change it to:");
        b2.setWidth(scan.nextDouble());
        System.out.print("The second box's depth is " + b2.getDepth()
                + ".You want to change it to:");
        b2.setDepth(scan.nextDouble());
        if (b2.getFull()) {
            fullString = "full";
        } else {
            fullString = "empty";
        }
        System.out.print("The second box is " + fullString
                + " now.\nEnter \"1\" if you want to fill it or enter \"0\":");
        if (scan.nextInt() == 1) {
            b2.setFull();
        }

        System.out.println();
        System.out.println("The first box:" + b1);
        System.out.println("The second box:" + b2);

        // your code will go here!!!
        System.out.println();
        System.out.println("Question four was called and ran sucessfully.");
    }
};

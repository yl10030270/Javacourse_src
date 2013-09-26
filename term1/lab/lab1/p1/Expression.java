package p1;

/**
 *Names.java.
 * @author Lewis
 * @author Loftus
 * @version 1
 */

public class Expression {
    /**
     *Names.java.
     *
     *Prints a list of student names with their hometowns
     *and intended major
     *@param args unused
     */
    public static void main(String[] args) {
        
        int a = 3;
        int b = 10;
        int c = 7;
        double w = 12.9;
        double y = 3.2;
        
        System.out.println(a + b * c);
        System.out.println(a - b - c);
        System.out.println(a / b);
        System.out.println(b / a);
        System.out.println(a - b / c);
        System.out.println(w / y);
        System.out.println(y / w);
        System.out.println(a + w / b);
        System.out.println(a % b / y);
        System.out.println(b % a);
        System.out.println(w % y);               
    }      
}

package p1;

public class Circle2 {
    
    public static void main(String[] args) {
        final double PI = 3.14159;
        int radius = 10;
        double area1 = PI * radius * radius;
        double circ1 = 2 * PI * radius;
        double area2 ;
        double circ2 ;
        double areagr ;
        double circgr ;
        System.out.println("The area of a circle with radius " + radius 
                + " is " + area1);
        System.out.println("The circumference of a circle with radius " 
                + radius + " is " + circ1);
        radius = 20;
        area2 = PI * Math.pow(radius , 2);
        circ2 = 2 * PI * radius;
        System.out.println("The area of a circle with radius " 
                + radius + " is " + area2);
        System.out.println("The circumference of a circle with radius " 
                + radius + " is " + circ2);
        areagr = area2 / area1 ;
        circgr = circ2 / circ1 ;
        System.out.println("The second area is " + areagr 
                + " times of first area");
        System.out.println("The second circumference is " + circgr
                + " times of first circumference");
    }
}
package p1;

public class Circle {
    
    public static void main(String[] args) {
        final double PI = 3.14159;
        int radius = 10;
        double area = PI * radius * radius;
        double circ = 2 * PI * radius;
        System.out.println("The area of a circle with radius " + radius 
                + " is " + area);
        System.out.println("The circumference of a circle with radius " 
                + radius + " is " + circ);
        radius = 20;
        area = PI * Math.pow(radius , 2);
        circ = 2 * PI * radius;
        System.out.println("The area of a circle with radius " 
                + radius + " is " + area);
        System.out.println("The circumference of a circle with radius " + radius 
                + " is " + circ);
    }
}
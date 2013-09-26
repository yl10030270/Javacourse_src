package p1;

import java.util.Scanner;
public class Try2
{
public static void main (String[] args)
{
int one, two, three;
double what;
Scanner scan = new Scanner(System.in);
System.out.print ("Enter two integers: ");
one = scan.nextInt();// one=10
two = scan.nextInt();// two=3
System.out.print("Enter a floating point number: ");
what = scan.nextDouble() ;// what=14.3
three = 4 * one + 5 * two; // three=4*10+5*3=55
two = 2 * one;//two=2*10=20
System.out.println ("one " + two + ":" + three); //one 20:55
one = 46 / 5 * 2 + 19 % 4; //one=46/5*2+19%4=9*2+3=18+3=21
three = one + two;//three=21+20=41
what = (what + 2.5) / 2 ;//what=(14.3+2.5)/2=16.8/2=8.4
System.out.println (what + " is what!");
}
}
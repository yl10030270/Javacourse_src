package lab9;

import java.util.Scanner;

public class DrunkenWalk {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
      int maxSteps; // maximum number of steps in a walk
      int maxCoord; // the maximum x and y coordinate
      int numDrunks;
      int numfall = 0;
      Scanner scan = new Scanner(System.in);
      System.out.println("\nDrunks Walk  Program");
      System.out.println();
      System.out.print("Enter the boundary for the square: ");
      maxCoord = scan.nextInt();
      System.out.print("Enter the maximum number of steps: ");
      maxSteps = scan.nextInt();
      System.out.print("Enter the number of drunks: ");
      numDrunks = scan.nextInt();
      
      for(int i=1;i <= numDrunks;i++){
          RandomWalk drunk = new RandomWalk(maxSteps,maxCoord);
          drunk.walk();
          System.out.println(drunk);
          if(!drunk.inBounds()){
              numfall++;
          }
      }
      System.out.println("The times of the drunk falling off is " + numfall);
    }

}

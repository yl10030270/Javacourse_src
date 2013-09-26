package lab4;

//************************************************************
//Student.java
//
//Define a student class that stores name, score on test 1, and
//score on test 2. Methods prompt for and read in grades,
//compute the average, and return a string containing student's info.
//************************************************************
import java.util.Scanner;

public class Student {
    // declare instance data
    // ---------------------------------------------
    private String name;
    private double score1;
    private double score2;
    // constructor
    // ---------------------------------------------
    public Student(String studentName) {
        name = studentName;
        // add body of constructor
    }

    // ---------------------------------------------
    // inputGrades: prompt for and read in student's grades for test1 and test2.
    // Use name in prompts, e.g., "Enter's Joe's score for test1".
    // ---------------------------------------------
    public void inputGrades() {
        // add body of inputGrades
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter's " + name + "'s score for test1:");
        score1 = scan.nextDouble();
        System.out.print("Enter's " + name + "'s score for test2:");
        score2 = scan.nextDouble();
    }

    // ---------------------------------------------
    // getAverage: compute and return the student's test average
    // ---------------------------------------------
    // add header for getAverage
    public double getAverage() {
        // add body of getAverage
        return (score1 + score2) / 2;
    }
    // ---------------------------------------------
    // getName: print the student's name
    // ---------------------------------------------
    // add header for printName
    public String getName() {
        // add body of printName
        return name;
    }
    public String toString() {
        return "name:\t" + name + "\ttext1:\t" + score1 + "\ttext2:\t" + score2;
    }
}

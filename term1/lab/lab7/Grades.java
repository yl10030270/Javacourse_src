package lab7;

//************************************************************
//Grades.java
//
//Read in a sequence of grades and compute the average
//grade, the number of passing grades (at least 60)
//and the number of failing grades.
//************************************************************
import java.util.Scanner;

public class Grades {
    // -----------------------------------------------------------------
    // Reads in and processes grades until a negative number is entered.
    // -----------------------------------------------------------------
    public static void main(String[] args) {
        double grade; // a student's grade
        double sumOfGrades; // a running total of the student grades
        int numStudents; // a count of the students
        int numPass; // a count of the number who pass
        int numFail; // a count of the number who fail
        Scanner scan = new Scanner(System.in);
        System.out.println("\nGrade Processing Program\n");
        // Initialize summing and counting variables
        sumOfGrades = 0;
        numStudents = 0;
        numPass = 0;
        numFail = 0;
        //int a;
        // Read in the first grade
        System.out.print("Enter the first student's grade: ");
        grade = scan.nextDouble();
        while (grade >= 0) {
            sumOfGrades += grade;
            numStudents++;
            
//            if (grade < 60)
//                numFail++;
//                else
//                numPass++;
            
            numFail += (grade < 60)? 1 : 0 ;
            numPass += (grade < 60)? 0 : 1 ;

            // Read the next grade
            System.out.print("Enter the next grade (a negative to quit): ");
            grade = scan.nextDouble();
        }
        if (numStudents > 0) {
            System.out.println("\nGrade Summary: ");
            System.out.println("Class Average: " + sumOfGrades / numStudents);
            System.out.println("Number of Passing Grades: " + numPass);
            System.out.println("Number of Failing Grades: " + numFail);
        } else
            System.out.println("No grades processed.");
    }
}

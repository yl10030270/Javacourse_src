package lab11;

//***************************************************************
//Square.java
//
//Define a Square class with methods to create and read in
//info for a square matrix and to compute the sum of a row,
//a col, either diagonal, and whether it is magic.
//
//***************************************************************
import java.util.Scanner;

public class Square {
    int[][] square;
    int size;

    // --------------------------------------
    // create new square of given size
    // --------------------------------------
    public Square(int size) {
        square = new int[size][size];
        this.size = size;
    }

    // --------------------------------------
    // return the sum of the values in the given row
    // --------------------------------------
    public int sumRow(int row) {
        int rowsum = 0;
        for (int i = 0; i < square[row].length; i++) {
            rowsum += square[row][i];
        }
        return rowsum;
    }

    // --------------------------------------
    // return the sum of the values in the given column
    // --------------------------------------
    public int sumCol(int col) {
        int csum = 0;
        for (int i = 0; i < square[col].length; i++) {
            csum += square[i][col];
        }
        return csum;
    }

    // --------------------------------------
    // return the sum of the values in the main diagonal
    // --------------------------------------
    public int sumMainDiag() {
        int mdsum = 0;
        for (int i = 0; i < size; i++) {
            mdsum += square[i][i];
        }
        return mdsum;
    }

    // --------------------------------------
    // return the sum of the values in the other ("reverse") diagonal
    // --------------------------------------
    public int sumOtherDiag() {
        int odsum = 0;
        for (int i = 0; i < size; i++) {
            odsum += square[i][size - 1 - i];
        }
        return odsum;
    }

    // --------------------------------------
    // return true if the square is magic (all rows, cols, and diags have
    // same sum), false otherwise
    // --------------------------------------
    public boolean magic() {
        int sum;
        sum = sumMainDiag();
        if (this.sumOtherDiag() != sum) {
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                if (sumRow(i) != sum || sumCol(i) != sum) {
                    return false;
                }
            }
            return true;
        }
    }

    // --------------------------------------
    // read info into the square from the input stream associated with the
    // Scanner parameter
    // --------------------------------------
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++)
            for (int col = 0; col < square.length; col++)
                square[row][col] = scan.nextInt();
    }

    // ----------------------------------------
    // print the contents of the square, neatly formatted
    // ----------------------------------------
    public void printSquare() {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.print(square[row][col] + "\t");
            }
            System.out.println();
        }
    }
}

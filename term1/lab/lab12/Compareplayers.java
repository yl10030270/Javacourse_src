package lab12;

//**************************************************************
//ComparePlayers
//
//Reads in two Player objects and tells whether they represent
//the same player.
//**************************************************************
import java.util.Scanner;

public class Compareplayers {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Scanner scan = new Scanner(System.in);
        player1.readPlayer();// Prompt for and read in information for player 1
        player2.readPlayer();// Prompt for and read in information for player 2
        if (player1.equals(player2)) {
            System.out.println("Same player.");
        } else {
            System.out.println("Not same player.");
        }// Compare player1 to player 2 and print a message saying
         // whether they are equal
    }
}

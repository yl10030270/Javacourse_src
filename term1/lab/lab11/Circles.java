package lab11;

//***************************************************************
//Circles.java
//
//Demonstrates mouse events and drawing on a panel.
//Derived from Dots.java in Lewis and Loftus
//*****************************************************************
import javax.swing.JFrame;

public class Circles {
    // ----------------------------------------------------------------
    // Creates and displays the application frame.
    // ----------------------------------------------------------------
    public static void main(String[] args) {
        JFrame circlesFrame = new JFrame("Circles");
        circlesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        circlesFrame.getContentPane().add(new CirclePanel());
        circlesFrame.pack();
        circlesFrame.setVisible(true);
    }
}

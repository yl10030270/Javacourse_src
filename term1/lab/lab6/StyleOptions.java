package lab6;

//********************************************************************
//StyleOptions.java Author: Lewis/Loftus
//
//Demonstrates the use of check boxes.
//********************************************************************
import javax.swing.JFrame;

public class StyleOptions {
    // -----------------------------------------------------------------
    // Creates and presents the program frame.
    // -----------------------------------------------------------------
    public static void main(String[] args) {
        JFrame frame = new JFrame("Style Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StyleOptionsPanel panel = new StyleOptionsPanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
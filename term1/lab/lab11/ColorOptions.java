package lab11;

//********************************************************************
//ColorOptions.java
//
//Uses an array of radio buttons to change the background color.
//********************************************************************
import javax.swing.*;

public class ColorOptions {
    // -----------------------------------------------------------
    // Creates and presents the frame for the color change panel.
    // -----------------------------------------------------------
    public static void main(String[] args) {
        JFrame colorFrame = new JFrame("Color Options");
        colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ColorOptionsPanel panel = new ColorOptionsPanel();
        colorFrame.getContentPane().add(panel);
        colorFrame.pack();
        colorFrame.setVisible(true);
    }
}

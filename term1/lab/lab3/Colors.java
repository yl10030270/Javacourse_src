package q;

//*************************************************************
//Colors.java
//
//Draw rectangles to illustrate colors and their codes in Java
//*************************************************************

import javax.swing.JApplet;
import java.awt.*;

public class Colors extends JApplet {
    public void paint(Graphics page) {
        // Declare size constants
        final int PAGE_WIDTH = 600;
        final int PAGE_HEIGHT = 400;
        // Declare variables
        int x, y; // x and y coordinates of upper left-corner of each shape
        int width, height; // width and height of each shape
        
        //color test
        //Color myColor = new Color(200, 100, 255);
        //Color myColor = new Color(0, 0, 0);
        //Color myColor = new Color(23, 43, 223);
        //Color myColor = new Color(24, 100, 212);
        //Color myColor = new Color(65280);
        //Color myColor = new Color(115);
        Color myColor = new Color(2486921);
        
        
        int redCode = myColor.getRed();
        int blueCode =  myColor.getBlue();
        int greenCode = myColor.getGreen();
        
        // Set the background color and paint the screen with a white rectangle
        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        setBackground(Color.white);
        page.setColor(Color.white);
        page.fillRect(0, 0, PAGE_WIDTH, PAGE_HEIGHT);
        // Set the color for the rectangle
        page.setColor(myColor);
        // Assign the corner point and width and height then draw
        x = 200;
        y = 125;
        width = 200;
        height = 150;
        page.fillRect(x, y, width, height);
        
        page.setColor(Color.yellow);
        page.drawString("Red: " + redCode, width + 20, height + 20 );
        page.drawString("Blue: " + blueCode, 220, 190);
        page.drawString("Green: " + greenCode, 220, 210);
    }
}

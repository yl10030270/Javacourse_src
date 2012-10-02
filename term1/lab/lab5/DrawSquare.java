package lab5;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

public class DrawSquare extends JApplet {
    
    public void paint (Graphics page){
        setBackground(Color.white);
        this.setSize(800, 600);
        page.setColor(getBackground());
        page.fillRect(0, 0, 800, 600);
        //Color parameterColor = new Color();
        
        Square square1 = new Square(34543253);
        Square square2 = new Square(5445353);
        Square square3 = new Square(44424324);
        Square square4 = new Square(10554353);
        Square square5 = new Square(6612345);
        
        square1.draw(page);
        square2.draw(page);
        square3.draw(page);
        square4.draw(page);
        square5.draw(page);
        
        
    }

}
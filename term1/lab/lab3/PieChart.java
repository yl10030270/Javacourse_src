package q;

import javax.swing.JApplet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;


public class PieChart extends JApplet {

    public void paint(Graphics page) {
        setBackground(Color.white);
        this.setSize(800, 800);
        page.setColor(getBackground());
        page.fillRect(0, 0, 800, 800);

        // draw pie chart
        page.setColor(Color.red);
        page.fillArc(200, 200, 400, 400, 0, (int) (360 * 0.35));
        page.setColor(Color.blue);
        page.fillArc(200, 200, 400, 400, (int) (360 * 0.35), 
                (int) (360 * 0.15));
        page.setColor(Color.cyan);
        page.fillArc(200, 200, 400, 400, (int) (360 * 0.5), 
                (int) (360 * 0.15));
        page.setColor(Color.gray);
        page.fillArc(200, 200, 400, 400, (int) (360 * 0.65), 
                (int) (360 * 0.25));
        page.setColor(Color.green);
        page.fillArc(200, 200, 400, 400, (int) (360 * 0.9), 
                (int) (360 * 0.1));
        
        //draw the string
        page.setColor(Color.black);
        Font font = new Font("TimesRoman", Font.BOLD, 20);
        page.setFont(font);
        page.drawString("Rent and Utilities", 400, 190);
        page.drawString("Transportation", 80, 300);
        page.drawString("Food", 150, 480);
        page.drawString("Educational", 380, 625);
        page.drawString("Miscellaneous", 603, 460);
      
    }

}

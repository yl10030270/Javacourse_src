package lab12;

//*********************************************************************
//ReboundPanel.java Author: Lewis/Loftus
//
//Represents the primary panel for the Rebound program.
//*********************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReboundPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final int WIDTH = 300, HEIGHT = 200;
    private final int DELAY = 20, IMAGE_SIZE = 35;
    private ImageIcon image;
    private ImageIcon image2;
    private Timer timer;
    private int x, y, x2, y2;
    private double corebase = Math.sqrt(2 * IMAGE_SIZE * 34);
    private double vX, vY, vX2, vY2;
    private double dx, dy, distance, ax, ay, va, va2, vb, vb2, vaP, vaP2;

    // ------------------------------------------------------------------
    // Sets up the panel, including the timer for the animation.
    // ------------------------------------------------------------------
    public ReboundPanel() {
        timer = new Timer(DELAY, new ReboundListener());
        image = new ImageIcon("./src/lab12/happyFace.gif");
        image2 = new ImageIcon("./src/lab12/happyFace.gif");
        x = 0;
        y = 40;
        vX = vY = 3;
        vX2 = 5;
        vY2 = 8;
        x2 = 20;
        y2 = 80;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        timer.start();
    }

    // -----------------------------------------------------------------
    // Draws the image in the current location.
    // -----------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        image.paintIcon(this, page, x, y);
        image2.paintIcon(this, page, x2, y2);
    }
    // ******************************************************************
    // Represents the action listener for the timer.
    // ******************************************************************
    private class ReboundListener implements ActionListener {
        private int dealspeed(double v){
            if (v >= 0){
                return (int)Math.ceil(v);
            } else {
                return (int)Math.floor(v);
            }
        }
        // --------------------------------------------------------------
        // Updates the position of the image and possibly the direction
        // of movement whenever the timer fires an action event.
        // --------------------------------------------------------------
        public void actionPerformed(ActionEvent event) {
            if (x < 0 || x > getWidth() - IMAGE_SIZE) {
                if (x < 0) {
                    x = 0;
                } else if (x > getWidth() - IMAGE_SIZE) {
                    x = getWidth() - IMAGE_SIZE;
                }
                vX = vX * -1;
            }
            if (y < 0 || y > getHeight() - IMAGE_SIZE) {
                if (y < 0) {
                    y = 0;
                } else if (y > getHeight() - IMAGE_SIZE) {
                    y = getHeight() - IMAGE_SIZE;
                }
                vY = vY * -1;
            }
            if (x2 < 0 || x2 > getWidth() - IMAGE_SIZE) {
                if (x2 < 0) {
                    x2 = 0;
                } else if (x2 > getWidth() - IMAGE_SIZE) {
                    x2 = getWidth() - IMAGE_SIZE;
                }
                vX2 = vX2 * -1;
            }
            if (y2 < 0 || y2 > getHeight() - IMAGE_SIZE) {
                if (y2 < 0) {
                    y2 = 0;
                } else if (y2 > getHeight() - IMAGE_SIZE) {
                    y2 = getHeight() - IMAGE_SIZE;
                }
                vY2 = vY2 * -1;
            }
            dx = x2 - x;
            dy = y2 - y;
            distance = Math.sqrt(dx * dx + dy * dy);
            if (distance < corebase - 10) {
                // System.out.println(Math.floor(-0.3));
                // timer.stop();
                ax = dx / distance;
                ay = dy / distance;
                va = (vX * ax + vY * ay);
                vb = ((-1) * vX * ay + vY * ax);
                va2 = (vX2 * ax + vY2 * ay);
                vb2 = ((-1) * vX2 * ay + vY2 * ax);
                vaP = va2;
                vaP2 = va;
                vX = vaP * ax - vb * ay;
                vY = vaP * ay + vb * ax;
                vX2 = vaP2 * ax - vb2 * ay;
                vY2 = vaP2 * ay + vb2 * ax;
                do {
                    
                    x += dealspeed(vX);
                    y += dealspeed(vY);
                    x2 += dealspeed(vX2);
                    y2 += dealspeed(vY2);
                    dx = x2 - x;
                    dy = y2 - y;
                    distance = Math.sqrt(dx * dx + dy * dy);
                } while (distance < corebase - 10);
            } else {
                x += dealspeed(vX);
                y += dealspeed(vY);
                x2 += dealspeed(vX2);
                y2 += dealspeed(vY2);
                
            }
            repaint();
        }
    }
}

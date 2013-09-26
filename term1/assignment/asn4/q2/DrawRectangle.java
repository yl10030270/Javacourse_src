package q2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
//import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Draws a rectangle using a rubber banding technique. The rectangle size is
 * determined by a mouse drag. Use the original mouse click location as a corner
 * (which corner depends on the drag direction).
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class DrawRectangle extends JFrame {

    /**
     * Default serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Initial size of frame.
     */
    private static final int INITIAL_SIZE = 400;

    /**
     * Constructor:Creates and displays the application frame.
     */
    public DrawRectangle() {
        super("Liang Yang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawRectanglePanel());
        setSize(INITIAL_SIZE, INITIAL_SIZE); // you can change this size but
                                             // don't make it HUGE!
        setVisible(true);
    }

    /**
     * Represents the primary drawing panel for the DrawRectangle program.
     */
    private class DrawRectanglePanel extends JPanel implements MouseListener,
            MouseMotionListener {
        /**
         * Default serial version UID.
         */
        private static final long serialVersionUID = 1L;
        /** First point to draw rectangle. */
        private Point p1;
        /** Second point to draw rectangle. */
        private Point p2;

        /**
         * Constructor: Sets up this panel to listen for mouse events.
         */
        public DrawRectanglePanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.black);
        }

        /**
         * Draws the current rectangle using the initial mouse-pressed point and
         * the current position of the mouse.
         * 
         * @param g
         *            Graphics component to draw on
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // DRAWING CODE HERE
            g.setColor(Color.yellow);
            if (p1 != null && p2 != null) {
                if (p2.x >= getWidth()) {
                    p2.x = getWidth() - 1;
                }
                if (p2.x <= 0) {
                    p2.x = 1;
                }
                if (p2.y >= getHeight()) {
                    p2.y = getHeight() - 1;
                }
                if (p2.y <= 0) {
                    p2.y = 1;
                }
                int width = Math.abs(p2.x - p1.x);
                int height = Math.abs(p2.y - p1.y);
                // Draw the rectangle
                g.drawRect((p1.x < p2.x) ? p1.x : p2.x, (p1.y < p2.y) ? p1.y
                        : p2.y, width, height);
            }
            System.out.println("Paint called");
        }

        /**
         * Captures the initial position at which the mouse button is pressed
         * and print out this method be called.
         * 
         * @param e
         *            Contains position of mouse press
         */
        public void mousePressed(MouseEvent e) {
            p1 = e.getPoint();
            System.out.println("Mouse pressed called");
        }

        /**
         * Captures the final position at which the mouse button is released and
         * print out this method be called.
         * 
         * @param e
         *            Contains position of mouse press
         */
        public void mouseReleased(MouseEvent e) {
            p2 = e.getPoint();
            repaint();
            System.out.println("Mouse released called");
        }

        /**
         * Gets the current position of the mouse as it is dragged and redraws
         * the rectangle to create the rubber-band effect and print out this
         * method be called.
         * 
         * @param e
         *            Contains position where mouse is released
         */
        public void mouseDragged(MouseEvent e) {
            p2 = e.getPoint();
            repaint();
            System.out.println("Mouse dragged called");
        }

        /** {@inheritDoc} */
        public void mouseEntered(MouseEvent e) {
        }

        /** {@inheritDoc} */
        public void mouseExited(MouseEvent e) {
        }

        /** {@inheritDoc} */
        public void mouseClicked(MouseEvent e) {
        }

        /** {@inheritDoc} */
        public void mouseMoved(MouseEvent e) {
        }

    }

    /**
     * Creates and displays the application frame.
     * 
     * @param args
     *            Unused
     */
    public static void main(String[] args) {
        new DrawRectangle();
    }

};

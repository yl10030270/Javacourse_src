package lab11;

//************************************************************************
//CirclePanel.java
//
//Represents the primary panel for the Circles program on which the
//circles are drawn. Derived from the Lewis and Loftus DotsPanel class.
//************************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CirclePanel extends JPanel {
    private final int WIDTH = 600, HEIGHT = 400;
    private Circle circle;

    // -------------------------------------------------------------------
    // Sets up this panel to listen for mouse events.
    // -------------------------------------------------------------------
    public CirclePanel() {
        addMouseListener(new CirclesListener());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    // -------------------------------------------------------------------
    // Draws the current circle, if any.
    // -------------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        if (circle != null)
            circle.draw(page);
    }

    // ******************************************************************
    // Represents the listener for mouse events.
    // ******************************************************************
    private class CirclesListener implements MouseListener {
        // ---------------------------------------------------------------
        // Creates a new circle at the current location whenever the
        // mouse button is pressed and repaints.
        // ---------------------------------------------------------------
        public void mousePressed(MouseEvent event) {
            if (circle == null){
                circle = new Circle(event.getPoint());
            } else if(circle.isInside(event.getPoint())){
                circle = null;
            }else {
                circle.move(getMousePosition());
            }
            repaint();
        }

        // -----------------------------------------------------------------
        // Provide empty definitions for unused event methods.
        // -----------------------------------------------------------------
        public void mouseClicked(MouseEvent event) {
        }

        public void mouseReleased(MouseEvent event) {
        }

        public void mouseEntered(MouseEvent event) {
            setBackground(Color.white);
        }

        public void mouseExited(MouseEvent event) {
            setBackground(Color.blue);
        }
    }
}

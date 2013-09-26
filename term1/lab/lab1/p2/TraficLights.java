package p2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * <p>
 * A Traffic lights class, push one button to change the state of the Traffic
 * lights which cycle through green -> amber -> red -> and back to green each
 * time the button is pressed.
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class TraficLights extends JFrame {

    private JButton button;
    private int count;
    private Circle redlight = new Circle(100, Color.red.darker(), 25, 15);
    private Circle orangelight = new Circle(100, Color.orange.darker(), 25, 120);
    private Circle greenlight = new Circle(100, Color.green.darker(), 25, 225);
    
    

    /**
     * <p>
     * The default constructor which sets the title of this app, sets the
     * default close operation to exit, creates a new content pane and finally
     * sets size and sets the visibility of this frame to true (show).
     * </p>
     */
    public TraficLights() {
        super("LIANG YANG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Change");
        button.addActionListener(new ButtonListener());
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(new DrawingPanel());
        panel.setBackground(new Color(236, 118, 0));

        getContentPane().add(panel);

        setSize(200, 420);
        setVisible(true);
    }
    /**
     * Represents a listener for button push (action) events.
     */
    private class ButtonListener implements ActionListener {
        /**
         * Updates the counter and label when the button is pushed.
        * @param event The event produced by the button when it is pressed
        */
        public void actionPerformed(ActionEvent event) {
            count++;
            if (count % 3 == 0) {
                redlight.setColor(Color.red);
            } else if (count % 3 == 1) {
                orangelight.setColor(Color.orange);
            } else {
                greenlight.setColor(Color.green);
            }
            new TraficLights();
        }
        
        
    }

    class DrawingPanel extends JPanel {
        
        public DrawingPanel() {
            setPreferredSize(new Dimension(150, 340));
            setBackground(new Color(193, 97, 0));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // replace this with your drawing code
            //g.drawString("Traffic light!", 20, 40);
            
            redlight.draw(g);
            orangelight.draw(g);
            greenlight.draw(g);
            
            //darkergreenlight.draw(g);
        }
    }
    
    /**
     * <p>
     * The main method.
     * </p>
     */
    public static void main(String[] args) {
        new TraficLights();
    }

};

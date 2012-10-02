package q5;

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
public class TrafficLight extends JFrame {
    /** Unique version of this frame. */
    private static final long serialVersionUID = 1L;
    /** Vertical location of red light. */
    private final int redy = 15;
    /** Vertical location of amber light. */
    private final int ambery = 120;
    /** Vertical location of green light. */
    private final int greeny = 225;
    /** Background color R value. */
    private final int bgcr = 236;
    /** Background color G value. */
    private final int bgcg = 118;
    /** Background color B value. */
    private final int bgcb = 0;
    /** Frame width. */
    private final int fw = 200;
    /** Frame height. */
    private final int fh = 420;
    /** loop base. */
    private final int loopbase = 3;
    /** the change button . */
    private JButton button;
    /** Holds the number of time the button is pressed. */
    private int count;
    /** instantiate the red light. */
    private Circle redlight = new Circle(Color.red.darker(), redy);
    /** instantiate the amber light. */
    private Circle amberlight = new Circle(Color.orange.darker(), ambery);
    /** instantiate the green light. */
    private Circle greenlight = new Circle(Color.green.darker(), greeny);
    /** display the traffic light. */
    private JPanel panel;

    /**
     * <p>
     * The default constructor which sets the title of this app, sets the
     * default close operation to exit, creates a new content pane and finally
     * sets size and sets the visibility of this frame to true (show).
     * </p>
     */
    public TrafficLight() {
        super("LIANG YANG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Change");
        button.addActionListener(new ButtonListener());
        panel = new JPanel();
        panel.add(button);
        panel.add(new DrawingPanel());
        panel.setBackground(new Color(bgcr, bgcg, bgcb));

        getContentPane().add(panel);

        setSize(fw, fh);
        setVisible(true);
    }

    /**
     * Represents a listener for button push (action) events.
     */
    private class ButtonListener implements ActionListener {
        /**
         * Updates the counter and label when the button is pushed.
         * 
         * @param event
         *            The event produced by the button when it is pressed
         */
        public void actionPerformed(ActionEvent event) {
            if (count % loopbase == 0) {
                redlight.setColor(Color.red);
                amberlight.setColor(Color.orange.darker());
                greenlight.setColor(Color.green.darker());
            } else if (count % loopbase == 1) {
                redlight.setColor(Color.red.darker());
                amberlight.setColor(Color.orange);
                greenlight.setColor(Color.green.darker());
            } else {
                redlight.setColor(Color.red.darker());
                amberlight.setColor(Color.orange.darker());
                greenlight.setColor(Color.green);
            }
            panel.updateUI();
            count++;
        }
    }

    /**
     * <p>
     * Draw the Traffic light.
     * </p>
     * 
     * @author Liang yang
     * @version 1
     */
    class DrawingPanel extends JPanel {

        /** unique version of this panel. */
        private static final long serialVersionUID = 1L;
        /** Panel width.*/
        private final int panelw = 150;
        /** Panel height.*/
        private final int panelh = 340;
        /** Panel background color R value.*/
        private final int pbcr = 193;
        /** Panel background color G value.*/
        private final int pbcg = 97;
        /** Panel background color B value.*/
        private final int pbcb = 0;
        
        /**
         * Set the size and background of this panel.
         */
        public DrawingPanel() {
            setPreferredSize(new Dimension(panelw, panelh));
            setBackground(new Color(pbcr, pbcg, pbcb));
        }

        /**
         * Draws the Traffic lights.
         * 
         * @param g
         *            The graphics object upon which to draw
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // replace this with your drawing code
            // g.drawString("Traffic light!", 20, 40);
            redlight.draw(g);
            amberlight.draw(g);
            greenlight.draw(g);
        }
    }

    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        new TrafficLight();
    }

};

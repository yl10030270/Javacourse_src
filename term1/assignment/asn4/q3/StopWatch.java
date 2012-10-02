package q3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * <p>
 * An application that works as a stop-watch. 
 * Changes from version 1.0: 
 * 1.You can not reset the watch if it's running. 
 *   Reset Button only work when the watch stop. 
 * 2.Delete the extra Timer Action ActionListener. 
 *   Integrate it with Button Listener. 
 * Changes from version 2.0: 
 * 1.fix the bug: when the watch stop, 
 *   click the "stop" button, the watch go up one centi-second
 * </p>
 * 
 * @author Liang Yang
 * @version 2.1
 */
public class StopWatch extends JFrame {
    /**
     * Default serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Initial width of frame.
     */
    private static final int INITIAL_WIDTH = 300;
    /**
     * Initial height of frame.
     */
    private static final int INITIAL_HEIGHT = 150;

    /**
     * Constructor:Creates and displays the application frame.
     */
    public StopWatch() {
        super("Liang Yang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new StopWatchPanel());
        setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        setVisible(true);
    }

    /**
     * Represents the stop-watch panel for this program.
     */
    private class StopWatchPanel extends JPanel {
        /** Default serial version UID. */
        private static final long serialVersionUID = 1L;
        /** Initial timer dealy. */
        private static final int INITIAL_DELAY = 10;
        /** Initial font size. */
        private static final int FONT_SIZE = 36;
        /** represent the minute in the watch. */
        private int minute;
        /** represent the second in the watch. */
        private int second;
        /** represent the centi-second in the watch. */
        private int centisec;
        /** Show the timer. */
        private JLabel watch;
        /** Hold the watch label. */
        private JPanel watchPanel;
        /** Hold the button. */
        private JPanel buttonPanel;
        /** start button. */
        private JButton start;
        /** stop button. */
        private JButton stop;
        /** reset button. */
        private JButton reset;
        /** Timer to be used for watch. */
        private Timer timer;
        /** Timer delay. */
        private int delay = INITIAL_DELAY;
        /** Button listener. */
        private ActionListener b = new ButtonListener();

        /**
         * Constructor: Sets up this panel to listen for mouse events.
         */
        public StopWatchPanel() {
            setLayout(new BorderLayout());
            setBackground(Color.white);
            watchPanel = new JPanel();
            watch = new JLabel("00:00:00", JLabel.CENTER);
            watch.setForeground(Color.blue);
            watch.setFont(new Font("Helvetica", Font.PLAIN, FONT_SIZE));
            watchPanel.add(watch);
            add(watchPanel, BorderLayout.NORTH);
            buttonPanel = new JPanel();
            start = new JButton("start");
            stop = new JButton("stop");
            reset = new JButton("reset");
            start.addActionListener(b);
            stop.addActionListener(b);
            reset.addActionListener(b);
            buttonPanel.add(start);
            buttonPanel.add(stop);
            buttonPanel.add(reset);
            add(buttonPanel, BorderLayout.CENTER);
            timer = new Timer(delay, b);
        }

        /**
         * Represents a listener for button push (action) events.
         */
        private class ButtonListener implements ActionListener {

            /**
             * Updates the watch label when button is pushed.
             * 
             * @param event
             *            Indicates a button is pushed
             */
            public void actionPerformed(ActionEvent event) {
                final int timebase = 60;
                final int centsecbase = 99;
                final int showbase = 10;
                if (minute == timebase && second == timebase
                        && centisec == centsecbase) {
                    minute = 0;
                    second = 0;
                    centisec = 0;
                }
                centisec++;
                if (second == timebase) {
                    minute++;
                    second = 0;
                }
                if (centisec == centsecbase) {
                    second++;
                    centisec = 0;
                }
                if (event.getSource() == start) {
                    timer.start();
                } else if (event.getSource() == stop) {
                    centisec--;
                    timer.stop();
                } else {
                    if (!timer.isRunning()) {
                        timer.stop();
                        minute = 0;
                        second = 0;
                        centisec = 0;
                        watch.setText("00:00:00");
                    }
                }
                watch.setText(((minute < showbase) ? "0" : "") + minute + ":"
                        + ((second < showbase) ? "0" : "") + second + ":"
                        + ((centisec < showbase) ? "0" : "") + centisec);
            }
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
        new StopWatch(); // your code will go here!!!
        System.out.println("Question three was called and ran sucessfully.");
    }

};

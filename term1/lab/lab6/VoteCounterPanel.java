package lab6;

//************************************************************
//VoteCounterPanel.java
//
//Demonstrates a graphical user interface and event listeners to
//tally votes for two candidates, Joe and Sam.
//************************************************************
import java.awt.*;
import java.awt.event.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

public class VoteCounterPanel extends JPanel {
    private int votesForJoe;
    private int votesForSam;
    private JButton joe;
    private JButton sam;
    private JLabel labelJoe;
    private JLabel labelSam;
    private JLabel result;
    private ButtonListener b = new ButtonListener();

    // ------------------------------------------------
    // Constructor: Sets up the GUI.
    // ------------------------------------------------
    public VoteCounterPanel() {
        votesForJoe = 0;
        votesForSam = 0;
        joe = new JButton("Vote for Joe");
        sam = new JButton("Vote for Sam");
        sam.addActionListener(b);
        joe.addActionListener(b);
        labelJoe = new JLabel("Votes for Joe: " + votesForJoe);
        labelSam = new JLabel("Votes for Sam: " + votesForSam);
        result = new JLabel("The winner is: ");
        add(joe);
        add(labelJoe);
        add(sam);
        add(labelSam);
        add(result);
        setPreferredSize(new Dimension(280, 100));
        setBackground(Color.cyan);
    }

    // **************************************************
    // Represents a listener for button push (action) events
    // **************************************************
    private class ButtonListener implements ActionListener {
        // ---------------------------------------------
        // Updates the counter and label when Vote for Joe
        // button is pushed
        // ---------------------------------------------
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == joe) {
                votesForJoe++;
                labelJoe.setText("Votes for Joe: " + votesForJoe);
            } else {
                votesForSam++;
                labelSam.setText("Votes for Sam: " + votesForSam);
            }
            if (votesForJoe == votesForSam) {
                result.setText("They are even. ");
            } else {
                result.setText("The winner is "
                        + ((votesForJoe > votesForSam) ? "Joe" : "Sam"));
            }
        }
    }

}
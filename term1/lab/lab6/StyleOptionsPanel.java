package lab6;

//************************************************************
//StyleOptionsPanel.java Author: Lewis/Loftus
//
//Demonstrates the use of check boxes.
//************************************************************
import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class StyleOptionsPanel extends JPanel {
    private int fontSize = 36;
    private int style = Font.PLAIN;
    private JLabel saying;
    private JCheckBox bold, italic;
    private JRadioButton small, medium, large; 
    // --------------------------------------------------------------
    // Sets up a panel with a label and some check boxes that
    // control the style of the label's font.
    // --------------------------------------------------------------
    public StyleOptionsPanel() {
        saying = new JLabel("Say it with style!");
        saying.setFont(new Font("Helvetica", style, fontSize));
        bold = new JCheckBox("Bold");
        bold.setBackground(Color.cyan);
        italic = new JCheckBox("Italic");
        italic.setBackground(Color.cyan);
        
        small = new JRadioButton("small font");
        small.setBackground(Color.cyan);
        medium = new JRadioButton("medium font");
        medium.setBackground(Color.cyan);
        large = new JRadioButton("large font");
        large.setBackground(Color.cyan);
        
        ButtonGroup group = new ButtonGroup();
        group.add(small);
        group.add(medium);
        group.add(large);
        
        FontListener fontlistener = new FontListener();
        small.addActionListener(fontlistener);
        medium.addActionListener(fontlistener);
        large.addActionListener(fontlistener);
        
        StyleListener listener = new StyleListener();
        bold.addItemListener(listener);
        italic.addItemListener(listener);
        add(saying);
        add(bold);
        add(italic);
        add(small);
        add(medium);
        add(large);
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(300, 150));
    }

    // ************************************************************
    // Represents the listener for both check boxes.
    // ************************************************************
    private class StyleListener implements ItemListener {
        // -----------------------------------------------------
        // Updates the style of the label font style.
        // -----------------------------------------------------
        public void itemStateChanged(ItemEvent event) {
            style = Font.PLAIN;
            if (bold.isSelected())
                style = Font.BOLD;
            if (italic.isSelected())
                style += Font.ITALIC;
            saying.setFont(new Font("Helvetica", style, fontSize));
        }
    }
    private class FontListener implements ActionListener {
        /**
        * Sets the text of the label depending on which radio
        * button was pressed.
        * @param event indicates which button was pressed
        */
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source == small) {
                fontSize = 12;
            } else if (source == medium) {
                fontSize = 24;
            } else {
                fontSize = 36;
            }
            saying.setFont(new Font("Helvetica", style, fontSize));
        }
    }
}
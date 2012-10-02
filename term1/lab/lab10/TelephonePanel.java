package lab10;

//************************************************************
//TelephonePanel.java
//
//Lays out a (functionless) GUI like a telephone keypad with a title.
//Illustrates use of BorderLayout and GridLayout.
//************************************************************
import java.awt.*;

import javax.swing.*;

public class TelephonePanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public TelephonePanel() {
        setLayout(new BorderLayout());// set BorderLayout for this panel
        JPanel titlePan = new JPanel();
        JLabel title = new JLabel("Your Telephone",JLabel.CENTER);// create a JLabel with "Your Telephone" title
        titlePan.add(title);
        add(titlePan, BorderLayout.NORTH);// add title label to north of this panel
        JPanel numPanel = new JPanel();// create panel to hold keypad and give it a 4x3 GridLayout
        // add buttons representing keys to key panel
        add(numPanel,BorderLayout.CENTER);
        JButton[] num = new JButton[12];
        for (int i = 0;i <= 9;i++){
            num[i] = new JButton("" + i);
        }
        num[10] = new JButton("*");
        num[11] = new JButton("#");
        numPanel.setLayout(new GridLayout(4, 3));
        // add key panel to center of this panel
        for (int i = 0; i < 12; i++){
            numPanel.add(num[i]);
        }
    }
}

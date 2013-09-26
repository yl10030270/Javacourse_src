package lab10;

//************************************************************
//Telephone.java
//
//Uses the TelephonePanel class to create a (functionless) GUI
//like a telephone keypad with a title.
//Illustrates use of BorderLayout and GridLayout.
//************************************************************
import javax.swing.*;

public class Telephone {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Telephone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TelephonePanel());
        frame.pack();
        frame.setVisible(true);
    }
}

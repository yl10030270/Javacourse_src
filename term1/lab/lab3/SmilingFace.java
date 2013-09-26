package q;
import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class SmilingFace extends JApplet {
    
    public void paint (Graphics page){
        setBackground(Color.green);
        page.setColor(getBackground());
        page.fillRect(0, 0, getWidth(), getHeight());
        
        // ears
        page.setColor(Color.black);
        page.fillOval(16 , 50 , 44 , 40);//left outside
        page.fillOval(140 , 50 , 44 , 40);//right outside
        page.setColor(Color.white);
        page.fillOval(151 , 60 , 22 , 20);//right inside
        page.fillOval(27 , 60 , 22 , 20);//left inside
        
        //head
        page.fillOval(20 , 50 , 160 , 130);
        
        //nose
        page.setColor(Color.black);
        page.fillOval(95 , 120 , 10 , 10);
        page.drawLine(100, 130, 100, 145);
       
        //mouth
        page.drawArc(75 , 115 , 50 , 35 , 180 , 180);
        
        //eyes
        page.fillOval(60 , 80 , 30 , 40);//left outside
        page.fillOval(110, 80 , 30 , 40);//right outside
        page.setColor(Color.white);
        page.fillOval(68 , 94 , 18 , 18);//left inside
        page.fillOval(114 , 94 , 18 , 18);//right inside
        page.setColor(Color.black);
        page.fillOval(76, 100, 7, 7);//left pupils
        page.fillOval(117, 100, 7, 7);//right pupils      
        
    }

}

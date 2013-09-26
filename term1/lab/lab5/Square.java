package lab5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Square {

    private int size;
    private int x;
    private int y;
    private Color color;
    private static Random generator = new Random();
    
    public Square(int squColor){
        
        Color c = new Color(squColor);
        this.size = generator.nextInt(101) + 100;
        this.x = generator.nextInt(601);
        this.y = generator.nextInt(401);
        this.color = c;
       
        
    }
    
    public void draw(Graphics page) {
        page.setColor(color);
        page.fillRect(x, y, size, size);
    }
}

package q5;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a circle with a particular position, size, and color.
 *
 * @author Lewis
 * @author Loftus
 * @version 1
 */
public class Circle {
    /** Diameter of circle. */
    private final int diameter = 100;
    /** Horizontal location of circle. Top left corner of bounding box.*/
    private final int x = 25;
    /** Vertical location of circle. Top left corner of bounding box.*/
    private int y;
    /** color of circle. */
    private Color color;

    /**
     * Constructor: Sets up this circle with the specified values.
     * @param shade The colour of the circle
     * @param upperY The vertical location of the circle
     */
    public Circle(Color shade, int upperY) {
        color = shade;
        y = upperY;
    }

    /**
     * Draws this circle in the specified graphics context.
     * @param page The graphics object upon which to draw
     */
    public void draw(Graphics page) {
        page.setColor(color);
        page.fillOval(x, y, diameter, diameter);
    }

    /**
     * Color mutator.
     * @param shade The new colour of the circle
     */
    public void setColor(Color shade) {
        color = shade;
    }

    /**
     * Y mutator.
     * @param upperY The new vertical location of the circle
     */
    public void setY(int upperY) {
        y = upperY;
    }

    /**
     * Diameter accessor.
     * @return The current diameter of the circle
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * Color accessor.
     * @return The current colour of the circle
     */
    public Color getColor() {
        return color;
    }

    /**
     * X accessor.
     * @return The current horizontal position of the circle
     */
    public int getX() {
        return x;
    }

    /**
     * Y accessor.
     * @return The current vertical position of the circle
     */
    public int getY() {
        return y;
    }
}

package p2;

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
    private int diameter;
    /** Horizontal location of circle. Top left corner of bounding box.*/
    private int x;
    /** Vertical location of circle. Top left corner of bounding box.*/
    private int y;
    /** colour of circle. */
    private Color color;

    /**
     * Constructor: Sets up this circle with the specified values.
     * @param size The diameter of the circle
     * @param shade The colour of the circle
     * @param upperX The horizontal location of the circle
     * @param upperY The vertical location of the circle
     */
    public Circle(int size, Color shade, int upperX, int upperY) {
        diameter = size;
        color = shade;
        x = upperX;
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
     * Diameter mutator.
     * @param size The new diameter
     */
    public void setDiameter(int size) {
        diameter = size;
    }

    /**
     * Color mutator.
     * @param shade The new colour of the circle
     */
    public void setColor(Color shade) {
        color = shade;
    }

    /**
     * X mutator.
     * @param upperX The new horizontal location of the circle
     */
    public void setX(int upperX) {
        x = upperX;
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

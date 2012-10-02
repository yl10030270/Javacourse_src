package q4;


/**
 * <p>
 * Represents one box which contains instance data for the height, width, depth,
 * and the the situation(full or not).
 * </p>
 * 
 * @author Liang yang
 * @version 1
 */
public class Box {
    /** Box height. */
    private double height;
    /** Box width. */
    private double width;
    /** Box depth. */
    private double depth;
    /** Box situation which is full or not. */
    private boolean full;

    /**
     * Constructor.
     * 
     * @param h
     *            represents the height
     * @param w
     *            represents the width
     * @param d
     *            represents the depth
     */
    public Box(double h, double w, double d) {
        height = h;
        width = w;
        depth = d;
        full = false;
    }

    /**
     * Box height mutator.
     * 
     * @param h
     *            The height for the box
     */
    public void setHeight(double h) {
        height = h;
    }

    /**
     * Box width mutator.
     * 
     * @param w
     *            The width for the box
     */
    public void setWidth(double w) {
        width = w;
    }

    /**
     * Box depth mutator.
     * 
     * @param d
     *            The depth for the box
     */
    public void setDepth(double d) {
        depth = d;
    }

    /**
     * Box height mutator.
     */
    public void setFull() {
        full = true;
    }

    /**
     * Box height accessor.
     * 
     * @return The height of the box
     */
    public double getHeight() {
        return height;
    }

    /**
     * Box width accessor.
     * 
     * @return The width of the box
     */
    public double getWidth() {
        return width;
    }

    /**
     * Box depth accessor.
     * 
     * @return The depth of the box
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Box situation accessor.
     * 
     * @return The if the box is full or not
     */
    public boolean getFull() {
        return full;
    }

    /**
     * Returns a string representation of this box.
     * 
     * @return The representation of the box
     */
    public String toString() {
        if (full) {
            return "This is a full box.Its height is " + height + ", width is "
                    + width + " and depth is " + depth;
        } else {
            return "This is a empty box.Its height is " + height + ", width is "
                    + width + " and depth is " + depth;
        }
    }
}

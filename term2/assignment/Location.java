/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * A location (row/column) on a rectangle.
 *
 * @version 1.0
 * @author leon
 */
public final class Location
{
    /**
     * The row of the Location.
     */
    private final int row;

    /**
     * The column of the Location.
     */
    private final int column;

    /**
     * The area.
     */
    private final Rectangle rectangle;

    /**
     * Class constructor.
     *
     * @param r    - the row of the location
     * @param c    - the column of the location
     * @param rect - the area
     */
    private Location(final int r,
                     final int c,
                     final Rectangle rect)
    {
        row = r;
        column = c;
        rectangle = rect;
    }

    /**
     * Create a location with the specified row/col bounded by the world.
     *
     * @param row    - the row of the location
     * @param column - the column of the location
     * @param bounds - the size of the area
     *
     * @return the location
     */
    public static Location create(final int row,
                                  final int column,
                                  final Rectangle bounds)
    {
        final Location location;

        if(bounds == null)
        {
            throw new IllegalArgumentException("bounds cannot be null");
        }
        if(row < 0)
        {
            throw new IllegalArgumentException("row too low, was " + row + " must be >= 0");
        }

        if(column < 0)
        {
            throw new IllegalArgumentException("column too low, was " + column + " must be >= 0");
        }

        if(row > bounds.getNumberOfRows() - 1)
        {
            throw new IllegalArgumentException(
                    "row too high, was " + row + " must be <= " + (bounds.getNumberOfRows() - 1));
        }

        if(column > bounds.getNumberOfColumns() - 1)
        {
            throw new IllegalArgumentException(
                    "column too high, was " + column + " must be <= " + (bounds.getNumberOfColumns() - 1));
        }

        location = new Location(row,
                                column,
                                bounds);

        return location;

    }

    /**
     * Get the row.
     *
     * @return the row.
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Get the column.
     *
     * @return the column
     */
    public int getColumn()
    {
        return column;
    }

    /**
     * Get the size of the area.
     *
     * @return the size of the area.
     */
    public Rectangle getRectangle()
    {
        return rectangle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return "[" + row + ", " + column + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj)
    {
        final boolean retval;

        if(obj == null)
        {
            retval = false;
        }
        else
        {
            if(getClass() == obj.getClass())
            {
                final Location other = (Location)obj;

                if(this.row == other.row &&
                        this.column == other.column &&
                        this.rectangle.getNumberOfColumns() == other.rectangle.getNumberOfColumns() &&
                        this.rectangle.getNumberOfRows() == other.rectangle.getNumberOfRows())
                {
                    retval = true;
                }
                else
                {
                    retval = false;
                }

            }
            else
            {
                retval = false;
            }
        }

        return retval;
    }

    /**
     * Get the hash code. The formula is ((row*rows)+row)+column
     *
     * @return the hash code.
     */
    @Override
    public int hashCode()
    {
        final int rows;
        final int code;

        rows = rectangle.getNumberOfRows() - 1;
        code = ((row * rows) + row) + column;

        return code;

    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * A world that has access to the mutable tiles.
 *
 * @author Leon
 * @version 1.0
 */
public class DefaultMutableWorld
    extends DefaultWorld
    implements MutableWorld
{
    /**
     * Construct a Mutableworld with the specified number of rows and columns.
     *
     * @param rows    - the number of rows in the world
     * @param columns - the number of columns on each row of the world
     * @param bounds  - the min/max size of the rows/columns
     *
     * @throws TooFewRowsException     - if the rows is less than minimum rows in the bounds
     * @throws TooManyRowsException    - if the columns is less than the minimum columns in the bounds
     * @throws TooFewColumnsException  - if the rows is greater than the maximum rows in the bounds
     * @throws TooManyColumnsException - if the rows is greater than the maximum columns in the bounds
     */
    public DefaultMutableWorld(final int rows,
                               final int columns,
                               final WorldBounds bounds)
        throws TooFewRowsException,
               TooManyRowsException,
               TooFewColumnsException,
               TooManyColumnsException
    {
        super(rows,
              columns,
              bounds);
    }

    /**
     * Create a tile for a particular location on the world.
     *
     * @param row    - the row the tile is on.
     * @param column - the col the tile is on.
     *
     * @return a new tile with the specified location.
     */
    @Override
    protected MutableTile createTile(final int row,
                                     final int column)
    {
        return new MutableTile(Location.create(row,
                                               column,
                                               this),
                               this);
    }

    /**
     * Get the mutable tile at the specified location.
     *
     * @param location - the location of the tile to get.
     *
     * @return the tile at the specified location.
     */
    @Override
    public MutableTile getTileAt(final Location location)
    {
        if(location.getRectangle() != this)
        {
            throw new IllegalArgumentException("cannot use a different rectangle");
        }
        return (MutableTile)tiles[location.getRow()][location.getColumn()];
    }

}

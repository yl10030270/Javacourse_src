/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * A collection of tiles that make up a map.
 *
 * @author Leon
 * @version 1.0
 */
public class DefaultWorld
    implements World
{
    /**
     * the number of rows in the world.
     */
    private final int r;

    /**
     * the number of columns on each row of the world.
     */
    private final int c;

    /**
     * the tiles of the world.
     */
    protected final Tile[][] tiles;

    /**
     * Construct a world with the specified number of rows and columns.
     *
     * @param rows    the number of rows in the world
     * @param columns the number of columns on each row of the world
     * @param bounds  the min/max size of the rows/columns
     *
     * @throws TooFewRowsException     - if the rows is less than minimum rows in the bounds
     * @throws TooManyRowsException    - if the columns is less than the minimum columns in the bounds
     * @throws TooFewColumnsException  - if the rows is greater than the maximum rows in the bounds
     * @throws TooManyColumnsException - if the rows is greater than the maximum columns in the bounds
     */
    public DefaultWorld(final int rows,
                        final int columns,
                        final WorldBounds bounds)
        throws TooFewRowsException,
               TooManyRowsException,
               TooFewColumnsException,
               TooManyColumnsException
    {
        if(bounds == null)
        {
            throw new IllegalArgumentException("bounds cannot be null");
        }
        bounds.checkIsInBounds(rows,
                               columns);
        tiles = new Tile[rows][columns];
        r = rows;
        c = columns;
    }

    /**
     * initialize the tiles on the world.
     */
    @Override
    public final void init()
    {
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                tiles[i][j] = createTile(i,
                                         j);
            }
        }
    }

    /**
     * Create a tile for a particular location on the world.
     *
     * @param row    - the row the tile is on.
     * @param column - the col the tile is on.
     *
     * @return a new tile with the specified location.
     */
    protected Tile createTile(final int row,
                              final int column)
    {
        return new Tile(Location.create(row,
                                        column,
                                        this),
                        this);
    }

    /**
     * Get the number of rows on the world.
     *
     * @return the number of rows on the world.
     */
    @Override
    public int getNumberOfRows()
    {
        return r;
    }

    /**
     * Get the number of columns on the world.
     *
     * @return the number of columns on the world.
     */
    @Override
    public int getNumberOfColumns()
    {
        return c;
    }

    /**
     * Get the tile at the specified location.
     *
     * @param location - the location of the tile to get.
     *
     * @return the tile at the specified location.
     */
    @Override
    public Tile getTileAt(final Location location)
    {
        if(location == null)
        {
            throw new IllegalArgumentException("location cannot be null");
        }
        if(location.getRectangle() != this)
        {
            throw new IllegalArgumentException("cannot use a different rectangle");
        }
        return tiles[location.getRow()][location.getColumn()];
    }

    /**
     * Get all the tiles on the world.
     *
     * @return all of the tiles on the world.
     */

}

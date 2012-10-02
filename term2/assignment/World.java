/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


/**
 *
 * @author leon
 */
public class World
{
    /**
     *
     */
    protected final MutableTile[][] tiles;
    private int NumberOfRows;
    private int NumberOfCols;

    public World(int rows,
                 int cols)
    {
        NumberOfRows = rows;
        NumberOfCols = cols;
        tiles = new MutableTile[rows][cols];
    }

    /**
     *
     * @return
     */
    public int getNumberOfRows()
    {
        return NumberOfRows;
    }

    /**
     *
     * @return
     */
    public int getNumberOfCols()
    {
        return NumberOfCols;
    }

    /**
     *
     * @param location
     * @return
     */
    public Tile getTileAt(Location location)
    {
        return tiles[location.getRow() + 1][location.getColumn() + 1];
    }

    /**
     *
     * @return
     */
    public Tile[][] getTiles()
    {
        return tiles;
    }
}
